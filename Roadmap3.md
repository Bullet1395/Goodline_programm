1. Исследовательская задача; (60 мин)
    1. Как создать aaa.log с помощью библиотеки log4j?;
    2. Internet;
    3. Результатом будет написанный файл конфигурации для log4j; 
    
2. Исследовательская задача; (60 мин)
    1. Как подключить миграции к H2 бд?;
    2. Internet;
    3. Результатом будет написанный файл конфигурации для H2(pom.xml); 
    
3. Добавить логирование в проект (90 мин)
    1. Подключить библиотеку log4j
    2. Написать файл конфигурацц
    3. Импортировать библиотеку в классы
    4. Отметить в проекте необходимые места для логирования
    
4. Создать базу данных (40 мин)
    1. Добавить миграцию(SQL скрипт) для создания таблиц:
        1. USERS
        ```
            Пользователь(Key), Хэш-пароля, Соль
        ```
        2. RESOURCES 
         ```
            Пользователь, Ресурс(Key), Роль
         ```
        3. ACCOUNTS
         ```
            Пользователь(Key), Дата начало, Дата окончания, Объем
         ```
    2. Добавить миграцию для заполнения таблиц тестовыми данными
    
5. Подключить миграции в проект с помощью библиотеки flyway (30 мин)
    1. Создать объект flyway
    2. Указать данные для создания БД
    3. вызвать метод flyway.migrate() для инициализации/подключения БД по миграциям
    
6. Создать main.bin.DAO классы (180 мин)
    1. UsersDAO
        Осуществляет взаимодействие с БД и поиском данных в таблице USERS
    2. ResourceDAO
        Осуществляет взаимодействие с БД и поиском данных в таблице RESOURCES
    3. AccountsDAO
        Осуществляет взаимодействие с БД и поиском данных в таблице ACCOUNTS
    4. ContextDB
        Осуществляет взаимодействие с БД. Берет информацию об БД.
  
#### Оценка времени 
  
Пункт плана            |Оценка времени    |Фактическое время
:----------------------| :--------------: | :---------------:
Как создать aaa.log с помощью библиотеки log4j?|60 мин | 120 мин
Как подключить миграции к H2 бд?|60 мин| 240 мин
Подключить библиотеку log4j|90 мин| 80 мин
Создать базу данных|40 мин| 35 мин
Подключить миграции в проект с помощью библиотеки flyway|30 мин| 15 мин
Создать main.bin.DAO классы|180 мин| 300 мин
Итого |460 мин| 790 мин (13 часов 10 мин)
На исследовательские задачи |210 мин| 440 мин (7 часов 20 мин)