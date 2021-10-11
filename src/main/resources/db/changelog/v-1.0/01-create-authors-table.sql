CREATE TABLE authors
(
    id         BIGSERIAL    NOT NULL,
    firstname  VARCHAR(255) NOT NULL,
    patronymic VARCHAR(255) NOT NULL,
    surname    VARCHAR(255) NOT NULL,
    birthday   DATE    NOT NULL,
    biography  VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
)
GO

INSERT INTO authors (firstname, patronymic, surname, birthday, biography)
VALUES ('Александр', 'Сергеевич', 'Пушкин', '1799-06-06',
        'Александр Пушкин начал писать свои первые произведения уже в семь лет.'),
       ('Николай', 'Васильевич', 'Гоголь', '1809-04-01',
        'Когда первую поэму Николая Гоголя раскритиковали современники, он выкупил и сжег весь тираж.')
GO