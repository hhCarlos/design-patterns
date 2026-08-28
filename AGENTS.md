# DesignPatterns Agent Instructions

## Mandatory Git preflight

Before modifying, creating, moving, or deleting any project file:

1. Invoke and follow the `git-preflight` skill.
2. Inspect the current Git branch and working tree.
3. Never modify files directly on `main` or `develop`.
4. If the current branch is `main` or `develop`, create a task-specific branch before making changes.
5. If unrelated uncommitted changes exist, stop and report them instead of modifying the working tree.

## Verification

- Run `./mvnw test` after modifying Java code, tests, or `pom.xml`.
- Review the complete diff before declaring a task complete.
- Do not merge into `develop` until the review and verification steps pass.
- Never force-push or delete a branch automatically.
