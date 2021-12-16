create table roles(
	id serial primary key,
	role_name varchar(255)
);

create table rules(
	id serial primary key,
	rule_name varchar(255)
);

create table roles_rules(
	id serial primary key,
	role_id int references roles(id),
	rule_id int references rules(id)
);

create table states(
	id serial  primary key,
	state_name varchar(255)
);

create table category(
	id serial primary key,
	category_name varchar(255)
);

create table users(
	id serial primary key,
	user_name varchar(255),
	role_id int references roles(id),
);

create table item(
	id serial primary key,
	item_name varchar(255),
	user_id int references users(id)
	category_id int references category(id),
	state_id int references states(id)
);

create table attachs(
	id serial primary key,
	file text,
	item_id int references item(id)
);

create table comments(
	id serial primary key,
	comment text,
	item_id int references item(id)
);



