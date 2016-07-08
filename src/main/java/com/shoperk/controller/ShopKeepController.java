package com.shoperk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/keeper")
public class ShopKeepController {

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ResponseBody
    public String getShopKeeper(ModelMap model){

         return "<h1> My </br> Shop Keeper </h1>";
    }

}
