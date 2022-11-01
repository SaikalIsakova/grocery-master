package com.company.services;

import com.company.models.Product;
import com.company.models.Shop;

import java.util.List;

public interface ProductService {
    void create(Product shop);
    List<Product> getList();
    Product findById(Long id);
    void updateShop(Long id);
    void deleteShop(Long id);
}
