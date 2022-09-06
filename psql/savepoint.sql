/*Создание таблицы для хранения книг и заполнение первичными данными*/

CREATE TABLE IF NOT EXISTS books
(
    id serial primary key,
    author VARCHAR(50),
    name TEXT,
    count INTEGER,
    price DECIMAL
);

insert into books(author, name, count, price) values('Пушкин А.С.', 'Буря', 10, 560.22);
insert into books(author, name, count, price) values('Чехов А.П.', 'Анюта', 5, 1000.00);
insert into books(author, name, count, price) values('Куприн А.И.', 'Олеся', 7, 333.00);

/*Начала транзакции*/
START TRANSACTION;

insert into books(author, name, count, price) values('Островский А.Н.', 'Гроза', 50, 100.00);

/*Создадим точку сохранения edit_price*/
SAVEPOINT edit_price;
/*Внесем изменение в таблицу*/
update books set price = price * 0.8 WHERE count > 8;

SELECT * FROM books;
/*Создадим точку сохранения edit_count*/
SAVEPOINT edit_count;
/*Внесем изменения*/
UPDATE books set count = count * 2 WHERE count<=5;

SELECT * FROM books;
/*Откатимся до точки сохранения edit_count*/
ROLLBACK TO edit_count;

SELECT * FROM books;
/*Создадим точку сохранения all_delete*/
SAVEPOINT all_delete;
/*Внесем изменения.*/
DELETE FROM books;

SELECT * FROM books;
/*Откатимся к точке edit_price*/
ROLLBACK TO edit_price;

SELECT * FROM books;

/*Сохраним внесенная изменения*/
COMMIT TRANSACTION;
SELECT * FROM books;


