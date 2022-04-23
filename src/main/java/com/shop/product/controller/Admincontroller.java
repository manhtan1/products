package com.shop.product.controller;

import com.shop.product.model.Admin;
import com.shop.product.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Admincontroller {
    @Autowired
    KhachHangService khachHangService;
    private String emailAdmin = "admin@gmail.com";

    private String password = "123456789";
    @GetMapping("/admin")
    public String index() {
        return "homeAdmin";
    }
    @PostMapping("/login")
    public ModelAndView login(Admin model) {
        ModelAndView homeAdmin = new ModelAndView("homeAdmin");
        ModelAndView loginadmin = new ModelAndView("loginAdmin");
        if(model.email.equals(this.emailAdmin) && model.password.equals(this.password)){
            return homeAdmin;
        }
        loginadmin.addObject("ErrorMessage","Tài khoản hoặc mật khẩu không chính xác");
        return loginadmin;
    }
    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView loginadmin = new ModelAndView("loginAdmin");
        return loginadmin;
    }
    @GetMapping("/admin/users")
    public String getAcc(Model model){
        model.addAttribute("users", khachHangService.getAllUser());
        //model.addAttribute("roles", roleService.getAllRole());
        return "users";
    }
}
