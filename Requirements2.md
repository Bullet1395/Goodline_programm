<h4>R2.1 </h4>
>Создать файл Roadmap2.md и описать план работы над вторым набором требований

<h4>R2.2 </h4>
>Каждый проект должен содержать README.md с описанием проекта. Также должны быть ссылки на два роадмапа: по первому и второму набору требований
Описание формата <a href="https://help.github.com/articles/basic-writing-and-formatting-syntax/">Markdown</a>

<h4>R2.3 </h4>
>В README.md должна присутствовать инструкция по сборке проекта из консоли

<h4>R2.4 </h4>
>В README.md должна присутствовать инструкция по запуску собранного проекта из консоли

<h4>R2.5 </h4>
>В README.md должна присутствовать инструкция по тестированию собранного проекта

<h4>R2.6 </h4>
>В репозитории должен содержаться скрипт сборки проекта BUILD.sh
>>Помните, что classpath на windows разделяется через ";" а на linux через ":". Используйте "$(expr substr $(uname -s) 1 10)" == "MINGW64_NT" или "$(expr substr $(uname -s) 1 10)" == "Linux"
http://stackoverflow.com/questions/394230/detect-the-os-from-a-bash-script
>>>Научитесь компилировать код руками
<br>http://stackoverflow.com/questions/5194926/compiling-java-files-in-all-subfolders
<br>http://stackoverflow.com/questions/6623161/javac-option-to-compile-all-java-files-under-a-given-directory-recursively
<br>Компилятор
<br>http://docs.oracle.com/javase/7/docs/technotes/tools/windows/javac.html
<br>Упаковщик в jar архив
<br>https://docs.oracle.com/javase/tutorial/deployment/jar/basicsindex.html

<h4>R2.7 </h4>
>В репозитории должен содержаться скрипт запуска проекта RUN.sh
Научитесь запускать jar файл с указанием зависимостей
<br>http://docs.oracle.com/javase/7/docs/technotes/tools/solaris/java.html

<h4>R2.8 </h4>
>В репозитории должен содержаться скрипт тестирования системы TEST.sh, покрывающий все варианты использования (которые вытекают из требований)
<br>Напишите скрипт выполняющий указанные тест-кейсы с выводом результатов отдельных тестов и итогового результата. 
<br>Тестирование считается неуспешным если хоть один тест не прошел.


<h4>R2.9 </h4>
>Код должен быть отформатирован согласно требованиям java coding conventions
<br>http://www.oracle.com/technetwork/java/codeconventions-150003.pdf

<h4>R2.10 </h4>
>В репозитории должен содержаться файл .gitignore в котором будут отфильтрованы бинарные артефакты и файлы IDE
<br>Например, скомпилированный код *.class, папка .idea и файл проекта .iml и.т.д.

<h4>R2.11 </h4>
>Скрипт тестирования должен возвращать 0 если все тесты прошли и 1 если хоть один тест не прошел
<br>Дополнение для работы в Continious Integration сервером

<h4>R2.12 </h4>
>Приложение должно автоматически собираться и тестироваться на travis-ci.org
При коммите с Windows, не забудьте пометить sh-файлы исполняемым флагом
git update-index —chmod=+x *.sh


<h4>R2.13 </h4>
>Включите github pages в вашем репозитории и выберите какой-нибудь стиль, чтобы сайт сгенерился из вашего README.md файла
<br>https://pages.github.com