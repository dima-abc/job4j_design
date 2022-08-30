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