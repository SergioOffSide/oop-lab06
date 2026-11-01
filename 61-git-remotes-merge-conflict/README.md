# Esercizio di risoluzione di un merge conflict

**Il tempo massimo in laboratorio per questo esercizio è di _20 minuti_.
Se superato, sospendere l'esercizio e riprenderlo per ultimo!**

Si visiti https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.
Questo repository contiene due branch: `master` e `feature`

Per ognuna delle seguenti istruzioni, si annoti l'output ottenuto.
Prima di eseguire ogni operazione sul worktree o sul repository,
si verifichi lo stato del repository con `git status`.

1. Si cloni localmente il repository
git clone git@github.com:APICe-at-DISI/OOP-git-merge-conflict-test.git
git status
On branch master
Your branch is up to date with 'origin/master'.

nothing to commit, working tree clean

2. Ci si assicuri di avere localmente entrambi i branch remoti
git branch
* master
git branch feature origin/feature
branch 'feature' set up to track 'origin/feature'.
git branch
  feature
* master

3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master`
   e da qui si esegua il merge di `feature`
git merge feature

4. Si noti che viene generato un **merge conflict**!
5. Si risolva il merge conflict come segue:
   - Il programma Java risultante deve stampare sia il numero di processori disponibili
     (funzionalità presente su `master`)
     che il nome dell'autore del file
     (funzionalità presente su `feature`)
git status
On branch master
Your branch is up to date with 'origin/master'.

You have unmerged paths.
  (fix conflicts and run "git commit")
  (use "git merge --abort" to abort the merge)

Unmerged paths:
  (use "git add <file>..." to mark resolution)
	both modified:   HelloWorld.java

no changes added to commit (use "git add" and/or "git commit -a")
git add HelloWorld.java
git commit
git status
On branch master
Your branch is ahead of 'origin/master' by 4 commits.
  (use "git push" to publish your local commits)

nothing to commit, working tree clean

6. Si crei un nuovo repository nel proprio github personale
7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote
cd MyProject && mkdir MyProject
git init
git remote add origin git@github.com:SergioOffSide/Es61-oopLab06.git
git remote -v
origin	git@github.com:SergioOffSide/Es61-oopLab06.git (fetch)
origin	git@github.com:SergioOffSide/Es61-oopLab06.git (push)
nano HelloWorld.java
git add HelloWorld.java
git commit -m "HelloWorld.java added"
[master (root-commit) ba7cfe4] HelloWorld.java added
 1 file changed, 4 insertions(+)
 create mode 100644 HelloWorld.java

8. Si faccia push del branch `master` sul proprio repository
git push
fatal error
git push --set-upstream origin master (andava bene anche git push -u origin master)
Enter passphrase for key '/Users/sergiodebenedetto/.ssh/id_ed25519': 
Enumerating objects: 3, done.
Counting objects: 100% (3/3), done.
Delta compression using up to 8 threads
Compressing objects: 100% (2/2), done.
Writing objects: 100% (3/3), 287 bytes | 287.00 KiB/s, done.
Total 3 (delta 0), reused 0 (delta 0), pack-reused 0 (from 0)
To github.com:SergioOffSide/Es61-oopLab06.git
 * [new branch]      master -> master
branch 'master' set up to track 'origin/master'.

9. Si setti il branch remoto `master` del nuovo repository come *upstream* per il proprio branch `master` locale
