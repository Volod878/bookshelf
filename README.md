## REST-сервис, который обращается к книжной полке

> Сервис реализован на локальном сервере.

### Используемые технологии

> + Java 8
> + Spring Boot 2
> + PostgreSQL, Liquibase, Hibernate
> + Maven

### Запуск сервиса

#### PostgreSQL

> Необходимо создать базу данных `bookshelf`
>
> username: `postgres`
>
> password: `password`

#### Maven

> Для сборки проекта пишем в терминале:
>
> `mvn clean package`

### Примеры запросов GET

+ http://localhost:8000/api/books - Получить все книги

+ http://localhost:8000/api/books?sort_by=id - Получить все книги отсортированные по порядковому номеру

+ http://localhost:8000/api/books?sort_by=name - Получить все книги отсортированные по наименованию

+ http://localhost:8000/api/books/filter?exist=true Получить все книги которые есть на полке

+ http://localhost:8000/api/author/1/books Получить все книги автора с id = 1

### Примеры запросов POST

> + http://localhost:8000/api/author/1/books - Добавить книгу автора с id = 1 Тело запроса
>
> Тело запроса
> ```json
> {
>   "name": "Сказка о рыбаке и рыбке",
>   "exist": true
> }
> ```

> + http://localhost:8000/api/author - Добавить автора
>
> Тело запроса
> ```json
> {
>   "firstname": "Лев",
>   "patronymic": "Николаевич",
>   "surname": "Толстой",
>   "birthday": "1828-08-28",
>   "biography": "Граф Лев Николаевич Толсто́й — один из наиболее известных русских писателей и мыслителей."
> }
> ```

### Примеры запросов PUT

> + http://localhost:8000/api/books - Редактировать книгу
>
> Тело запроса
> ```json
> {
>   "id": 1,
>   "name": "Капитанская дочка",
>   "exist": false
> }
> ```

> + http://localhost:8000/api/author - Редактировать автора
>
> Тело запроса
> ```json
> {
>   "id": 1,
>   "firstname": "Александр",
>   "patronymic": "Сергеевич",
>   "surname": "Пушкин",
>   "birthday": "1799-06-06",
>   "biography": "Алекса́ндр Сергеевич Пушкин — русский поэт"
> }
> ```

### Примеры запросов DELETE
> + http://localhost:8000/api/books/8 - Удалить книгу с id = 8