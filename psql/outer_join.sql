/*1. Создать таблицы и заполнить их начальными данными*/
create table departments(
	id serial primary key,
	name varchar(255)
);

create table emploers(
	id serial primary key,
	name varchar(255),
	depart_id int references departments(id)
);

insert into departments(name) values('Отдел опта'), ('Юристы'), 
('Экономисты'), ('Кадры'), ('Бухгалтерия');
insert into emploers(name,depart_id) values
('Смирнов С.В.', 1), ('Еремин С.А.', 1), ('Птушина Е.В.', null),
('Сторчак В.Г', 2), ('Петкун П.В', 2), ('Мишин В.В', null),
('Косина А.В', 3), ('Мосина П.П.', 3), ('Пусина К.К.', null),
('Милимиди А.У.', 4), ('Холянкина У.Й.', 4), ('Сирькин У.К.', null);

/*2. Выполнить запросы с left, rigth, full, cross соединениями*/
select * from emploers em
left join departments de
on em.depart_id=de.id;

select * from emploers em
right join departments de
on em.depart_id=de.id;

select * from emploers em
full join departments de
on em.depart_id=de.id;

select * from emploers
cross join departments;

/*3. Используя left join найти департаменты, у которых нет работников*/
select * from departments de
left join emploers em
on de.id=em.depart_id
where em.depart_id is null;

/*4. Используя left и right join написать запросы, которые давали бы одинаковый результат. */
select * from emploers em
left join departments de
on em.depart_id=de.id;

select * from departments de
right join emploers em
on de.id=em.depart_id;

/*5. Создать таблицу teens с атрибутами name, gender и заполнить ее. Используя cross join составить все возможные разнополые пары.*/
create table teens(
	id serial primary key,
	name varchar(255),
	gender varchar(255)
);

insert into teens(name, gender) values ('Ваня', 'М'), ('Таня', 'Ж'),
('Даша', 'Ж'), ('Дима', 'М'), ('Саша', 'М'), ('Диана', 'Ж');

select m.name AS муж, 
w.name AS жен, m.gender, w.gender
from teens m
cross join teens w
where m.gender!=w.gender;