1) Connect to helios
login and password saved in icloud passwords

To connect type `ssh -p 2222 sXXXXX@se.ifmo.ru`

2) Create dir via `mkdir lab1`
3) Go to directory lab1 via `cd lab1`
4) exit helios via `exit`
5) Copy lab jar from repo root to helios via `scp -P 2222 lab1.jar sXXXXXX@se.ifmo.ru:lab1/`
6) Login to helios
7) go to lab1 dir
8) Run lab via `java -jar lab1.jar`