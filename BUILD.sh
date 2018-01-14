# Создание папки для сборки проекта
mkdir -p outHand

# Сборка проектов в .class в папку outHand
javac -d ./outHand/ -sourcepath ./src ./src/Main.java -classpath "./lib/commons-cli-1.4.jar:./lib/h2-1.4.196.jar:./lib/flyway-core-4.1.2.jar:./libs/log4j-core-2.8.2.jar:./lib/log4j-api-2.8.2.jar"

# Сборка проекта в .jar архив
jar cvmf META-INF/MANIFEST.MF Goodline_programm.jar -C outHand .
