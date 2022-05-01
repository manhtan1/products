package com.shop.product.controller;

import com.shop.product.dto.Khachhangdto;
import com.shop.product.model.KhachHang;
import com.shop.product.repository.KhachhangRespository;
import com.shop.product.service.CartService;
import com.shop.product.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    CartService cartService;
    @Autowired
    KhachHangService khachHangService;
    @Autowired
    KhachhangRespository khachhangRespository;
    @Autowired
    HttpSession httpSession;
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
    }

    @PostMapping("/user/register")
    public ModelAndView registerPost(KhachHang khachHang,@ModelAttribute Khachhangdto userDTO) {
        KhachHang user = new KhachHang();
//        Optional<KhachHang> users1=khachHangService.getUserByEMAIL(khachHang.getEMAIL());

        ModelAndView login=new ModelAndView("redirect:/user/login");
        ModelAndView register=new ModelAndView("redirect:/user/register");
//        if (users1!=null){
//            register.addObject("ErrorMessage","Email đã bị trùng");
//            return register;
//        }
        user.setId(userDTO.getId());
        user.setEMAIL(userDTO.getEMAIL());
        user.setMAUKHAU(userDTO.getMAUKHAU());
        user.setTEN_KH(userDTO.getTEN_KH());
        user.setSDT(userDTO.getSDT());
        user.setDIA_CHI(userDTO.getDIA_CHI());
//        if(userDTO.getEMAIL().equals(users1)){
//            register.addObject("ErrorMessage","Email đã bị trùng");
//            return register;
//        }
        khachHangService.updateUser(user);
        return login;
    }//after register success
    @PostMapping("/user/login")
    public ModelAndView login(KhachHang khachHang) {
        List<KhachHang> khachHangList = khachhangRespository.findByEMAILAndMAUKHAU(khachHang.getEMAIL(), khachHang.getMAUKHAU());
        ModelAndView loginView = new ModelAndView("login");
        ModelAndView homeIndex =  new ModelAndView("redirect:/");
        if (khachHangList.size() > 0) {
            return homeIndex;
        }
        loginView.addObject("ErrorMessage","Tên đăng nhập hoặc mật khẩu không đúng");
        return loginView;
    }
}
