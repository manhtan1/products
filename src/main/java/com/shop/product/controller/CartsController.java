package com.shop.product.controller;

import com.shop.product.model.*;
import com.shop.product.repository.KhachhangRespository;
import com.shop.product.service.CartService;
import com.shop.product.service.Donhangservice;
import com.shop.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Controller
public class CartsController {
    @Autowired
    CartService cartService;
    @Autowired
    ProductService productService;
    @Autowired
    KhachhangRespository khachhangRespository;
    @Autowired
    Donhangservice donhangservice;
    @Autowired
    HttpSession httpSession;
    @GetMapping("/home/Cart/list")
    public String list(Model model){
        Collection<Carts> carts=cartService.getCarts();
        model.addAttribute("carts",carts);
        model.addAttribute("total",cartService.getAmount());
        model.addAttribute("SLItem",cartService.getCount());
        return "listCart";
    }
    @GetMapping("/home/Cart/add/{id}")
    public String Add(@PathVariable Long id){
       SanPham sanPham= productService.getSanPhamByid(id).get();
        if(sanPham!=null){
            Carts item=new Carts();
            BeanUtils.copyProperties(sanPham,item);
            item.setSL(1L);
            cartService.addproduct(item);
        }
        return "redirect:/home/Cart/list";
    }
    @GetMapping("/home/Cart/remove/{id}")
    public String Remove(@PathVariable Long id){
        cartService.remove(id);
        return "redirect:/home/Cart/list";
    }
    @GetMapping("/home/Cart/update/{id}/{SL}")
    public String updateGioHang(@PathVariable Long id ,@PathVariable Long SL){
        cartService.updateGioHang(id, SL);
        return "redirect:/home/Cart/list";
    }
    @GetMapping("/user/payment")
    public String payment(Model model,KhachHang khachHang){
        model.addAttribute("dathang",new DonDatHang());
        List<KhachHang> khachHangList = khachhangRespository.findKhachHangByEMAIL(khachHang.getEMAIL());
        model.addAttribute("total",cartService.getAmount());
        model.addAttribute("SLItem",cartService.getCount());
        khachHangList= (List<KhachHang>) httpSession.getAttribute("users");
        model.addAttribute("users",khachHangList);
        return "payment";
    }
    @PostMapping("/user/payment")
    public String getpayment(KhachHang khachHang){
        if(httpSession.getAttribute("users")==null){
            return "redirect:/user/login";
        }
        List<KhachHang> khachHangList=(List<KhachHang>) httpSession.getAttribute("users");
        return "redirect:/user/payment";

    }
    @GetMapping("/user/success")
    public String success(){return "success";}
    @PostMapping("/user/dathang")
    public String thanhtoan(Model model,KhachHang khachHang){
        LocalDateTime current = LocalDateTime.now();
        NhanVien nhanVien = null;
        Long generatedLong = new Random().nextLong();
        DonDatHang donDatHang=new DonDatHang();
        List<KhachHang> khachHangList = khachhangRespository.findKhachHangByEMAIL(khachHang.getEMAIL());
        khachHangList= (List<KhachHang>) httpSession.getAttribute("users");
        donDatHang.setId(2L);
        donDatHang.setNGAY_GIAO(current);
        donDatHang.setTONG_TIEN((float) cartService.getAmount());
        donDatHang.getNhanVien(nhanVien.setId(38L));
        donDatHang.setKhachHang((KhachHang) khachHangList);
        donhangservice.updatedonhang(donDatHang);
        return "redirect:/user/success";
    }
}
