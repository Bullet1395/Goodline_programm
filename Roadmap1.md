План:

1. Создать консольное приложение; R1.8 (5 мин)

2. Исследовательская задача; (30 мин)

    1. Как создать структуру ENUM в Java и взаимодействовать с ней;
    2. Литература из Software Engineering, Metanit, Internet;
    3. Результатом будет написанная структура ролей в приложении; 

3. Исследовательская задача; (50 мин)

    1. Как использовать алгоритм SHA512+Salt в Java;
    2. Литература из Software Engineering, Metanit, Internet;
    3. Метод обрабатывающий пароли пользователей. Результатом которого будет Hash пароля.

4. Исследовательская задача; (45 мин)

    1. Как прочитать и обработать дату в Java;
    2. Литература из Software Engineering, Internet;
    3. Распарсенная строка даты;


5. Исследовательская задача; (120 мин)

    1. Обработка параметров библиотекой apache/common-cli;
         Справка, методы вывода, с помощью чего реализовывать;
    2. Habrahabr, Internet;
    3. Написанные опции и методы обрабатывающие полученные параметры;  
        Метод вывода справки;


6. Создать класс Аутентификация ; R1.1 (120 мин)

    1. Создать класс User; R1.8 (10 мин)
    
            Логин;
            Пароль;
        
    2. Данные программы:
    
    | Логин         | Пароль |
    | :-------------: | :-------------: |
    | User_Read     | 123_r  |
    | User_Write    | 123_w  |
    | User_Execute  | 123_e  |

    3. Создать метод проверки полученных данных из параметров; 
(60 мин)

            Параметры из .bat:
                Логин;
                Пароль;
            
        1. Написать парсер командной строки, для разбивки полученных параметров и занесение их в аргументы;
	   	  
	   	        Логин;
	            Пароль;

        2. Написать опцию для принятия аргументов логина; (common-cli)
       
                 Указать настройки аргумента:
	                 Число аргументов в опции,
	                 Является ли по-умолчанию,
	                Как будет отображаться в справке;

        3. Написать опцию для принятия аргументов пароля; (common-cli)

                Указать настройки аргумента:
                    Число аргументов в опции,
                    Является ли по-умолчанию,
                    Как будет отображаться в справке;

    4. Создать метод EncryptedPass; R1.2 (40 мин)
	
	        Обрабатывает пароль пользователя. Генерирует Salt + SHA512, получаем Hash пароля.
    
        1. Генерация Salt;

    5. Добавить тесты для проверки класса аутентификации; R1.9 (10 мин)

            Параметры на вход {} Завершиться выводом справки;
            Параметры на вход {User_Read 123_r} кодом (0);
            Параметры на вход {User_Write 123_w} кодом (0);
            Параметры на вход {User_Execute 123_e} кодом (0);
            Параметры на вход {User 123_r} кодом (1);
            Параметры на вход {User_Read fjdsfj} кодом (2);


7. Создать класс Авторизация; R1.3 (68 мин)

    1. Создать класс Resources;
    
            Пользователь;
            Роль;
            Путь;

    2. Создать список ролей: R1.5 (8 мин)

            public enum Role 
            {
              READ(“Чтение”), 
              WRITE(“Запись”), 
              EXECUTE(“Выполнение”);
             }; 
            Примерно как будет выглядеть

    3.
    Пользователь    | Роль         | Путь
    :---------------| :----------: | :-----------
    User_Read|READ|C.R.RR
    User_Write|WRITE|C.W.WR
    User_Execute|EXECUTE|C.E.ER
    User_Read|READ|C.W.WR.R
    User_Write|WRITE|C.R.RR.W       

    4. Создать метод(void) проверяющий роль ресурса родителя, для предоставления такого же доступа ее потомку к которому пытаются получить доступ; R1.6 (30 мин)

    5. Создать метод обрабатывающий полученные параметры с запросом на доступ к ресурсам с определенной ролью; R1.8 (20 мин) 
	    
	        Логин, Пароль, Роль, Ресурс;

    6. Добавить тесты в .bat файл для проверки авторизации; R1.9 (10 мин)

            Параметры на вход {User_Read 123_r READ C.R.RR} кодом (0);
            Параметры на вход {User_Read 123_r READ C.R.RR.RRR} кодом (0);
            Параметры на вход {User_Write 123_w WRITE C.W.WR} кодом (0);
            Параметры на вход {User_Execute 123_e EXECUTE	C.E.ER} кодом (0);
            Параметры на вход {User_Read 123_r READ C.W.WR.R} кодом (0);
            Параметры на вход {User_Write 123_w WRITE C.W.WR.R} кодом (0);
            Параметры на вход {User_Write 123_w C.R.RR.W} кодом (0);
            Параметры на вход {User_Read 123_r READ C.R.RR.W} кодом (0);
            Параметры на вход {User_Read 123_r ALL C.R.RR} кодом (3);
            Параметры на вход {User_Read 123_r WRITE C.W} кодом (4);
            Параметры на вход {User_Execute 123_e READ C.R.RR} кодом (4);

8. Создать класс Аккаунтинг; R1.7 (40 мин)
	
        Пользователь;
        Дата входа в приложение;
        Дата выхода из приложения;
        Объем;

    1. Создать метод проверки полученных параметров из .bat; R1.7 (30 мин)
        1. Обработка даты на вход в приложение; (Ошибка 5)
        2. Обработка даты на выход из приложения; (Ошибка 5)
        3. Обработка объема; (Ошибка 5)

    2. Добавить тесты для проверки аккаунтинга; R1.9 (10 мин)

            Параметры на вход {User_Read 123_r 2017-10-11 2017-10-11 100 кодом (0);
            Параметры на вход {User_Write 123_w 2017-10-11 2017-10-11 100} кодом (0);
            Параметры на вход {User_Write 123_w 2017-10-11 2017-10-11 -много} кодом (5);
            Параметры на вход  User_Write 123_w 101117 101117 100} кодом (5);
            Параметры на вход {User_Read 123_r 10.11.17 10.11.17 100}кодом (5);

####Оценка времени 

Пункт плана            |Оценка времени    |Фактическое время
:----------------------| :--------------: | :---------------:
Создать консольное приложение; R1.8|5 мин | 2,3 мин
Как обработать параметры с помощью commons cli|60 мин| 129 мин (2 часа 9 мин)
Как создать структуру ENUM в Java и взаимодействовать с ней;|30 мин| 6,47 мин
Как зашифровать пароль SHA512+Salt в Java;|50 мин| 35,15 мин
Как прочитать и обработать дату в Java;|45 мин| 42,41 мин
Создать класс Аутентификация ; R1.1|120 мин(2 часа)| 148,24 (2 часа 28,24 мин)
Создать класс Авторизация; R1.3|68 мин| 244,64 (4 часа 4,64 мин)
Создать класс Аккаунтинг; R1.7|40 мин| 42 мин
Справка, методы вывода, с помощью чего реализовывать;|60 (1 час)| 89 мин (1 час 29 мин)
Итого |478 мин| 739,21 мин (12 часов 19,21 мин)
На исследовательские задачи |245 мин| 302,03 мин (5 часов 2,03 мин)