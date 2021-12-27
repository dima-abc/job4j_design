package ru.job4j.jdbc;

/**
 * 2.3.5. JDBC
 * 0.2. PrepareStatement [#379307]
 * пример.
 * Модель данных City.
 *
 * @author Dmitry
 * @since 27.12.2021
 */
public class City {
    private int id;
    private String name;
    private int population;

    public City(int id, String name, int population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
