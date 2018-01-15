# Создание папки для сборки проекта
mkdir -p outHand

# Сборка проектов в .class в папку outHand
javac -classpath "./src;./src/main/resources/;./src/main/resources/db/migration;./lib/commons-cli-1.4.jar;./lib/h2-1.4.196.jar;./lib/flyway-core-5.0.5.jar;./lib/log4j-core-2.8.2.jar;./lib/log4j-api-2.8.2.jar" -encoding UTF-8 -d ./outHand/ -sourcepath ./src ./src/Main.java

# Сборка проекта в .jar архив
jar cvmf META-INF/MANIFEST.MF Goodline_programm.jar -C outHand .
