CREATE TABLE devices(
    id serial PRIMARY KEY,
    name varchar(255),
    price float
);

CREATE TABLE people(
    id serial PRIMARY KEY,
    name varchar(255)
);

CREATE TABLE devices_people(
    id serial PRIMARY KEY,
    device_id int REFERENCES devices(id),
    people_id int REFERENCES people(id)
);

insert into devices(name, price) values ('Планшет', 30000), ('Смартфон', 20000), ('Настолный ПК', 65000), ('Умные часы', 41000);
insert into people(name) values ('Николай'), ('Арсен'), ('Анна'), ('Лана');
insert into devices_people(device_id, people_id) values (1,2),(1,4),(2,1),(2,2),(3,2),(3,3),(3,4),(4,1),(4,2),(4,3),(4,4);

/*3. Используя агрегатные функции вывести среднюю цену устройств.*/
select avg(price) from devices;

/*4. Используя группировку вывести для каждого человека среднюю цену его устройств.*/
select pe.name AS имя, avg(d.price) AS средняя_цена from devices_people AS dp
inner join devices AS d
on dp.device_id=d.id
inner join people AS pe
on dp.people_id=pe.id
group by pe.name;

/*5. Дополнить запрос п.4. условием, что средняя стоимость устройств должна быть больше 5000.*/
select pe.name AS имя, avg(d.price) AS средняя_цена from devices_people AS dp
inner join devices AS d
on dp.device_id=d.id
inner join people AS pe
on dp.people_id=pe.id
group by pe.name
having avg(d.price)>5000;