/*
Задание:
Процедура удаления данных из таблицы products по id.
*/
create or replace procedure delete_id(d_id int)
    language 'plpgsql' as
$$
BEGIN
    delete from products where id = d_id;
end;
$$;

/*
Процедура удаления данных из таблицы products
всех позиций с количеством меньше или равно параметру функции.
*/
create or replace procedure delete_count(d_count integer)
    language 'plpgsql' as
$$
BEGIN
    delete from products where count <= d_count;
end;
$$;

/*
Функция удаления данных из таблицы products по id.
*/
create or replace function f_delete_id(d_id int)
    returns integer
    language 'plpgsql'
as
$$
declare
    rsl integer;
begin
    select into rsl id from products where id = d_id;
    delete from products where id = d_id;
    return rsl;
end;
$$;
/*
Функция удаления данных из таблицы products
всех позиций с количеством меньше или равно параметру функции.
*/
create or replace function f_delete_count(d_count integer)
    returns integer
    language 'plpgsql'
as
$$
declare
    rsl integer;
begin
    select into rsl count(id) from products where count <= d_count;
    delete from products where count <= d_count;
    return rsl;
end;
$$;