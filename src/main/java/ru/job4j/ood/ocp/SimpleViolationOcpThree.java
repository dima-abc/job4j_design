package ru.job4j.ood.ocp;

/**
 * 2.5.2. OCP
 * 0. Принцип открытости закрытости [#4914].
 * Нарушение OCP 3. Метод проверяет положительный ли баланс на счету.
 * Если потребуется проверять баланс,
 * который попадает в определенный лимит для снятия,
 * то лучше передавать Predicate.
 *
 * @author Dima_Nout
 * @since 03.02.2022
 */
public class SimpleViolationOcpThree {
    public boolean balance(Account account) {
        return account.balance > 0;
    }

    private static class Account {
        Integer id;
        Integer balance;

        Account(Integer id, Integer balance) {
            this.id = id;
            this.balance = balance;
        }
    }
}
