# Создание папки для сборки проекта
mkdir -p outHand

# Сборка проектов в .class в папку outHand
javac -d ./outHand/ -sourcepath ./src ./src/Main.java -classpath "./lib/commons-cli-1.4.jar"

# Сборка проекта в .jar архив
jar cvmf META-INF/MANIFEST.MF Goodline_programm.jar -C outHand .
