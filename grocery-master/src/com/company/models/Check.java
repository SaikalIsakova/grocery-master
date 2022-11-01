package com.company.models;


public class Check {
private long id;
private Employee employee;
private String add_date;
private int num_of_check;
private double totalSum;
private int fd;

    public Check() {
    }

    public Check(long id, Employee employee, String add_date, int num_of_check, double totalSum, int fd) {
        this.id = id;
        this.employee = employee;
        this.add_date = add_date;
        this.num_of_check = num_of_check;
        this.totalSum = totalSum;
        this.fd = fd;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getAdd_date() {
        return add_date;
    }

    public void setAdd_date(String add_date) {
        this.add_date = add_date;
    }

    public int getNum_of_check() {
        return num_of_check;
    }

    public void setNum_of_check(int num_of_check) {
        this.num_of_check = num_of_check;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    public int getFd() {
        return fd;
    }

    public void setFd(int fd) {
        this.fd = fd;
    }

    @Override
    public String toString() {
        return
                " Общая сумма =" + totalSum ;
    }
}
