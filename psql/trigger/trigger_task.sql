/*1. Триггер срабатывает после вставки данных,
  для любого товара и просто насчитывать налог на товар.
  Действует он не на каждый ряд, а на запрос (statement уровень)*/
/*
Функция высчитывает налог
*/
create or replace function tax_count()
    returns trigger as
$$
BEGIN
    update products
    set price = price * 1.2
    where id = (select id from inserted);
    return new;
end;
$$
    LANGUAGE 'plpgsql';

/*Сам триггер*/
create trigger trigger_tax_after
    after insert on products
    referencing new table as inserted
    for each statement
    execute procedure tax_count();

/*
2. Триггер срабатывает до вставки данных
    и высчитывать налог на товар. Здесь используем row уровень.
*/
/*
Функция высчитывает налог
*/
create or replace function tax_calc()
    returns trigger as
$$
BEGIN
    new.price = new.price * 1.2;
    return new;
END;
$$
    LANGUAGE 'plpgsql';
/*
Триггер
*/
create trigger trigger_tax_before
    before insert
    on products
    for each row
execute function tax_calc();

/*
3. Таблица истории занесения данных в price
*/
create table history_of_price (
                                  id serial primary key,
                                  name varchar(50),
                                  price integer,
                                  date timestamp
);

/*
Функция вставки данных в таблицу history_of_price
*/
create or replace function function_history_price()
    returns trigger as
$$
BEGIN
    insert into history_of_price(name, price, date) values (new.name, new.price, now());
    return new;
END;
$$
    LANGUAGE 'plpgsql';

/*
Триггер на row уровне,
который при вставке продукта в таблицу products,
будет заносить имя, цену и текущую дату в таблицу history_of_price.
*/
create trigger trigger_history_product
    after insert
    on products
    for each row
execute procedure function_history_price();