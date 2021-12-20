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

select avg(price) from devices;

select avg(d.price) from devices_people AS dp
inner join devices AS d
on dp.device_id=d.id
group by dp.people_id;

select avg(d.price) from devices_people AS dp
inner join devices AS d
on dp.device_id=d.id
group by dp.people_id
having avg(d.price)>5000;