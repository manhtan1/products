package com.shop.product.controller;

import com.shop.product.model.SanPham;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class Admincontroller {
    @GetMapping("/admin")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("homeAdmin");
        return modelAndView;
    }
}
