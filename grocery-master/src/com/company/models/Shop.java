package com.company.models;

public class Shop {
    private int id;
    private  String name;
    private boolean active;

    public Shop() {
    }

    public Shop(String name) {
        this.name = name;
    }

    public Shop(int id, String name, boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + active +
                "\n";
    }
}