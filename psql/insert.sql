
insert into roles(role_name) values('Бухгалтер');
insert into roles(role_name) values('Менеджер');
insert into roles(role_name) values('Кассир');

insert into rules(rule_name) values('Admin');
insert into rules(rule_name) values('User');

insert into roles_rules(role_id, rule_id) values(13,9);
insert into roles_rules(role_id, rule_id) values(14,8);
insert into roles_rules(role_id, rule_id) values(15,9);

insert into states(state_name) values('Создана');
insert into states(state_name) values('В работе');
insert into states(state_name) values('Исполнена');

insert into category(category_name) values('Срочная');
insert into category(category_name) values('Не срочная');

insert into users(user_name, role_id) values ('Яцекно Ю.С.', 13);
insert into users(user_name, role_id) values ('Васько Я.Д.', 14);
insert into users(user_name, role_id) values ('Волкова И.Н.', 15);

insert into item(item_name, user_id, category_id, state_id) values ('нет интернета', 2, 1, 3);
insert into item(item_name, user_id, category_id, state_id) values ('Не открывается база 1С', 1, 1, 2);
insert into item(item_name, user_id, category_id, state_id) values ('Банк не доступен', 2, 2, 2);

insert into attachs(file, item_id) values('c:\dogovra\inet.log', 1);
insert into attachs(file, item_id) values('c:\dogovra\1c.log', 2);
insert into attachs(file, item_id) values('c:\dogovra\banc.log', 3);

insert into comments(comment, item_id) values('нет интернета, работа остановлена облачные сервисы не доступны', 1);
insert into comments(comment, item_id) values('База ЗУП постоянно отваливается', 2);
insert into comments(comment, item_id) values('Просрочен сертификат ЭЦП доступа к банку, платежи не доступны', 3);