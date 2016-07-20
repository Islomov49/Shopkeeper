package com.shoperk.service;

import com.shoperk.entity.Shopkeeper;
import com.shoperk.repository.ShopkeeperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopkeeperServiceImpl implements ShopkeeperService{

    @Autowired
    private ShopkeeperRepository shopkeeperRepository;

    public List<Shopkeeper> getAll() {
        return shopkeeperRepository.findAll();
    }

    public Shopkeeper getByID(Long id) {
        return shopkeeperRepository.findOne(id);
    }

    public Shopkeeper save(Shopkeeper shopkeeper) {
        return shopkeeperRepository.saveAndFlush(shopkeeper);
    }

    public void remove(Long id) {
        shopkeeperRepository.delete(id);
    }
}
