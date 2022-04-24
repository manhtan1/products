package com.shop.product.controller;


import com.shop.product.model.SanPham;
import com.shop.product.repository.SanphamRepository;
import com.shop.product.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class HomeController {

    @Autowired
    SanphamRepository sanphamRepository;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<SanPham> sanPhamList = sanphamRepository.findAll();
        modelAndView.addObject("sanPhamList", sanPhamList);
        return modelAndView;
    }
    @GetMapping("/user/help")
    public String help(){
        return "help";
    }//page help
}