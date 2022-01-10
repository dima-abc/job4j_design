CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);
insert into company(id, name) values(1, 'ООО "Рога и Капыта"'), (2, 'ООО "Контур"'),
(3, 'ООО "Калуга Астрал"'), (4, 'ООО "Топаз-Сервис"'), (5, 'Сервис ЮГ ККМ');