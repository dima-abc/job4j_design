/*
Функция высчитывает налог
*/
create or replace function tax_calc()
    returns trigger as
$$
BEGIN
    new.tax = new.price * 0.2;
    return new;
END;
$$
    LANGUAGE 'plpgsql';