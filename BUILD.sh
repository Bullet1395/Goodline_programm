﻿echo Создание папки для сборки проекта
mkdir -p ./outHand

echo Сборка проектов .class в папку outHand
#javac -cp "./lib/commons-cli-1.4.jar;./lib/h2-1.4.196.jar;./lib/flyway-core-5.0.5.jar;./lib/log4j-core-2.8.2.jar;./lib/log4j-api-2.8.2.jar" -d ./outHand/ -sourcepath ./src/main/java/ ./src/main/application/bin/Main.java
javac -cp "./lib/commons-cli-1.4.jar:./lib/h2-1.4.196.jar:./lib/flyway-core-5.0.5.jar:./lib/log4j-core-2.8.2.jar:./lib/log4j-api-2.8.2.jar" -d ./outHand/ -sourcepath ./src/main/java/ ./src/main/application/bin/Main.java

echo Копируем ресурсы в outHand:
mkdir -p ./outHand/resources
cp -R -v ./src/main/resources/* ./outHand/resources/

echo Сборка проекта в .jar архив
jar cvmf META-INF/MANIFEST.MF Goodline_programm.jar outHand/ lib/
