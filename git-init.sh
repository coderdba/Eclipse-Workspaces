git config user.email coderdba@coder.com
git config user.name coderdba

echo "# Eclipse-Workspaces" >> README.md
git init
cp ./config .git/.
#git add README.md
git add .
git commit -m "first commit"
git remote add origin https://github.com/coderdba/Eclipse-Workspaces.git
git push -u origin master

echo
echo
echo
echo RUN IT AGAIN IF IT GIVES SOME INITIAL ERROR
echo
echo
echo
