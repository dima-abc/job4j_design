/*Тригерная функиця для вычичления скидки от количиства на уровне строки*/
create or replace function discount()
returns trigger as
    $$
    BEGIN
        update products
        set price = price - products.price * 0.2
        where count <= 5 and id = new.id;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';