package com.shop.product.controller;

import com.shop.product.dto.Khachhangdto;
import com.shop.product.model.KhachHang;
import com.shop.product.service.CartService;
import com.shop.product.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    CartService cartService;
    @Autowired
    KhachHangService khachHangService;
    @GetMapping("/user/login")
    public String login(){
        cartService.clear();
        return "login";
    }//page login
    @GetMapping("/user/register")
    public String register(Model model){
        model.addAttribute("users", new Khachhangdto());
        cartService.clear();
        return "register";
    }//page register
    @PostMapping("/user/register")
    public String registerPost(@ModelAttribute Khachhangdto userDTO) {
        KhachHang user = new KhachHang();
        user.setId(userDTO.getId());
        user.setEMAIL(userDTO.getEMAIL());
        user.setTAIKHOAN(userDTO.getTAIKHOAN());
        user.setMAUKHAU(userDTO.getMAUKHAU());
//        user.setMAUKHAU(bCryptPasswordEncoder.encode(userDTO.getMAUKHAU()));
        user.setTEN_KH(userDTO.getTEN_KH());
        user.setSDT(userDTO.getSDT());
        user.setDIA_CHI(userDTO.getDIA_CHI());
        khachHangService.updateUser(user);

        return "redirect:/user/login";
    }//after register success
}
