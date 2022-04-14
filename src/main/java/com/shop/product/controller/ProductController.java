package com.shop.product.controller;

import com.shop.product.model.SanPham;
import com.shop.product.repository.ProductRepository;
import com.shop.product.repository.SanphamRepository;
import com.shop.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
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
