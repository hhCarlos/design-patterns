---
name: git-preflight
description: Run a read-only Git safety check before any task that could modify repository files, staging, commits, or branches. Block work on main, develop, or a dirty working tree.
---

# Mandatory Git preflight

Before modifying, creating, moving, deleting, staging, or committing files:

1. Run the preflight script from the repository root:

   ```bash
   bash .agents/skills/git-preflight/scripts/check-branch.sh
   ```

2. Do not perform any repository mutation before receiving the result.
3. Never modify or commit files directly on `main` or `develop`.
4. If the current branch is `main` or `develop`, stop immediately and tell the user:

   > Work cannot continue on this protected branch. Create and switch to a task-specific branch.

5. Never create, switch, merge, rename, or delete branches automatically.
6. If uncommitted changes exist, report the affected files and ask the user how to proceed.
7. Never stash, discard, commit, or modify existing uncommitted changes without explicit user instructions.

## Results

The preflight script returns exactly one of these results:

- `READY`: The current branch is a valid task branch and the working tree is clean.
- `BLOCKED_PROTECTED_BRANCH`: The current branch is `main` or `develop`.
- `BLOCKED_DIRTY_WORKTREE`: Uncommitted changes require user review.

## Result handling

- On `READY`, continue with the requested task.
- On `BLOCKED_PROTECTED_BRANCH`, stop without modifying anything.
- On `BLOCKED_DIRTY_WORKTREE`, show the affected files and wait for user instructions.
