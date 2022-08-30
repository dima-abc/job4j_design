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