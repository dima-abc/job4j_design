--Создание таблицы company--
CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);
--Создание таблицы person--
CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);
--Вставка данных в таблицу company--
insert into company(id, name) values(1, 'ООО "Рога и Капыта"'), (2, 'ООО "Контур"'),
(3, 'ООО "Калуга Астрал"'), (4, 'ООО "Топаз-Сервис"'), (5, 'Сервис ЮГ ККМ');
--Вставка данных в таблицу person--
insert into person(id, name, company_id) values(1, 'Fedora', 1), (2, 'Egora', 1),
(3, 'Tomara', 2), (4, 'Dorado',2), (5, 'Masha', 3), (6, 'Dasha', 3), 
(7, 'Sveta', 4), (8, 'Diana', 4), (9, 'Ira', 5), (10, 'Galya', 5), 
(11, 'Faina', 2), (12, 'Alina', 2), (13, 'Denis',5), (14, 'Sasha', 5);
/*1-В одном запросе получить
- имена всех person, которые не состоят в компании с id = 5;
- название компании для каждого человека.*/
select p.name as PERSON_NAME, c.name as COMPANY_NAME from person p
inner join company c
on p.company_id = c.id AND p.company_id!=5;
/*2-Необходимо выбрать название компании с максимальным количеством человек + количество человек в этой компании(нужно учесть, что таких компаний может быть несколько).*/
with counter as (select c.name as company_name, count(*) as cou from company c
inner join person p 
on p.company_id=c.id
group by c.name)
select * from counter where counter.cou=(select max(counter.cou) from counter);
--вариант 2 по подсказке Lana Sergeeva--
select c.name as COMPANY_NAME, count(*) as COUNT_PERSON from company c
inner join person p
on p.company_id=c.id
group by c.name
having count(p.id) = (select count(company_id) from person a
                        group by a.company_id
                        order by a.company_id desc limit 1)
