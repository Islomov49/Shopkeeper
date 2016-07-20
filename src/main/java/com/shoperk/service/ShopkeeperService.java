package com.shoperk.service;

import com.shoperk.entity.Shopkeeper;

import java.util.List;

/**
 * Created by DEV on 19.07.2016.
 */
public interface ShopkeeperService {
    List<Shopkeeper> getAll();
    Shopkeeper getByID(Long id);
    Shopkeeper save(Shopkeeper shopkeeper);
    void remove(Long id);

}
