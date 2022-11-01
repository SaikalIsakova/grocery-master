package com.company.services.impl;

import com.company.db.DbHelper;
import com.company.db.impl.DbHelperImpl;
import com.company.models.Employee;
import com.company.models.Shop;
import com.company.services.EmployeeService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    DbHelper dbHelper=new DbHelperImpl();

    @Override
    public void createEmployee(Employee emp) {


        try {
            PreparedStatement ps=dbHelper.getConnection("insert into tb_employees (name,age,shop_id) values (?,?,?)");
            ps.setString(1,emp.getName());
            ps.setInt(2,emp.getAge());
            ps.setInt(3,emp.getShopId().getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Произошла ошибка при создании Сотрудника");
        }
    }

    @Override
    public List<Employee> empList() {
        try {
            PreparedStatement ps=dbHelper.getConnection("select e.id,e.name,e.age, e.number, s.id as shop_id, s.name as shop_name " +
                    "from tb_employees e " +
                    "INNER join tb_shop s " +
                    "on s.id=e.shop_id ;");
            ResultSet rs= ps.executeQuery();
            List<Employee>list=new ArrayList<>();
            while (rs.next()){
                Employee emp=new Employee();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setAge(rs.getInt("age"));
                Shop shop=new Shop();
                shop.setId(rs.getInt("shop_id"));
                shop.setName(rs.getString("shop_name"));

                emp.setShopId(shop);

                emp.setNumber(rs.getInt("number"));
                list.add(emp);
            }
            return list;
        } catch (SQLException throwables) {
            throw new RuntimeException("Ошибка при выводе списка сотрудников");
        }
    }

    @Override
    public void updateEmployee(int id) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Введите имя...");
        String name=sc.next();
        try {
            PreparedStatement ps = dbHelper.getConnection("Update tb_employees set name=? where id=?");
            ps.setString(1,name);
            ps.setInt(2,id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException("Ошибка при изменении сотрудника");
        }
    }

    @Override
    public void deleteEmployee(int id) {

        try {
            PreparedStatement ps=dbHelper.getConnection("delete from tb_employees where id=?");
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException("Ошибка при удалении сотрудника");
        }

    }

}
