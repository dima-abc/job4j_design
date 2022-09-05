CREATE TABLE IF NOT EXISTS users 
(
	id serial PRIMARY KEY,
	name VARCHAR(30),
	age INTEGER
);

INSERT INTO users(name, age) VALUES('Dima', 25);
INSERT INTO users(name, age) VALUES('Gena', 48);
INSERT INTO users(name, age) VALUES('Ira', 18);

/***************************************************/
/*1. Чтение неподтвержденных данных, грязное чтение (read uncommitted, dirty read). MySQL*/
 
set session transaction isolation level read uncommitted;
/*Старт транзакции 1*/
START TRANSACTION;
select * from users;
/*
+----+------+------+
| id | name | age  |
+----+------+------+
|  1 | Dima |   25 |
|  2 | Gena |   48 |
|  3 | Ira  |   18 |
+----+------+------+
*/
/*Старт транзакции 2*/
START TRANSACTION;
select * from users;
/*
+----+------+------+
| id | name | age  |
+----+------+------+
|  1 | Dima |   25 |
|  2 | Gena |   48 |
|  3 | Ira  |   18 |
+----+------+------+
*/
/*Выполним операции INSERT, DELETE, UPDATE в первой транзакции*/
insert into users(name, age) values('Zinaida', 98);
delete from users where name = 'Dima';
update users set age = 75 where name = 'Gena';

/*Выберим данные второй тарнзакции и убедимся видны данные первой транзакции которые еще не зафексированы.*/
select * from users;
/*
+----+---------+------+
| id | name    | age  |
+----+---------+------+
|  2 | Gena    |   75 |
|  3 | Ira     |   18 |
|  4 | Zinaida |   98 |
+----+---------+------+
*/
select sum(age) from users;
/*
+----------+
| sum(age) |
+----------+
|      191 |
+----------+
*/
/*Откатываем данные первой транзакции транзакции*/
ROLLBACK;
/*Проверяем данные второй транзакции*/
select sum(age) from users;
/*
+----------+
| sum(age) |
+----------+
|       91 |
+----------+
*/
/*Видем эфект неповторного чтения, грязного чтенияб и фантомное чтение*/

/***************************************************/
/*2. Чтение подтвержденных данных (read committed)*/
/*Создаем таблицу users и первоночальные данные для этой таблицы*/
/*Старт транзакции 1 и проверяем ее данные*/
begin transaction;
select * from users;
/*
 id | name | age
----+------+-----
  1 | Dima |  25
  2 | Gena |  48
  3 | Ira  |  18
 */
/*Старт транзакции 2 и проверяем ее данные*/
begin transaction;
select * from users;
/*
 id | name | age
----+------+-----
  1 | Dima |  25
  2 | Gena |  48
  3 | Ira  |  18
*/

 /*Выполним операции INSERT, DELETE, UPDATE в первой транзакции и проверяем ее данные*/
insert into users(name, age) values('Zinaida', 98);
delete from users where name = 'Dima';
update users set age = 75 where name = 'Gena';
select * from users;
/*
 id |  name   | age
----+---------+-----
  3 | Ira     |  18
  4 | Zinaida |  98
  2 | Gena    |  75
 */
/*проверяем данные второй транзакции и видем отсутсвие феномена грязного чтения*/
select * from users;
/*
 id | name | age
----+------+-----
  1 | Dima |  25
  2 | Gena |  48
  3 | Ira  |  18
 */
/*Зафиксируем изменения (команда commit)*/
commit;
/*Проверяем данные во второй транзакции и видем феномен неповторяющегося чтения, а также феномен фантомного чтения*/
select * from users;
/*
 id |  name   | age
----+---------+-----
  3 | Ira     |  18
  4 | Zinaida |  98
  2 | Gena    |  75
*/
/*****************************************************/
/* 3. Повторяющееся чтение (repeatable read)*/
/*Создаем таблицу users и первоночальные данные для этой таблицы*/
/*Начинаем ПЕРВУЮ транзакцию и устонавливаем уровень изолированности*/
begin transaction isolation level repeatable read;
/*Начинаем ВТОРОЮ транзакцию и устонавливаем уровень изолированности*/
begin transaction isolation level repeatable read;
/*проверяем данные ПЕРВОЙ транзакции*/
select * from users;
/*
 id | name | age
----+------+-----
  1 | Dima |  25
  2 | Gena |  48
  3 | Ira  |  18
 */
/*проверяем данные ВТОРОЙ транзакции*/
select * from users;
/*
 id | name | age
----+------+-----
  1 | Dima |  25
  2 | Gena |  48
  3 | Ira  |  18
 */
/*Выполним операции INSERT, DELETE, UPDATE в первой транзакции и проверяем ее данные*/
insert into users(name, age) values('Zinaida', 98);
delete from users where name = 'Dima';
update users set age = 75 where name = 'Gena';
/*Во второй транзакции выполняем аналогичную каманду UPDATE и получаем LOCK*/
update users set age = 75 where name = 'Gena';
/*Откатываем первую транзакцию*/
rollback;
/*Вторая транзакция имеет выполняется и имеет первая транзакция завершилась с откатом и в итоге во второй мы не видим феноменов неповторяющегося чтения и чтения фантомов.*/
update users set age = 75 where name = 'Gena';
select * from users;
/*
 id | name | age
----+------+-----
  1 | Dima |  25
  3 | Ira  |  18
  2 | Gena |  75
 */
/*Случай когда ПЕРВАЯ транзакция завершилась успешно*/
begin transaction isolation level repeatable read;
insert into users(name, age) values('Zinaida', 98);
delete from users where name = 'Dima';
update users set age = 75 where name = 'Gena';
commit;
/*Вторая транзакцие произойдёт откат текущей транзакции с сообщением, так как транзакция уровня Repeatable Read не может изменять или блокировать строки, изменённые другими транзакциями с момента её начала.*/
begin transaction isolation level repeatable read;
update users set age = 75 where name = 'Gena';
/*
ОШИБКА:  не удалось сериализовать доступ из-за параллельного изменения
 */

/******************************************************/
/*Сериализация (serializable)*/
/*Создаем таблицу users и первоночальные данные для этой таблицы*/
/*Начинаем ПЕРВУЮ транзакцию*/
begin transaction isolation level serializable;
/*Начинаем ВТОРУЮ транзакцию*/
begin transaction isolation level serializable;
/*В ПЕРВОЙ тарнзакции находим сумму столбца AGE, далее обновляем одну запись*/
select sum(age) from users;
/*
 sum
-----
  91
 */
update users set age=15 where name = 'Dima';
/*Вторая транзакция находим сумму столбца AGE, далее так же обновляем одну из записей*/
select sum(age) from users;
/*
 sum
-----
  91
 */
update users set age = 35 where name = 'Gena';
/* Фикисруем изменения в ПЕРВОЙ транзакции */
commit;
/*Фикисруем изменения во ВТОРОЙ транзакции*/
commit;
/*
ОШИБКА:  не удалось сериализовать доступ из-за зависимостей чтения/записи между транзакциями
ПОДРОБНОСТИ:  Reason code: Canceled on identification as a pivot, during commit attempt.
ПОДСКАЗКА:  Транзакция может завершиться успешно при следующей попытке.
*/