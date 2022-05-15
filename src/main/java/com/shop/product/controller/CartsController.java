package com.shop.product.controller;

import com.shop.product.model.*;
import com.shop.product.repository.ChitietdonhangRespository;
import com.shop.product.repository.DonHangRepository;
import com.shop.product.repository.KhachhangRespository;
import com.shop.product.service.CartService;
import com.shop.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Controller
public class CartsController {
    @Autowired
    ChitietdonhangRespository chitietdonhangRespository;
    @Autowired
    CartService cartService;
    @Autowired
    ProductService productService;
    @Autowired
    KhachhangRespository khachhangRespository;
    @Autowired
    DonHangRepository donHangRespository;
    @Autowired
    HttpSession httpSession;
    @GetMapping("/home/Cart/list")
    public String list(Model model){
        Collection<Carts> carts=cartService.getCarts();
//        httpSession.setAttribute("carts",cartService.getCarts());

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
        KhachHang ListKH=(KhachHang) httpSession.getAttribute("KhachHangDangNhap");
        model.addAttribute("total",cartService.getAmount());
        model.addAttribute("SLItem",cartService.getCount());
        model.addAttribute("users",ListKH);
        return "payment";
    }
    @PostMapping("/user/payment")
    public String getpayment(KhachHang khachHang){
        if(httpSession.getAttribute("KhachHangDangNhap")==null){
            return "redirect:/user/login";
        }
        return "redirect:/user/payment";

    }
    private DonDatHang storeDonHang(KhachHang khachHang, String NGAY_GIAO) throws ParseException {
        DonDatHang donHang = new DonDatHang();
        double tolal=cartService.getAmount();
        donHang.setKhachHang(khachHang);
        Date date=new SimpleDateFormat("yyyy-MM-dd").parse(NGAY_GIAO);
        donHang.setNGAY_GIAO(date);
        donHang.setNGAY_LAP_DON(new Date());
        donHang.setTONG_TIEN(tolal);
        donHangRespository.save(donHang);
        return donHang;
    }

    @PostMapping("/user/dathang")
    public String thanhtoan(Model model, String NGAY_GIAO) throws ParseException{
        KhachHang ListKH=(KhachHang) httpSession.getAttribute("KhachHangDangNhap");
        DonDatHang donhang=storeDonHang(ListKH,NGAY_GIAO);
        Collection<Carts> carts=cartService.getCarts();
//        for (Carts gioHangItem: carts ) {
//            int sl=cartService.getCount();
//            Ct_DH ct_dh=new Ct_DH();
//            ct_dh.setDonDatHang(donhang);
//            ct_dh.setSO_LUONG(Math.toIntExact(gioHangItem.getSL()));
////            ct_dh.setSO_LUONG(1);
//            ct_dh.setSanpham(gioHangItem.getSanPham());
////            chitietdonhangRespository.save(ct_dh);
//        }
            cartService.clear();
            return "redirect:/user/payment";

    }
}
