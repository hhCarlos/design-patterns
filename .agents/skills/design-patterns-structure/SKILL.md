---
name: design-patterns-structure
description: Bootstrap and validate the canonical Java package structure for the DesignPatterns Maven learning repository before any task that may modify project files.
---

# DesignPatterns structure guard

Use this skill only after the mandatory `git-preflight` skill returns `READY`.

Run the following command from the repository root:

```bash
bash .agents/skills/design-patterns-structure/scripts/ensure-structure.sh
```

Do not make task-related repository changes before receiving the result.

The initial bootstrap performed by this script is the only automatic structural mutation authorized by this skill.

## Result handling

The script must return exactly one of these results:

- `STRUCTURE_CREATED`: The canonical structure did not exist and was created successfully.
- `STRUCTURE_READY`: The canonical structure already exists and is valid.
- `BLOCKED_STRUCTURE_DRIFT`: The structure is partial, invalid, or has been modified.

Handle each result as follows:

- On `STRUCTURE_CREATED`, review the generated files, run `mvn test`, and then continue with the requested task.
- On `STRUCTURE_READY`, continue with the requested task.
- On `BLOCKED_STRUCTURE_DRIFT`, stop immediately, report every detected difference, and wait for explicit user instructions.

Never repair structural drift automatically.

## Canonical package root

The protected package root is:

```text
src/main/java/io/github/hhcarlos/designpatterns
```

Its protected top-level packages are:

- `creational`
- `structural`
- `behavioral`
- `playground`

No additional top-level packages are allowed under the protected package root.

## Creational patterns

The `creational` package must contain `README.md` and exactly these pattern packages:

- `abstractfactory`
- `factorymethod`
- `builder`
- `prototype`
- `singleton`

## Structural patterns

The `structural` package must contain `README.md` and exactly these pattern packages:

- `adapter`
- `bridge`
- `composite`
- `decorator`
- `facade`
- `flyweight`
- `proxy`

## Behavioral patterns

The `behavioral` package must contain `README.md` and exactly these pattern packages:

- `chainofresponsibility`
- `command`
- `iterator`
- `mediator`
- `memento`
- `observer`
- `state`
- `strategy`
- `templatemethod`
- `visitor`

## Pattern package contract

Every canonical pattern package must contain exactly one launcher named `Main.java`.

Each launcher must:

- Declare the package matching its directory.
- Declare a public `Main` class.
- Contain `public static void main(String[] args)`.
- Remain minimal and compilable until the user implements the pattern manually.

The following changes are allowed:

- Edit an existing `Main.java` while preserving its package, class name, and main method.
- Add Java implementation classes directly inside an existing pattern package.
- Add tests under the equivalent package in `src/test/java`.
- Edit the contents of category `README.md` files.

The following changes are forbidden without explicit user authorization:

- Add, rename, move, or delete a canonical category.
- Add, rename, move, or delete a canonical pattern package.
- Delete, move, or rename a required `README.md`.
- Delete, move, or rename a required `Main.java`.
- Add subpackages inside canonical pattern packages.
- Add an alternative class containing another main method.
- Move implementation classes between pattern packages automatically.

## Playground contract

The protected playground root is:

```text
src/main/java/io/github/hhcarlos/designpatterns/playground
```

It must contain `README.md`.

The playground exists for scenario-based experiments that combine multiple design patterns.

The following changes are allowed:

- Add scenario packages inside `playground`.
- Add Java classes and launchers inside scenario packages.
- Add corresponding tests under `src/test/java`.
- Edit `playground/README.md`.

The following rules apply:

- Scenario packages must be named after the problem or domain being explored, not after a list of patterns.
- Playground code may depend on canonical pattern packages.
- Canonical pattern packages must never depend on playground code.
- Playground scenarios must never replace or redefine the canonical package structure.

## Git restrictions

This skill must never:

- Create or switch branches.
- Merge, rename, or delete branches.
- Stage files.
- Create commits.
- Push changes.
- Stash or discard existing work.

All Git operations remain subject to the mandatory `git-preflight` skill and explicit user instructions.
