package ru.job4j.gc;

public class User {
    private int id;
    private Integer serial;
    private String name;
    private String[] kidsName;
    private Integer[] kardNum;

    public User() {
    }

    public User(int id, Integer serial, String name, String[] kidsName, Integer[] kardNum) {
        this.id = id;
        this.serial = serial;
        this.name = name;
        this.kidsName = kidsName;
        this.kardNum = kardNum;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %s%n", id, name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getKidsName() {
        return kidsName;
    }

    public void setKidsName(String[] kidsName) {
        this.kidsName = kidsName;
    }

    public Integer[] getKardNum() {
        return kardNum;
    }

    public void setKardNum(Integer[] kardNum) {
        this.kardNum = kardNum;
    }
}
