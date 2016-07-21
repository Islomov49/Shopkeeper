package com.shoperk.controller;

import com.shoperk.entity.Shopkeeper;
import com.shoperk.entity.User;
import com.shoperk.repository.ShopkeeperRepository;
import com.shoperk.service.ShopkeeperService;
import org.hibernate.annotations.common.util.impl.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ResponseBody
    public String list(Authentication authentication){
        String not_auth="You are not authentication please go to /login page! " +
                " |||  For user Nasimxon " +
                "    Login :   Nasim ,   Password : 123456 " +
                " |||  For user Bakhrom " +
                "    Login : Achilov ,   Password : 123456";
        User user=authentication==null?
                null: (User) authentication.getPrincipal();
        if(user==null){
            return not_auth; }

        else
        return "Welcome " +user.getUserName()+" !";

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
