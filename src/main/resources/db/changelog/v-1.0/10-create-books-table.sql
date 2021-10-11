CREATE TABLE books
(
    id        BIGSERIAL    NOT NULL,
    name      VARCHAR(255) NOT NULL,
    exist     BOOLEAN      NOT NULL,
    author_id INT8         NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (author_id) REFERENCES authors
)
GO

INSERT INTO books (name, exist, author_id)
VALUES ('Капитанская дочка', true, 1),
       ('Пиковая дама', false, 1),
       ('Руслан и людмила', true, 1),
       ('Медный всадник', false, 1),
       ('Мертвые души', true, 2),
       ('Тарас Бульба', false, 2),
       ('Вий', true, 2)
GO