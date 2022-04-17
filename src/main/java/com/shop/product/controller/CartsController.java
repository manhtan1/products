package com.shop.product.controller;

import com.shop.product.model.Carts;
import com.shop.product.model.SanPham;
import com.shop.product.repository.ProductRepository;
import com.shop.product.service.CartService;
import com.shop.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Optional;

@Controller
public class CartsController {
    @Autowired
    CartService cartService;
    @Autowired
    ProductService productService;
    @GetMapping("/home/Cart/list")
    public String list(Model model){
        Collection<Carts> carts=cartService.getCarts();
        model.addAttribute("carts",carts);
        return "listCart";
    }
    @GetMapping("/home/Cart/add/{id}")
    public String Add(@PathVariable Long id){
       SanPham sanPham= productService.getSanPhamByid(id).get();
        if(sanPham!=null){
            Carts item=new Carts();
            BeanUtils.copyProperties(sanPham,item);
            item.setSL(1);
            cartService.addproduct(item);
        }
        return "redirect:/home/Cart/list";
    }
    @GetMapping("/home/Cart/remove/{id}")
    public String Remove(@PathVariable Long id){
        cartService.remove(id);
        return "redirect:/home/Cart/list";
    }
    @GetMapping("/home/Cart/update")
    public String Update(@RequestParam Long id,@RequestParam Integer SL){
        cartService.update(id, SL);
        return "redirect:/home/Cart/list";
    }
}
