package com.company.services.impl;

import com.company.db.DbHelper;
import com.company.db.impl.DbHelperImpl;
import com.company.models.Check;
import com.company.models.Employee;
import com.company.models.Product;
import com.company.models.Shop;
import com.company.services.CheckService;
import com.company.services.ProductService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckServiceImpl implements CheckService {

    DbHelper dbHelper=new DbHelperImpl();
    @Override
    public void createCheck(Check check) {

        PreparedStatement ps= dbHelper.getConnection("insert into tb_checks" +
                " (id,employee_id,num_of_check,totalSum,fd)values(?,?,?,?,?)");
        try {
            ps.setLong(1,check.getId());
            ps.setInt(2,check.getEmployee().getId());
            ps.setInt(3,check.getNum_of_check());
            ps.setDouble(4,check.getTotalSum());
            ps.setInt(5,check.getFd());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException("Ошибка при сохранении чека");
        }
    }

    @Override
    public List<Check> checkList() {
        try{
        PreparedStatement ps= dbHelper.getConnection("select c.id,c.num_of_check,c.totalSum,c.fd,c.employee_id,e.name \n" +
                "from tb_checks c inner join tb_employees e on c.employee_id =e.id" );
        ResultSet rs= ps.executeQuery();
        List<Check>checks=new ArrayList<>();
        while (rs.next()){
           Check check=new Check();
           check.setId(rs.getInt("id"));
           check.setNum_of_check(rs.getInt("num_of_check"));
           check.setTotalSum(rs.getDouble("totalSum"));
           check.setFd(rs.getInt("fd"));
          Employee employee=new Employee();
          employee.setId(rs.getInt("id"));
          employee.setName(rs.getString("name"));
          check.setEmployee(employee);
          checks.add(check);

        }
        return checks;
    } catch (SQLException throwables) {
        throw new RuntimeException("Ошибка при выводе списка чека");
    }

    }

    @Override
    public Check findById(long id) {

        try {
            PreparedStatement ps=dbHelper.getConnection("select c.id,c.num_of_check,c.totalSum,c.fd,c.employee_id,e.name \n" +
                    "from tb_checks c inner join tb_employees e on c.employee_id =e.id where c.id=?");
            ps.setLong(1,id);
            ResultSet rs=ps.executeQuery();
            Check check=new Check();
            while(rs.next()){
                check.setId(rs.getLong("id"));
                check.setNum_of_check(rs.getInt("num_of_check"));
                check.setTotalSum(rs.getDouble("totalSum"));
                check.setFd(rs.getInt("fd"));
                Employee employee=new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                check.setEmployee(employee);

            }
            return check;
        } catch (SQLException throwables) {
            throw new RuntimeException("Ошибка при поиске чека по id");
        }
    }

    @Override
    public void updateCheck(long id) {

    }

    @Override
    public void deleteCheck(long id) {
        PreparedStatement ps= dbHelper.getConnection("Delete from tb_checks where id=?");
        try {
            ps.setLong(1,id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException("Ошибка при удалении чека");
        }

    }


}
