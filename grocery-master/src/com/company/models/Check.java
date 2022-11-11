package com.company.models;


public class Check {
private long id;
private Employee employee_id;
private String add_date;
private double totalSum;
private int fd;

    public Check() {
    }

    public Check(long id, Employee employee, String add_date, double totalSum, int fd) {
        this.id = id;
        this.employee_id = employee;
        this.add_date = add_date;
        this.totalSum = totalSum;
        this.fd = fd;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Employee getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Employee employee_id) {
        this.employee_id = employee_id;
    }

    public String getAdd_date() {
        return add_date;
    }

    public void setAdd_date(String add_date) {
        this.add_date = add_date;
    }


    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    public int getFd() {

        int a=new java.util.Random().nextInt(99)+1;
        return a;
    }

    public void setFd(int fd) {
        this.fd = fd;
    }

    @Override
    public String toString() {
        return

                "id ="+id+
                " Общая сумма =" + totalSum ;
    }


}
