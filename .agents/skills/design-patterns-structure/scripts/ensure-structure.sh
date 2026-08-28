#!/usr/bin/env bash

set -euo pipefail

export LC_ALL=C
shopt -s nullglob dotglob

readonly PACKAGE_ROOT="io.github.hhcarlos.designpatterns"
readonly PACKAGE_PATH="io/github/hhcarlos/designpatterns"

CATEGORIES=(
    creational
    structural
    behavioral
    playground
)

PATTERNS=(
    creational:abstractfactory
    creational:factorymethod
    creational:builder
    creational:prototype
    creational:singleton
    structural:adapter
    structural:bridge
    structural:composite
    structural:decorator
    structural:facade
    structural:flyweight
    structural:proxy
    behavioral:chainofresponsibility
    behavioral:command
    behavioral:interpreter
    behavioral:iterator
    behavioral:mediator
    behavioral:memento
    behavioral:observer
    behavioral:state
    behavioral:strategy
    behavioral:templatemethod
    behavioral:visitor
)

DRIFT_DETECTED=0
RESULT_EMITTED=0

emit_result() {
    RESULT_EMITTED=1
    printf '%s\n' "$1"
}

report_drift() {
    DRIFT_DETECTED=1
    printf 'DRIFT: %s\n' "$1" >&2
}

handle_exit() {
    local status=$?

    if [[ $status -ne 0 && $RESULT_EMITTED -eq 0 ]]; then
        printf '%s\n' \
            'DRIFT: The structure check failed unexpectedly.' >&2
        printf '%s\n' 'BLOCKED_STRUCTURE_DRIFT'
    fi
}

trap handle_exit EXIT

REPOSITORY_ROOT="$(git rev-parse --show-toplevel 2>/dev/null || true)"

if [[ -z "$REPOSITORY_ROOT" ]]; then
    report_drift 'The command must run inside a Git repository.'
    emit_result 'BLOCKED_STRUCTURE_DRIFT'
    exit 1
fi

readonly SOURCE_ROOT="$REPOSITORY_ROOT/src/main/java/$PACKAGE_PATH"

directory_is_empty() {
    local entries=("$1"/*)
    [[ ${#entries[@]} -eq 0 ]]
}

is_protected_category() {
    local expected="$1"
    local category

    for category in "${CATEGORIES[@]}"; do
        if [[ "$category" == "$expected" ]]; then
            return 0
        fi
    done

    return 1
}

is_pattern_in_category() {
    local expected_category="$1"
    local expected_pattern="$2"
    local specification

    for specification in "${PATTERNS[@]}"; do
        if [[ \
            "$specification" == "$expected_category:$expected_pattern" \
        ]]; then
            return 0
        fi
    done

    return 1
}

category_title() {
    case "$1" in
        creational)
            printf '%s' 'Creational'
            ;;
        structural)
            printf '%s' 'Structural'
            ;;
        behavioral)
            printf '%s' 'Behavioral'
            ;;
        *)
            return 1
            ;;
    esac
}

create_main_file() {
    local destination="$1"
    local package_name="$2"

    cat > "$destination" <<EOF
package ${package_name};

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
    }
}
EOF
}

create_structure() {
    local category
    local title
    local specification
    local pattern

    mkdir -p "$SOURCE_ROOT"

    for category in creational structural behavioral; do
        title="$(category_title "$category")"
        mkdir -p "$SOURCE_ROOT/$category"

        cat > "$SOURCE_ROOT/$category/README.md" <<EOF
# ${title} patterns

This category contains isolated design pattern examples.
EOF
    done

    for specification in "${PATTERNS[@]}"; do
        category="${specification%%:*}"
        pattern="${specification#*:}"

        mkdir -p "$SOURCE_ROOT/$category/$pattern"

        create_main_file \
            "$SOURCE_ROOT/$category/$pattern/Main.java" \
            "$PACKAGE_ROOT.$category.$pattern"
    done

    mkdir -p "$SOURCE_ROOT/playground"

    cat > "$SOURCE_ROOT/playground/README.md" <<'EOF'
# Design Patterns playground

Use this package for scenario-based experiments that combine multiple design patterns.

Playground code may depend on canonical pattern packages. Canonical pattern code must
never depend on playground code.
EOF
}

validate_package_declaration() {
    local java_file="$1"
    local expected_package="$2"
    local escaped_package="${expected_package//./\\.}"

    if ! grep -Eq \
        "^[[:space:]]*package[[:space:]]+${escaped_package}[[:space:]]*;" \
        "$java_file"; then
        report_drift \
            "$java_file must declare package $expected_package."
    fi
}

validate_main_file() {
    local main_file="$1"
    local expected_package="$2"

    if [[ ! -f "$main_file" || -L "$main_file" ]]; then
        report_drift "Missing or invalid launcher: $main_file."
        return
    fi

    validate_package_declaration "$main_file" "$expected_package"

    if ! tr '\n' ' ' < "$main_file" |
        grep -Eq \
        'public[[:space:]]+(final[[:space:]]+)?class[[:space:]]+Main([[:space:]]|\{|$)'; then
        report_drift \
            "$main_file must declare public class Main."
    fi

    if ! tr '\n' ' ' < "$main_file" |
        grep -Eq \
        'public[[:space:]]+static[[:space:]]+void[[:space:]]+main[[:space:]]*\('; then
        report_drift \
            "$main_file must declare public static void main."
    fi
}

validate_pattern() {
    local category="$1"
    local pattern="$2"
    local directory="$SOURCE_ROOT/$category/$pattern"
    local expected_package="$PACKAGE_ROOT.$category.$pattern"
    local entry
    local name

    if [[ ! -d "$directory" || -L "$directory" ]]; then
        report_drift \
            "Missing or invalid pattern package: $category/$pattern."
        return
    fi

    validate_main_file \
        "$directory/Main.java" \
        "$expected_package"

    for entry in "$directory"/*; do
        name="${entry##*/}"

        if [[ -d "$entry" ]]; then
            report_drift \
                "Subpackages are not allowed in $category/$pattern: $name."
        elif [[ ! -f "$entry" || -L "$entry" ]]; then
            report_drift \
                "Invalid entry in $category/$pattern: $name."
        elif [[ "$name" != *.java ]]; then
            report_drift \
                "Only Java files are allowed in $category/$pattern: $name."
        else
            validate_package_declaration \
                "$entry" \
                "$expected_package"
        fi
    done
}

validate_category() {
    local category="$1"
    local directory="$SOURCE_ROOT/$category"
    local specification
    local pattern
    local entry
    local name

    if [[ ! -d "$directory" || -L "$directory" ]]; then
        report_drift "Missing or invalid category: $category."
        return
    fi

    if [[ \
        ! -f "$directory/README.md" ||
        -L "$directory/README.md" \
    ]]; then
        report_drift \
            "Missing or invalid category README: $category/README.md."
    fi

    for specification in "${PATTERNS[@]}"; do
        if [[ "${specification%%:*}" == "$category" ]]; then
            pattern="${specification#*:}"
            validate_pattern "$category" "$pattern"
        fi
    done

    for entry in "$directory"/*; do
        name="${entry##*/}"

        if [[ "$name" == 'README.md' ]]; then
            continue
        fi

        if ! is_pattern_in_category "$category" "$name"; then
            report_drift \
                "Unexpected entry in $category: $name."
        elif [[ ! -d "$entry" || -L "$entry" ]]; then
            report_drift \
                "Pattern package is not a regular directory: $category/$name."
        fi
    done
}

validate_playground() {
    local directory="$SOURCE_ROOT/playground"
    local entry
    local name

    if [[ ! -d "$directory" || -L "$directory" ]]; then
        report_drift 'Missing or invalid playground package.'
        return
    fi

    if [[ \
        ! -f "$directory/README.md" ||
        -L "$directory/README.md" \
    ]]; then
        report_drift \
            'Missing or invalid playground/README.md.'
    fi

    for entry in "$directory"/*; do
        name="${entry##*/}"

        if [[ "$name" == 'README.md' ]]; then
            continue
        fi

        if [[ ! -d "$entry" || -L "$entry" ]]; then
            report_drift \
                "The playground root may contain only README.md and scenario packages: $name."
        fi
    done
}

validate_structure() {
    local category
    local entry
    local name

    for entry in "$SOURCE_ROOT"/*; do
        name="${entry##*/}"

        if ! is_protected_category "$name"; then
            report_drift \
                "Unexpected entry under the protected package root: $name."
        elif [[ ! -d "$entry" || -L "$entry" ]]; then
            report_drift \
                "Protected package is not a regular directory: $name."
        fi
    done

    for category in creational structural behavioral; do
        validate_category "$category"
    done

    validate_playground
}

STRUCTURE_CREATED=0

if [[ -L "$SOURCE_ROOT" ]]; then
    report_drift \
        'The protected package root cannot be a symbolic link.'
elif [[ ! -e "$SOURCE_ROOT" ]]; then
    create_structure
    STRUCTURE_CREATED=1
elif [[ ! -d "$SOURCE_ROOT" ]]; then
    report_drift \
        'The protected package root is not a directory.'
elif directory_is_empty "$SOURCE_ROOT"; then
    create_structure
    STRUCTURE_CREATED=1
fi

if [[ $DRIFT_DETECTED -eq 0 ]]; then
    validate_structure
fi

if [[ $DRIFT_DETECTED -ne 0 ]]; then
    emit_result 'BLOCKED_STRUCTURE_DRIFT'
    exit 1
fi

if [[ $STRUCTURE_CREATED -eq 1 ]]; then
    emit_result 'STRUCTURE_CREATED'
else
    emit_result 'STRUCTURE_READY'
fi
