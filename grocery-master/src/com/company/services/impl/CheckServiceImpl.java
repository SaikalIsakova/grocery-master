package com.company.services.impl;

import com.company.db.DbHelper;
import com.company.db.impl.DbHelperImpl;
import com.company.models.Check;
import com.company.models.Employee;
import com.company.services.CheckService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CheckServiceImpl implements CheckService {

    DbHelper dbHelper=new DbHelperImpl();
    @Override
    public void createCheck(Check check) {

        PreparedStatement ps= dbHelper.getConnection("insert into tb_checks" +
                " (employee_id,add_date,totalSum,fd)values(?,?,?,?)");
        try {
            ps.setInt(1,check.getEmployee_id().getId());
            ps.setString(2,check.getAdd_date());
            ps.setDouble(3,check.getTotalSum());
            ps.setInt(4,check.getFd());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException("Ошибка при сохранении чека");
        }
    }

    @Override
    public List<Check> checkList() {
        try{
        PreparedStatement ps= dbHelper.getConnection("select c.id,c.totalSum,c.fd,c.employee_id,e.name \n" +
                "from tb_checks c inner join tb_employees e on c.employee_id =e.id" );
        ResultSet rs= ps.executeQuery();
        List<Check>checks=new ArrayList<>();
        while (rs.next()){
           Check check=new Check();
           check.setId(rs.getInt("id"));
           check.setTotalSum(rs.getDouble("totalSum"));
           check.setFd(rs.getInt("fd"));
          Employee employee=new Employee();
          employee.setId(rs.getInt("id"));
          employee.setName(rs.getString("name"));
          check.setEmployee_id(employee);
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
            PreparedStatement ps=dbHelper.getConnection("select c.id,c.totalSum,c.fd,c.employee_id,e.name \n" +
                    "from tb_checks c inner join tb_employees e on c.employee_id =e.id where c.id=?");
            ps.setLong(1,id);
            ResultSet rs=ps.executeQuery();
            Check check=new Check();
            while(rs.next()){
                check.setId(rs.getLong("id"));
                check.setTotalSum(rs.getDouble("totalSum"));
                check.setFd(rs.getInt("fd"));
                Employee employee=new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                check.setEmployee_id(employee);

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
