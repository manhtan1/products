package com.shop.product.controller;

import com.shop.product.repository.ProductRepository;
import com.shop.product.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

@Controller
public class CartsController {
    @Autowired
    CartService cartService;
    @Autowired
    ProductRepository productRepository;

}
