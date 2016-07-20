package com.shoperk.repository;

import com.shoperk.entity.Shopkeeper;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by DEV on 19.07.2016.
 */
public interface ShopkeeperRepository extends JpaRepository<Shopkeeper,Long> {
}
