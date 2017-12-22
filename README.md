###Описание:
В приложении имеется:  
   1. Аутентификация  
   2. Авторизация  
   3. Аккаунтинг  
    
###Ссылки на наборы требований:  
   1. [Первый набор требований](https://docs.google.com/document/d/1VOqiari-MJ_Cbh8ljlD6u2jHOJuORKzbYmNFDWBYCnc/edit)  
   2. [Второй набор требований]()  
    
###Тестирование проекта на сервисе travis-ci.org
   [Travis CI](https://travis-ci.org/Bullet1395/Goodline_programm.svg?branch=master)    
    
## Набор инструкций по сборке проекта: 

Чтобы собрать проект в файл с расширением **jar**, требуется произвести запуск файла: **BUILD.sh** при помощи специальной команды: **./BUILD.sh**, которая должна вводится из коммандной строки. Реузльтатом работы команды будет файл: **GoodLineCLI.jar**. 

## Набор инструкция по запуску проекта: Чтобы запустить проект, требуется запустить файл: **RUN.sh** и передать на вход, как параметры, набор определённых данных и комманд. Например, это может быть сделано вот так (на примере указан процесс **аутентификации**): 
```sh 
./RUN.sh -login jdoe -pass sup3rpaZZ
``` 
## Набор инструкций по тестированию проекта: 

Чтобы выполнить тестирование проекта, требуется запустить файл: **TEST.sh** при помощи специальной команды: **./TEST.sh**, которая должна быть введена из командной строки. Результатов выполнения тестирования может быть два: **код-0**, если тестирование прошло успешно и **код-1**, если хотя бы один тест приложения провален.
