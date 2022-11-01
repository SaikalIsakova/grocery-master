package com.company.models;

public class Employee {
    private int id;
    private String name;
    private int age;
    private int number;

    private Shop shopId;
    private boolean active;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(int id, String name, int age, int number) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.number = number;
        this.active = true;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Shop getShopId() {
        return shopId;
    }

    public void setShopId(Shop shopId) {
        this.shopId = shopId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", number=" + number +
                ", shopId=" + shopId +
                ", active=" + active +
                "\n";
    }
}
