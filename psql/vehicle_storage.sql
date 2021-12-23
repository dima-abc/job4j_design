/*1. Нужно написать SQL скрипты*/
/*1.1 Создать структур данных в базе.Таблицы.
   Кузов. Двигатель, Коробка передач.*/
create database vehicle_storage;

create table body(
	id serial primary key,
	name varchar(255)
);

create table engine(
	id serial primary key,
	name varchar(255)
);

create table transmission(
	id serial primary key,
	name varchar(255)
);
/*1.2 Создать структуру Машина. Машина не может существовать без данных из п.1.*/
create table auto(
	id serial primary key,
	name varchar(255) NOT NULL,
	body_id int references body(id) NOT NULL,
	engine_id int references engine(id) NOT NULL,
	trans_id int references transmission(id) NOT NULL,
	CHECK((name!='') 
	and (body_id != 0) 
	and (engine_id != 0) 
	and (trans_id != 0))
);
/*1.3 Заполнить таблицы через insert.*/
insert into body(name) values ('Хэчбэк'), ('Седан'), 
('Универсал'), ('Лифтбэк');

insert into engine(name) values ('1.0 I'), ('2.0 I'), 
('1.0 TI'), ('2.0 TI'), ('1.0 D'), ('2.0 D'), 
('1.0 DTI'), ('2.0 DTI'), ('H2O'), ('Uran'); 

insert into transmission(name) values ('6 MT'), ('7 МТ'), ('5 МТ'),
('6 AT'), ('7 AТ'), ('5 AТ'), ('Variable'), ('foot');

insert into auto(name, body_id, engine_id, trans_id)
values ('Lada Vesta', 1, 4, 2), ('Ford focus', 3, 8, 4), 
('Lada Vesta', 3, 2, 4), ('SKODA RAPID', 4, 3, 5),
('Lada Vesta', 1, 2, 2), ('Lada Vesta', 3, 8, 4), 
('KIA CEED', 3, 2, 4), ('SKODA RAPID', 4, 2, 5);

/*2. Создать SQL запросы:*/
/*2.1 Вывести список всех машин и все привязанные к ним детали.*/
select * from auto a
left join body b
on a.body_id=b.id
left join engine e
on a.engine_id = e.id
left join transmission t
on a.trans_id=t.id;

/*2.2 Вывести отдельно детали (1 деталь - 1 запрос), которые не используются НИ в одной машине, кузова, двигатели, коробки передач.*/
select * from body b
left join auto a
on b.id=a.body_id
where a.body_id is null;

select * from engine e
left join auto a
on e.id=a.engine_id
where a.engine_id is null;

select * from transmission t
left join auto a
on e.id=a.trans_id
where a.trans_id is null;