CREATE TABLE type(
	id serial PRIMARY Key,
	name VARCHAR(255)
);

CREATE TABLE product(
	id serial PRIMARY Key,
	name VARCHAR(255),
	type_id int references type(id),
	expired_date DATE,
	price NUMERIC(10,2)
);

INSERT INTO type(name) VALUES ('СЫР'),('СМЕТАНА'),('ТВОРОГ'),('МОЛОКО')('МОРОЖЕНОЕ');
INSERT INTO product(name, type_id, expired_date, price) VALUES
('Пармезан', 1, '01.03.2022', 500.50),
('Ламбер', 1, '19.12.2021', 250.00),
('Сулугуни', 1, '01.02.2022',150.00),
('Российский', 1, '30.12.2021', 200.00),
('Сыр плавленный', 1, '26.12.2021', 45.00),
('Сыр моцарелла', 1, '10.01.2022', 350.00),
('Пармезан', 1, '15.03.2022', 500.50),
('Ламбер', 1, '13.12.2021', 250.00),
('Сулугуни', 1, '01.01.2022',150.00),
('Российский', 1, '30.01.2022', 200.00),
('Термостатная 15%', 2, '01.12.2021', 80.00),
('Термостатная 25%', 2, '01.12.2021', 99.00),
('Жирность 20%', 2, '15.01.2022', 90.00),
('Жирность 25%', 2, '10.01.2022', 120.00),
('Жирность 15%', 2, '31.12.2021', 60.00),
('Зернистый 9%', 3, '19.12.2021', 98.00),
('Обезжиренный 1%', 3, '25.12.2021', 50.00),
('Фермерское 5%', 4, '28.12.2021', 70.00),
('Домашнее 3%', 4, '30.12.2021', 60.00),
('Мороженое ПОЧЕМУЧКА', 5, '06.05.2022', 90.00),
('Лакомка мороженое', 5, '01.09.2022', 110.00);

/*1 запрос получение всех продуктов с типом "СЫР"*/
SELECT DISTINCT tp.name AS ТИП, pr.name AS НАЗВАНИЕ FROM product AS pr
inner join type AS tp
ON pr.type_id=tp.id AND tp.name='СЫР'
ORDER BY pr.name;

/*2 запрос получения всех продуктов, у кого в имени есть слово "мороженое"*/
SELECT pr.name AS ИМЯ, pr.price AS ЦЕНА FROM product AS pr
WHERE pr.name ILIKE '%мороженое%'
ORDER BY pr.name;

/*3 запрос, который выводит все продукты, срок годности которых уже истек*/
SELECT pr.name AS ИМЯ, pr.expired_date AS СРОК_ГОДНОСТИ FROM product AS pr
WHERE pr.expired_date<CURRENT_DATE
ORDER BY pr.expired_date;

/*4 запрос, который выводит самый дорогой продукт*/
SELECT max(price) FROM product;

/*5 запрос, который выводит для каждого типа количество продуктов к нему принадлежащих. В виде имя_типа, количество*/
SELECT tp.name AS имя_типа, COUNT(pr.type_id) AS количество FROM product AS pr
inner join type AS tp 
ON pr.type_id=tp.id
GROUP BY tp.name;

/*6 запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"*/
SELECT DISTINCT tp.name AS ТИП, pr.name AS НАЗВАНИЕ FROM product AS pr
inner join type AS tp
ON pr.type_id=tp.id AND tp.name='СЫР' OR tp.name='МОЛОКО'
ORDER BY tp.name;

/*7 запрос, который выводит тип продуктов, которых осталось меньше 10 штук. Под количеством подразумевается количество продуктов определенного типа. Например, если есть тип "СЫР" и продукты "Сыр плавленный" и "Сыр моцарелла", которые ему принадлежат, то количество продуктов типа "СЫР" будет 2. */
SELECT tp.name AS имя_типа, COUNT(pr.type_id) AS количество_меньше_10 FROM product AS pr
inner join type AS tp
ON pr.type_id=tp.id
GROUP BY tp.name
HAVING COUNT(pr.type_id)<10;

/*8 Вывести все продукты и их тип.*/
SELECT DISTINCT pr.name AS продукт, tp.name AS тип FROM product AS pr
inner join type AS tp
ON pr.type_id=tp.id
ORDER BY tp.name;