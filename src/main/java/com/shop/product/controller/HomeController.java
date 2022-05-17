package com.shop.product.controller;


import antlr.StringUtils;
import com.shop.product.model.Carts;
import com.shop.product.model.SanPham;
import com.shop.product.repository.SanphamRepository;
import com.shop.product.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    /*@GetMapping("/search")
    public String search(Model model, @RequestParam(name = "TEN_SAN_PHAM",required = false) String TEN_SAN_PHAM){
    }*/
}