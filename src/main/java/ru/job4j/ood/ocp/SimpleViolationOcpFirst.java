package ru.job4j.ood.ocp;

/**
 * 2.5.2. OCP
 * 0. Принцип открытости закрытости [#4914].
 * Нарушение OCP 1.
 * Метод premiumSize вычисляет премию модели User.
 * Если потребуется вычислить премию для другой модели потребуется переписывать метод,
 * или создавать новый метод.
 * Решение создать интерфейс с определенными методами getExperience, getPremium
 * и все модели наследовать от него. В сам метод принимать интерфейс, а не модель данных.
 *
 * @author Dima_Nout
 * @since 03.02.2022
 */
public class SimpleViolationOcpFirst {

    public Integer premiumSize(User user) {
        return user.getExperience() * user.getPremium();
    }

    private static class User {
        String name;
        Integer experience;
        Integer premium;

        User(String name, Integer experience, Integer premium) {
            this.name = name;
            this.experience = experience;
            this.premium = premium;
        }

        public String getName() {
            return name;
        }

        public User setName(String name) {
            this.name = name;
            return this;
        }

        public Integer getExperience() {
            return experience;
        }

        public User setExperience(Integer experience) {
            this.experience = experience;
            return this;
        }

        public Integer getPremium() {
            return premium;
        }

        public User setPremium(Integer premium) {
            this.premium = premium;
            return this;
        }
    }
}
