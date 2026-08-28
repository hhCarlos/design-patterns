## Git workflow

- Never modify files directly on `main` or `develop`.
- Before changing files, inspect the current branch and working tree.
- If the current branch is `main` or `develop`, create a task-specific branch.
- Stop if the working tree contains unrelated uncommitted changes.
- Run `./mvnw test` before declaring work complete.
- Never merge into `develop` without an explicit review and user approval.
- Never force-push or delete branches automatically.
- 