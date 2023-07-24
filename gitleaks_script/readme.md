# gitleaks script

Download gitleaks archive fjr you platform from https://github.com/gitleaks/gitleaks/releases/tag/v8.17.0  
Extract the file "gitleaks" to ".git/hooks/" directory  
Make it executable "chmod +u gitleaks"  
Copy script "pre-commit" to the same directory
and make him executable "chmod g+u pre-commit"

After that, when you make commit, the script will check for secrets and complete the commit with an error.

