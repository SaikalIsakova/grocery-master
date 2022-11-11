package com.company.services.impl;

import com.company.db.DbHelper;
import com.company.db.impl.DbHelperImpl;
import com.company.models.Check;
import com.company.models.CheckProduct;
import com.company.models.Employee;
import com.company.models.Product;
import com.company.services.CheckProductService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CheckProductServiceImpl implements CheckProductService {

    DbHelper dbHelper=new DbHelperImpl();

    @Override
    public void save(CheckProduct checkProduct) {

        PreparedStatement ps= dbHelper.getConnection("insert into tb_checks_products" +
                " (product_id,check_id,count,cost)values(?,?,?,?)");
        try {
            ps.setLong(1,checkProduct.getProduct().getId());
            ps.setLong(2,checkProduct.getCheck().getId());
            ps.setInt(3,checkProduct.getCount());
            ps.setDouble(4,checkProduct.getCost());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка при сохранении чек-продукта");
        }
    }

    @Override
    public List<CheckProduct> checkProductList() {
        try{
        PreparedStatement ps= dbHelper.getConnection("select cp.id,cp.product_id,cp.check_id,cp.count" +
                "cp.cost,p.name from tb_checks_products cp inner join tb_products p on cp.product_id=p.id");
            ResultSet rs= ps.executeQuery();
            List<CheckProduct>checks=new ArrayList<>();
            while (rs.next()){
                CheckProduct checkProduct=new CheckProduct();
                checkProduct.setId(rs.getLong("id"));
                Check check=new Check();
                check.setId(rs.getLong("id"));
                checkProduct.setCheck(check);
                Product product=new Product();
                product.setId(rs.getLong("id"));
                checkProduct.setProduct(product);
                checkProduct.setCount(rs.getInt("count"));
                checkProduct.setCost(rs.getDouble("cost"));
                checks.add(checkProduct);

            }
            return checks;
        } catch (SQLException throwables) {
            throw new RuntimeException("Ошибка при выводе списка чек-продукт");
        }

    }

    @Override
    public CheckProduct findById(long id) {

        try {
            PreparedStatement ps=dbHelper.getConnection("select cp.id,cp.product_id,cp.check_id,cp.count,cp.cost,p.name " +
                    "from tb_checks_products cp inner join tb_products p\n" +
                    "on cp.product_id=p.id where cp.id=?");
            ps.setLong(1,id);
            ResultSet rs=ps.executeQuery();
            CheckProduct checkProduct=new CheckProduct();
            while(rs.next()){
                checkProduct.setId(rs.getLong("id"));
                Product product=new Product();
                product.setId(rs.getLong("id"));
                checkProduct.setProduct(product);
                Check check=new Check();
                check.setId(rs.getLong("id"));
                checkProduct.setCheck(check);
                checkProduct.setCount(rs.getInt("count"));
                checkProduct.setCost(rs.getDouble("cost"));

            }
            return checkProduct;
        } catch (SQLException throwables) {
            throw new RuntimeException("Ошибка при выводе по id чек-продукта");
        }
    }

    @Override
    public void updateCheckProduct(long id) {

    }

    @Override
    public void deleteCheckProduct(long id) {
        PreparedStatement ps= dbHelper.getConnection("Delete from tb_checks_products where id=?");
        try {
            ps.setLong(1,id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException("Ошибка при удалении чек-продукта");
        }

    }
}
