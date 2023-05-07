# NoSqlMongoDb
Створити User Document (id, firstName, LastName, email, age, isMarried)

Додати в базу 5 азерів за допомогою SpringData i 5 за допомогою mongosh (код додавання додати в ревю дз)

Реалізувати наступні операції використовуючи MongoDB через Spring Data:

Вивести юзера за:

-- firstName

-- lastName

-- email

Вивести всіх хто старше 18

Вивести всіх одружених

Також всі ці операції виконати через mongosh i додати в дз файл. - Файл називається mongoSh
# Task 2 Integration testing
1)  Cover one of your previous homework with test. Achieve at least 80% test coverage.

2) Optional.  

2.1 Write CatService that makes REST call to https://catfact.ninja/fact

2.2 Write @SpringBootTest integration test on this service

2.3 Use Wiremock to mock catfact webserver

2.4 Use @TestProperty to change catfact’s URL from https://catfact.ninja to localhost:XXXX where XXXX - your Wiremock port
