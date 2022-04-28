package com.shop.product.controller;

import com.shop.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

        @GetMapping("/home/product/{id}")
        public String getproducts(@PathVariable Long id, Model model) {
            model.addAttribute("products",productService.getSanPhamByid(id).get());
            return "descproduct";
        }
}
