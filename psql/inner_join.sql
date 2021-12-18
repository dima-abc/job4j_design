CREATE TABLE bread(
	id serial primary key,
	name varchar(255),
	price numeric(10,2)
);
CREATE TABLE bakery(
	id serial primary key,
	address varchar(255),
	bread_id int references bread(id)
);
INSERT INTO bread(name, price) values('Хлеб белый',45);
INSERT INTO bread(name, price) values('Хлеб черный', 50);
INSERT INTO bread(name, price) values('Ватрушка с второгом', 70);
INSERT INTO bread(name, price) values('Хлебные палочки', 15);
INSERT INTO bread(name, price) values('Пирожок с мясом', 30);
INSERT INTO bread(name, price) values('Пирожок с яблоком', 25);

INSERT INTO bakery(address, bread_id) values('Москва', 6);
INSERT INTO bakery(address, bread_id) values('Калуга', 6);
INSERT INTO bakery(address, bread_id) values('Курск', 6);
INSERT INTO bakery(address, bread_id) values('Москва', 7);
INSERT INTO bakery(address, bread_id) values('Калуга', 7);
INSERT INTO bakery(address, bread_id) values('Курск', 7);
INSERT INTO bakery(address, bread_id) values('Москва', 8);
INSERT INTO bakery(address, bread_id) values('Калуга', 8);
INSERT INTO bakery(address, bread_id) values('Курск', 8);
INSERT INTO bakery(address, bread_id) values('Москва', 9);
INSERT INTO bakery(address, bread_id) values('Калуга', 9);
INSERT INTO bakery(address, bread_id) values('Курск', 9);
INSERT INTO bakery(address, bread_id) values('Москва', 10);
INSERT INTO bakery(address, bread_id) values('Калуга', 10);
INSERT INTO bakery(address, bread_id) values('Курск', 10);
INSERT INTO bakery(address, bread_id) values('Москва', 11);
INSERT INTO bakery(address, bread_id) values('Калуга', 11);
INSERT INTO bakery(address, bread_id) values('Курск', 11);

SELECT sh.address AS МАГАЗИН, br.name AS ПРОДУКЦИЯ
FROM bakery AS sh INNER JOIN bread AS br
ON sh.bread_id=br.id AND br.price<30 ORDER BY sh.address;

SELECT br.name AS НАЗВАНИЕ, br.price AS ЦЕНА, sh.address AS АДРЕС
FROM bread AS br INNER JOIN bakery AS sh
ON sh.bread_id=br.id AND sh.address = 'Москва' AND br.price>40 ORDER BY br.price;

SELECT sh.address AS ГОРОД, br.price AS ЦЕНА
FROM bakery AS sh INNER JOIN bread AS br
ON sh.bread_id=br.id AND br.name='Хлеб белый' ORDER BY sh.address DESC;