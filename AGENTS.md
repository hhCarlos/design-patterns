# DesignPatterns Agent Instructions

## Mandatory Git preflight

Before modifying, creating, moving, deleting, staging, or committing any project file:

1. Invoke and follow the `git-preflight` skill.
2. Inspect the current Git branch and working tree.
3. Handle the preflight result as follows:
    * On `READY`, continue to the mandatory structure check.
    * On `BLOCKED_PROTECTED_BRANCH`, stop and ask the user to create and switch to a task-specific branch.
    * On `BLOCKED_DIRTY_WORKTREE`, report the affected files and wait for user instructions.
4. Never modify or commit files directly on `main` or `develop`.
5. Never create, switch, merge, rename, or delete Git branches automatically.
6. Never stash, discard, stage, commit, or modify existing uncommitted changes without explicit user instructions.

## Mandatory structure check

After `git-preflight` returns `READY` and before making any task-related changes:

1. Invoke and follow the `design-patterns-structure` skill.
2. Run the structure check from the repository root:
   ```bash
   bash .agents/skills/design-patterns-structure/scripts/ensure-structure.sh
   ```
3. Handle the result as follows:
    * On `STRUCTURE_CREATED`, review the generated structure, run `mvn test`, and continue only if verification passes.
    * On `STRUCTURE_READY`, continue with the requested task.
    * On `BLOCKED_STRUCTURE_DRIFT`, stop immediately, report every detected difference, and wait for user instructions.
4. Never bypass, repair, or modify the protected structure automatically.
5. Structural changes require explicit user authorization.

## Verification

After completing the requested changes:

1. Run `mvn test` after modifying:
    * Java source files.
    * Java test files.
    * `pom.xml`.
    * The canonical project structure.
2. Review `git status --short`.
3. Review the complete diff, including untracked files.
4. Do not declare the task complete if verification fails.
5. Report:
    * Files created, modified, moved, or deleted.
    * Commands executed.
    * Test results.
    * Any remaining warnings, failures, or unverified assumptions.
6. Never merge into `develop` automatically.
7. Never push, force-push, or delete branches automatically.
8. Leave the final review, commit, push, and merge decisions to the user.
