/*
2. Триггер срабатывает до вставки данных
    и высчитывать налог на товар. Здесь используем row уровень.
*/
create trigger trigger_tax_before
    before insert
    on products
    for each row
    execute function tax_calc();