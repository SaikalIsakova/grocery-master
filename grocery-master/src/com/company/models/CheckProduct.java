package com.company.models;

public class CheckProduct {
    private Long id;
    private Product product;
    private Check check ;
    private int count;
    private double cost;

    public CheckProduct() {
    }

    public CheckProduct(Long id, Product product, Check check, int count, double cost) {
        this.id = id;
        this.product = product;
        this.check = check;
        this.count = count;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Check getCheck() {
        return check;
    }

    public void setCheck(Check check) {
        this.check = check;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return
                "Продукт : " + product +
                ", Чек = " + check +
                ", Количество =" + count +
                ", Стоисоть =" + cost;
    }
}
