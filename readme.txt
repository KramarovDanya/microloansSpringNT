что бы запустить заглушку в дефолтными параметрами 

java -jar C:\microloans-0.0.1-SNAPSHOT.jar

чтобы запустить с тест профилем 1

java -Dspring.profiles.active=test1 -jar C:\ProgramProgect\ideaProgect\microloans\microloans\target\microloans-0.0.1-SNAPSHOT.jar

чтобы запустить с тест профилем 2

java -Dspring.profiles.active=test2 -jar C:\ProgramProgect\ideaProgect\microloans\microloans\target\microloans-0.0.1-SNAPSHOT.jar

Запустить с выделенной памятью 

java -Dspring.profiles.active=test1 -Xms2048m -Xms4096m -jar C:\ProgramProgect\ideaProgect\microloans\microloans\target\microloans-0.0.1-SNAPSHOT.jar