package com.company.services.impl;

import com.company.db.DbHelper;
import com.company.db.impl.DbHelperImpl;
import com.company.models.Shop;
import com.company.services.ShopService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopServiceImpl implements ShopService {

    DbHelper dbHelper=new DbHelperImpl();

    @Override
    public void createShop(Shop shop) {

        try {
            PreparedStatement ps=dbHelper.getConnection("insert into tb_shop (name) values (?)");
            ps.setString(1,shop.getName());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException("Ошибка при создании магазина");
        }

    }

    @Override
    public List<Shop> shopList() {
        try {

            PreparedStatement ps=dbHelper.getConnection("select * from tb_shop");
            ResultSet rs=ps.executeQuery();
            List<Shop>list=new ArrayList<>();
            while(rs.next()){
                Shop shop=new Shop();
                shop.setId(rs.getInt("id"));
                shop.setName(rs.getString("name"));
                list.add(shop);
            }
            return list;
        } catch (SQLException throwables) {
            throw new RuntimeException("Ошибка при выводе списка магазинов");
        }

    }

    @Override
    public void updateShop(int id) {
        Scanner sc=new Scanner(System.in);
        String name=sc.next();
        try {
            PreparedStatement preparedStatement=dbHelper.getConnection("Update tb_shop set name= ? where id=?");
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException("Ошибка при внесении изменений в таблицу магазин");
        }

    }

    @Override
    public void deleteShop(int id) {
        try {
            PreparedStatement ps=dbHelper.getConnection("delete from tb_shop where id=?");
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException("Ошибка при удалении магазина");
        }
    }
}
