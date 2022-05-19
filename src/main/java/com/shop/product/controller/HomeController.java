package com.shop.product.controller;


import com.shop.product.model.Carts;
import com.shop.product.model.SanPham;
import com.shop.product.repository.SanphamRepository;
import com.shop.product.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;


@Controller
public class HomeController {
    @Autowired
    CartService cartService;
    @Autowired
    SanphamRepository sanphamRepository;

    @GetMapping("/")
    public ModelAndView index() {
        Collection<Carts> carts=cartService.getCarts();
        ModelAndView modelAndView = new ModelAndView("index");
        List<SanPham> sanPhamList = sanphamRepository.findAll();
        modelAndView.addObject("carts",carts);
        modelAndView.addObject("sanPhamList", sanPhamList);
        modelAndView.addObject("SLItem",cartService.getCount());

        return modelAndView;
    }
    @GetMapping("/user/help")
    public String help(){
        return "help";
    }//page help
    @GetMapping("/search")
    public String search(ModelMap model, @RequestParam(name = "name",required = false) String name){
        List<SanPham> list=null;
        if(StringUtils.hasText(name)){
            list=sanphamRepository.findByName(name);
        }
        else {
            list=sanphamRepository.findAll();
        }
        model.addAttribute("sanPhamList",list);
        return "Search";
    }
}