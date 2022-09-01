/*
Процедуру insert_data, которая будет принимать 4 параметра с разными типами
и при этом добавлять новую запись в БД.
*/
create or replace procedure insert_data(i_name varchar, prod varchar,
                                        i_count integer, i_price integer)
    language 'plpgsql'
as
$$
BEGIN
    insert into products (name, producer, count, price)
    values (i_name, prod, i_count, i_price);
end
$$;

/*
Процедура для обновления данных в таблице.
При этом процедура будет принимать 3 параметра
– количество товара, налог, а также id записи.
Если количество товара, передаваемое в метод больше 0,
то мы уменьшаем на это количество товара у записи с передаваемым id.
Если же налог больше 0, то надо увеличить price у всех записей на сумму налога.
*/
create or replace procedure update_data(u_count integer, tax float, u_id integer)
    language 'plpgsql' as
$$
BEGIN
    if u_count > 0 then
        update products set count = count - u_count where id = u_id;
    end if;
    if tax > 0 then
        update products set price = price + products.price * tax;
    end if;
end;
$$;

/*
Создание функции для вставки данных в таблицу
*/
create or replace function f_insert_data(i_name varchar, prod varchar, i_count integer, i_price integer)
returns void
language 'plpgsql'
as
    $$
    begin
        insert into products (name, producer, count, price)
        values (i_name, prod, i_count, i_price);
    end;
    $$;
/*
Создание функция для обновления данных
*/
create or replace function f_update_data(u_count integer, tax float, u_id integer)
returns integer
language 'plpgsql'
as
    $$
    declare
        rsl integer;
    BEGIN
        if u_count > 0 then
            update products set count = count - u_count where id = u_id;
            select into rsl count from products where id = u_id;
        end if;
        if tax > 0 then
            update products set price = price + products.price * tax;
            select into rsl sum(price) from products;
        end if;
        return rsl;
    end;
$$;
