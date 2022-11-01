package com.company.db.impl;

import com.company.db.DbHelper;
import com.company.models.Employee;
import com.company.models.Shop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DbHelperImpl implements DbHelper {

    @Override
    public PreparedStatement getConnection(String sql){
        try {
            Connection connection= DriverManager.getConnection("jdbc:sqlite:C:\\DataBase\\shopDBS.db");
            return connection.prepareStatement(sql);

        } catch (SQLException e) {
            throw new RuntimeException("Произошла ошибка при подключении к базе данных");
        }
    }
}
