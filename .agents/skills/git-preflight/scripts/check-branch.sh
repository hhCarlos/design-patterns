#!/usr/bin/env bash

set -euo pipefail

current_branch="$(git branch --show-current)"

if [[ "$current_branch" == "main" || "$current_branch" == "develop" ]]; then
    echo "BLOCKED_PROTECTED_BRANCH"
    echo "Current branch: $current_branch"
    echo "Work cannot continue on this protected branch."
    echo "Create and switch to a task-specific branch."
    exit 2
fi

working_tree_status="$(git status --porcelain)"

if [[ -n "$working_tree_status" ]]; then
    echo "BLOCKED_DIRTY_WORKTREE"
    echo "Uncommitted changes:"
    echo "$working_tree_status"
    exit 3
fi

echo "READY"
exit 0
