create table medical (
	id serial primary key,
	name varchar(255),
	proffecion varchar(255),
	age int,
	berthday date
);
select * from medical;
insert into medical(name, proffecion, age, berthday) 
values('D.N. Ivanov', 'surgeon', '35', '09.05.1986');
select * from medical;
update medical set age = '30', berthday = '01.05.1991';
select * from medical;
delete from medical;
select * from medical;