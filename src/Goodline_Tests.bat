@echo off
chcp 1251

SET CLI=".\commons-cli-1.4.jar"

@echo 0. Параметры: Нет параметров
java -cp %CLI%;. Main

java -cp %CLI%;. Main -l User_Read -p 123_r
@echo 1. Параметры: -l User_Read -p 123_r
@echo Код 0 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Write -p 123_w
@echo 2. Параметры: -l User_Write -p 123_w
@echo Код 0 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Execute -p 123_e
@echo 3. Параметры: -l User_Execute -p 123_e
@echo Код 0 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User -p 123_r
@echo 4. Параметры: -l User -p 123_r
@echo Код 1 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Read -p dsfadf
@echo 5. Параметры: -l User_Read -p dsfadf
@echo Код 2 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Read -p 123_r -r READ -path C.R.RR
@echo 6. Параметры: -l User_Read -p 123_r -r READ -path C.R.RR
@echo Код 0 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Read -p 123_r -r READ -path C.R.RR.RRR
@echo 7. Параметры: -l User_Read -p 123_r -r READ -path C.R.RR.RRR
@echo Код 0 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Write -p 123_w -r WRITE -path C.W.WR
@echo 8. Параметры: -l User_Write -p 123_w -r WRITE -path C.W.WR
@echo Код 0 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Write -p 123_w -r WRITE -path C.W.WR.R
@echo 9. Параметры: -l User_Write -p 123_w -r WRITE -path C.W.WR.R
@echo Код 0 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Write -p 123_w -r WRITE -path C.R.RR.W
@echo 10. Параметры: -l User_Write -p 123_w -r WRITE -path C.R.RR.W
@echo Код 0 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Read -p 123_r -r ALL -path C.R.RR
@echo 11. Параметры: -l User_Read -p 123_r -r ALL -path C.R.RR
@echo Код 3 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Read -p 123_r -r WRITE -path C.W
@echo 12. Параметры: -l User_Read -p 123_r -r WRITE -path C.W
@echo Код 4 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Execute -p 123_e -r READ -path C.R.RR
@echo 13. Параметры: -l User_Execute -p 123_e -r READ -path C.R.RR
@echo Код 4 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Read -p 123_r -r READ -path C.R.RR -ds 2017-10-11 -de 2017-10-11 -v 100
@echo 14. Параметры: -l User_Read -p 123_r -r READ -path C.R.RR -ds 2017-10-11 -de 2017-10-11 -v 100
@echo Код 0 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Write -p 123_w -r WRITE -path C.W.WR -ds 2017-10-11 -de 2017-10-11 -v 100
@echo 15. Параметры: -l User_Write -p 123_w -r WRITE -path C.W.WR -ds 2017-10-11 -de 2017-10-11 -v 100
@echo Код 0 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Write -p 123_w -r WRITE -path C.W.WR -ds 2017-10-11 -de 2017-10-11 -v много
@echo 16. Параметры: -l User_Write -p 123_w -r WRITE -path C.W.WR -ds 2017-10-11 -de 2017-10-11 -v много
@echo Код 5 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Write -p 123_w -r WRITE -path C.W.WR -ds 101117 -de 101117 -v 100
@echo 17. Параметры: -l User_Write -p 123_w -r WRITE -path C.W.WR -ds 101117 -de 101117 -v 100
@echo Код 5 - %ERRORLEVEL%

java -cp %CLI%;. Main -l User_Read -p 123_r -r READ -path C.R.RR -ds 10.11.17 -de 10.11.17 -v 100
@echo 18. Параметры: -l User_Read -p 123_r -r READ -path C.R.RR -ds 10.11.17 -de 10.11.17 -v 100
@echo Код 5 - %ERRORLEVEL%

@echo -----------------------------------------------------------------------------

java -cp %CLI%;. Main
@echo выводит хэлп
@echo 1. Параметры: Нет параметров
@echo Код 0 - %ERRORLEVEL%

java -cp %CLI%;. Main -h
@echo выводит хэлп
@echo 2. Параметры: -h
@echo Код 0 - %ERRORLEVEL%

java -cp %CLI%;. Main -login XXX -password XXX
@echo неизвестный пользователь
@echo 3. Параметры: -login 'XXX' -password 'XXX'
@echo Код 1 - %ERRORLEVEL%

java -cp %CLI%;. Main -login jdoe -password XXX
@echo неверный пароль
@echo 4. Параметры: -login 'jdoe' -password 'XXX'
@echo Код 2 - %ERRORLEVEL%

java -cp %CLI%;. Main -login jdoe -password sup3rpaZZ
@echo успешно
@echo 5. Параметры: -login jdoe -password sup3rpaZZ
@echo Код 0 - %ERRORLEVEL%

java -cp %CLI%;. Main -login xxx -password yyy
@echo успешно
@echo 6. Параметры: -login xxx -password yyy
@echo Код 0 - %ERRORLEVEL%

java -cp %CLI%;. Main -login jdoe -password sup3rpaZZ -role READ -path a
@echo успешно
@echo 7. Параметры: -login jdoe -password sup3rpaZZ -role READ -path a
@echo Код 0 - %ERRORLEVEL%

java -cp %CLI%;. Main -login jdoe -password sup3rpaZZ -role READ -path a.b
@echo 0
@echo 8. Параметры: -login 'jdoe' -password 'sup3rpaZZ' -role 'READ' -path 'a.b'
@echo Код 0 - %ERRORLEVEL%

java -cp %CLI%;. Main -login jdoe -password sup3rpaZZ -role XXX -path a.b
@echo неизвестная роль
@echo 9. Параметры: -login 'jdoe' -password 'sup3rpaZZ' -role 'XXX' -path 'a.b'
@echo Код 3 - %ERRORLEVEL%

java -cp %CLI%;. Main -login jdoe -password sup3rpaZZ -role READ -path XXX
@echo нет доступа
@echo 10. Параметры: -login 'jdoe' -password 'sup3rpaZZ' -role 'READ' -path 'XXX'
@echo Код 4 - %ERRORLEVEL%

java -cp %CLI%;. Main -login jdoe -password sup3rpaZZ -role WRITE -path a
@echo нет доступа
@echo 11. Параметры: -login 'jdoe' -password 'sup3rpaZZ' -role 'WRITE' -path 'a'
@echo Код 4 - %ERRORLEVEL%

java -cp %CLI%;. Main -login jdoe -password sup3rpaZZ -role WRITE -path a.bc
@echo нет доступа
@echo 12. Параметры: -login 'jdoe' -password 'sup3rpaZZ' -role 'WRITE' -path 'a.bc'
@echo Код 4 - %ERRORLEVEL%

java -cp %CLI%;. Main -login jdoe -password sup3rpaZZ -role READ -path a.b -ds 2015-01-01 -de 2015-12-31 -volume 100
@echo успешно
@echo 13. Параметры: -login 'jdoe' -password sup3rpaZZ -role READ -path a.b -ds 2015-01-01 -de 2015-12-31 -volume 100
@echo Код 0 - %ERRORLEVEL%

java -cp %CLI%;. Main -login jdoe -password sup3rpaZZ -role READ -path a.b -ds 01-01-2015 -de 2015-12-31 -vol 100
@echo невалидная активность
@echo 14. Параметры: -login 'jdoe' -password 'sup3rpaZZ' -role 'READ' -path 'a.b' -ds '01-01-2015' -de '2015-12-31' -vol '100'
@echo Код 5 - %ERRORLEVEL%

java -cp %CLI%;. Main -login jdoe -password sup3rpaZZ -role READ -path a.b -ds 2015-01-01 -de 2015-12-31 -vol XXX
@echo невалидная активность
@echo 15. Параметры: -login 'jdoe' -password 'sup3rpaZZ' -role 'READ' -path 'a.b' -ds '2015-01-01' -de '2015-12-31' -vol 'XXX'
@echo Код 5 - %ERRORLEVEL%

java -cp %CLI%;. Main -login X -password X -role READ -path X -ds 2015-01-01 -de 2015-12-31 -vol XXX
@echo неизвестный пользователь
@echo 16. Параметры: -login 'X' -password 'X' -role 'READ' -path 'X' -ds '2015-01-01' -de '2015-12-31' -vol 'XXX'
@echo Код 1 - %ERRORLEVEL%

java -cp %CLI%;. Main -login X -password X -role READ -path X
@echo неизвестный пользователь
@echo 17. Параметры: -login 'X' -password 'X' -role 'READ' -path 'X'
@echo Код 1 - %ERRORLEVEL%

PAUSE