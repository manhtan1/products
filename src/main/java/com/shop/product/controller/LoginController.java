package com.shop.product.controller;

import com.shop.product.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @Autowired
    CartService cartService;
    @GetMapping("/login")
    public String login(){
        cartService.clear();
        return "login";
    }//page login
    @GetMapping("/register")
    public String register(){
        cartService.clear();
        return "register";
    }//page login
}
