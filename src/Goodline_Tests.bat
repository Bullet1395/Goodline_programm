@echo off
chcp 1251

SET CLI=".\lib\commons-cli-1.4.jar"

cd "C:\Users\Bullet1395\IdeaProjects\Goodline_programm\out\production\Goodline_programm"

java -cp %CLI%;. Main

java -cp %CLI%;. Main -l User_Read -p 123_r
@echo ��� 0 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Write -p 123_w
@echo ��� 0 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Execute -p 123_e
@echo ��� 0 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User -p 123_r
@echo ��� 1 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Read -p dsfadf
@echo ��� 2 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Read -p 123_r -r READ -path C.R.RR
@echo ��� 0 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Read -p 123_r -r READ -path C.R.RR.RRR
@echo ��� 0 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Write -p 123_w -r WRITE -path C.W.WR
@echo ��� 0 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Write -p 123_w -r WRITE -path C.W.WR.R
@echo ��� 0 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Write -p 123_w -r WRITE -path C.R.RR.W
@echo ��� 0 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Read -p 123_r -r ALL -path C.R.RR
@echo ��� 3 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Read -p 123_r -r WRITE -path C.W
@echo ��� 4 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Execute -p 123_e -r READ -path C.R.RR
@echo ��� 4 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Read -p 123_r -r READ -path C.R.RR -ds 2017-10-11 -de 2017-10-11 -v 100
@echo ��� 0 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Write -p 123_w -r WRITE -path C.W.WR -ds 2017-10-11 -de 2017-10-11 -v 100
@echo ��� 0 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Write -p 123_w -r WRITE -path C.W.WR -ds 2017-10-11 -de 2017-10-11 -v �����
@echo ��� 5 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Write -p 123_w -r WRITE -path C.W.WR -ds 101117 -de 101117 -v 100
@echo ��� 5 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Read -p 123_r -r READ -path C.R.RR -ds 10.11.17 -de 10.11.17 -v 100
@echo ��� 5 - %ERRORLEVEL%

PAUSE 
