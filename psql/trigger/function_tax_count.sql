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