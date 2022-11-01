package com.company.services;

import com.company.models.Shop;

import java.util.List;

public interface ShopService {
    void createShop(Shop shop);
    List<Shop> shopList();
    void updateShop(int id);
    void deleteShop(int id);
}
