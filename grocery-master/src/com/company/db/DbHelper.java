package com.company.db;

import com.company.models.Employee;
import com.company.models.Shop;

import java.sql.PreparedStatement;
import java.util.List;

public interface DbHelper {

    PreparedStatement getConnection(String sql);



}
