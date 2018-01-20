@echo off
chcp 1251

SET CLI=".\commons-cli-1.4.jar"

@echo 0. ���������: ��� ����������
java -cp %CLI%;. main.Main

java -cp %CLI%;. main.Main -l User_Read -p 123_r
@echo 1. ���������: -l User_Read -p 123_r
@echo ��� 0 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -l User_Write -p 123_w
@echo 2. ���������: -l User_Write -p 123_w
@echo ��� 0 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -l User_Execute -p 123_e
@echo 3. ���������: -l User_Execute -p 123_e
@echo ��� 0 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -l User -p 123_r
@echo 4. ���������: -l User -p 123_r
@echo ��� 1 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -l User_Read -p dsfadf
@echo 5. ���������: -l User_Read -p dsfadf
@echo ��� 2 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -l User_Read -p 123_r -r READ -path C.R.RR
@echo 6. ���������: -l User_Read -p 123_r -r READ -path C.R.RR
@echo ��� 0 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -l User_Read -p 123_r -r READ -path C.R.RR.RRR
@echo 7. ���������: -l User_Read -p 123_r -r READ -path C.R.RR.RRR
@echo ��� 0 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -l User_Write -p 123_w -r WRITE -path C.W.WR
@echo 8. ���������: -l User_Write -p 123_w -r WRITE -path C.W.WR
@echo ��� 0 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -l User_Write -p 123_w -r WRITE -path C.W.WR.R
@echo 9. ���������: -l User_Write -p 123_w -r WRITE -path C.W.WR.R
@echo ��� 0 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -l User_Write -p 123_w -r WRITE -path C.R.RR.W
@echo 10. ���������: -l User_Write -p 123_w -r WRITE -path C.R.RR.W
@echo ��� 0 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -l User_Read -p 123_r -r ALL -path C.R.RR
@echo 11. ���������: -l User_Read -p 123_r -r ALL -path C.R.RR
@echo ��� 3 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -l User_Read -p 123_r -r WRITE -path C.W
@echo 12. ���������: -l User_Read -p 123_r -r WRITE -path C.W
@echo ��� 4 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -l User_Execute -p 123_e -r READ -path C.R.RR
@echo 13. ���������: -l User_Execute -p 123_e -r READ -path C.R.RR
@echo ��� 4 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -l User_Read -p 123_r -r READ -path C.R.RR -ds 2017-10-11 -de 2017-10-11 -v 100
@echo 14. ���������: -l User_Read -p 123_r -r READ -path C.R.RR -ds 2017-10-11 -de 2017-10-11 -v 100
@echo ��� 0 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -l User_Write -p 123_w -r WRITE -path C.W.WR -ds 2017-10-11 -de 2017-10-11 -v 100
@echo 15. ���������: -l User_Write -p 123_w -r WRITE -path C.W.WR -ds 2017-10-11 -de 2017-10-11 -v 100
@echo ��� 0 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -l User_Write -p 123_w -r WRITE -path C.W.WR -ds 2017-10-11 -de 2017-10-11 -v �����
@echo 16. ���������: -l User_Write -p 123_w -r WRITE -path C.W.WR -ds 2017-10-11 -de 2017-10-11 -v �����
@echo ��� 5 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -l User_Write -p 123_w -r WRITE -path C.W.WR -ds 101117 -de 101117 -v 100
@echo 17. ���������: -l User_Write -p 123_w -r WRITE -path C.W.WR -ds 101117 -de 101117 -v 100
@echo ��� 5 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -l User_Read -p 123_r -r READ -path C.R.RR -ds 10.11.17 -de 10.11.17 -v 100
@echo 18. ���������: -l User_Read -p 123_r -r READ -path C.R.RR -ds 10.11.17 -de 10.11.17 -v 100
@echo ��� 5 - %ERRORLEVEL%

@echo -----------------------------------------------------------------------------

java -cp %CLI%;. main.Main
@echo ������� ����
@echo 1. ���������: ��� ����������
@echo ��� 0 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -h
@echo ������� ����
@echo 2. ���������: -h
@echo ��� 0 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -login XXX -password XXX
@echo ����������� ������������
@echo 3. ���������: -login 'XXX' -password 'XXX'
@echo ��� 1 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -login jdoe -password XXX
@echo �������� ������
@echo 4. ���������: -login 'jdoe' -password 'XXX'
@echo ��� 2 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -login jdoe -password sup3rpaZZ
@echo �������
@echo 5. ���������: -login jdoe -password sup3rpaZZ
@echo ��� 0 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -login xxx -password yyy
@echo �������
@echo 6. ���������: -login xxx -password yyy
@echo ��� 0 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -login jdoe -password sup3rpaZZ -role READ -path a
@echo �������
@echo 7. ���������: -login jdoe -password sup3rpaZZ -role READ -path a
@echo ��� 0 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -login jdoe -password sup3rpaZZ -role READ -path a.b
@echo 0
@echo 8. ���������: -login 'jdoe' -password 'sup3rpaZZ' -role 'READ' -path 'a.b'
@echo ��� 0 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -login jdoe -password sup3rpaZZ -role XXX -path a.b
@echo ����������� ����
@echo 9. ���������: -login 'jdoe' -password 'sup3rpaZZ' -role 'XXX' -path 'a.b'
@echo ��� 3 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -login jdoe -password sup3rpaZZ -role READ -path XXX
@echo ��� �������
@echo 10. ���������: -login 'jdoe' -password 'sup3rpaZZ' -role 'READ' -path 'XXX'
@echo ��� 4 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -login jdoe -password sup3rpaZZ -role WRITE -path a
@echo ��� �������
@echo 11. ���������: -login 'jdoe' -password 'sup3rpaZZ' -role 'WRITE' -path 'a'
@echo ��� 4 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -login jdoe -password sup3rpaZZ -role WRITE -path a.bc
@echo ��� �������
@echo 12. ���������: -login 'jdoe' -password 'sup3rpaZZ' -role 'WRITE' -path 'a.bc'
@echo ��� 4 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -login jdoe -password sup3rpaZZ -role READ -path a.b -ds 2015-01-01 -de 2015-12-31 -volume 100
@echo �������
@echo 13. ���������: -login 'jdoe' -password sup3rpaZZ -role READ -path a.b -ds 2015-01-01 -de 2015-12-31 -volume 100
@echo ��� 0 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -login jdoe -password sup3rpaZZ -role READ -path a.b -ds 01-01-2015 -de 2015-12-31 -vol 100
@echo ���������� ����������
@echo 14. ���������: -login 'jdoe' -password 'sup3rpaZZ' -role 'READ' -path 'a.b' -ds '01-01-2015' -de '2015-12-31' -vol '100'
@echo ��� 5 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -login jdoe -password sup3rpaZZ -role READ -path a.b -ds 2015-01-01 -de 2015-12-31 -vol XXX
@echo ���������� ����������
@echo 15. ���������: -login 'jdoe' -password 'sup3rpaZZ' -role 'READ' -path 'a.b' -ds '2015-01-01' -de '2015-12-31' -vol 'XXX'
@echo ��� 5 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -login X -password X -role READ -path X -ds 2015-01-01 -de 2015-12-31 -vol XXX
@echo ����������� ������������
@echo 16. ���������: -login 'X' -password 'X' -role 'READ' -path 'X' -ds '2015-01-01' -de '2015-12-31' -vol 'XXX'
@echo ��� 1 - %ERRORLEVEL%

java -cp %CLI%;. main.Main -login X -password X -role READ -path X
@echo ����������� ������������
@echo 17. ���������: -login 'X' -password 'X' -role 'READ' -path 'X'
@echo ��� 1 - %ERRORLEVEL%

PAUSE