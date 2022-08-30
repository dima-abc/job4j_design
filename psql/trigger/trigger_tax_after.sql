/*1. Триггер срабатывает после вставки данных,
  для любого товара и просто насчитывать налог на товар.
  Действует он не на каждый ряд, а на запрос (statement уровень)*/
create trigger trigger_tax_after
    after insert on products
    referencing new table as inserted
    for each statement
    execute procedure tax_count();