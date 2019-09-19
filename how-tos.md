How-to:
   - [Git from command line](#git)

---
### <a name="git" />Git from command line

```shell script
# Add all files and directories to git
git add --all
# Commit changes
git commit -a -m "Android development"
# Push changes
git push
```

If you have a warning `warning: LF will be replaced by CRLF in 01.basics_-_user_interface/gradlew`,
Git can auto-convert CRLF line endings into LF when you add a file to the index,
and vice versa when it checks out code onto your filesystem.
You can turn on this functionality with the `core.autocrlf` setting.
```shell script
git config core.autocrlf true
```

