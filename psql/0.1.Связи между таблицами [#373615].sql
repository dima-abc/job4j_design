create table passenger(
	id serial primary key,
	name varchar(255)
);

create table airplane(
	id serial primary key,
	name varchar(255)
);

create table ticket(
	id serial primary key,
	pesenger_id int references passenger(id) unique
);

create table flight(
	id serial primary key,
	airplane_id int references airplane(id),
	ticket_id int references ticket(id)
);

create table flight_airplane(
	id serial primary key,
	airplane_id int references airplane(id),
	flight_id int references flight(id)
);

create table pessenger_ticket(
	id serial primary key,
	passenger_id int references passenger(id) unique,
	ticket_id int references ticket(id) unique
);