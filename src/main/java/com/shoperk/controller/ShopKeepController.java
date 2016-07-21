package com.shoperk.controller;

import com.shoperk.entity.Shopkeeper;
import com.shoperk.repository.ShopkeeperRepository;
import com.shoperk.service.ShopkeeperService;
import org.hibernate.annotations.common.util.impl.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
public class ShopKeepController {
    @Autowired
    private ShopkeeperService shopkeeperService;

    @RequestMapping(value = "/keepers",method = RequestMethod.GET)
    @ResponseBody
    public List<Shopkeeper> getAllShopKeeper(){

        return shopkeeperService.getAll();
    }
    int t=0;
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public Shopkeeper getTestText(){
        Shopkeeper shopkeeper = new Shopkeeper();
        shopkeeper.setId(t++);
        shopkeeper.setName("Hello Spring");
        shopkeeper.setCreate_ID(new Date());
        return shopkeeper;
    }

    @RequestMapping(value = "/keepers/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Shopkeeper getShopKeeper(@PathVariable("id") long shopId){

        return shopkeeperService.getByID(shopId);
    }


    @RequestMapping(value = "/auth/put",method = RequestMethod.POST)
    @ResponseBody
    public Shopkeeper saveShopKeeprs(@RequestBody Shopkeeper shopkeeper){

        return shopkeeperService.save(shopkeeper);
    }


    @RequestMapping(value = "/ananim/put",method = RequestMethod.POST)
    @ResponseBody
    public Shopkeeper saveAnanimShopKeepers(@RequestBody Shopkeeper shopkeeper){

        return shopkeeperService.save(shopkeeper);
    }


    @RequestMapping(value = "/keepers/{id}",method = RequestMethod.POST)
    @ResponseBody
    public void deleteShopkeeper(@PathVariable("id") long shopId){

        shopkeeperService.remove(shopId);
    }


}
