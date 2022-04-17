package com.shop.product.service.impl;

import com.shop.product.model.SanPham;
import com.shop.product.repository.ProductRepository;
import com.shop.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class ProductServiceimpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    private static List<SanPham> list=new ArrayList<>();
    @Override
    public Optional<SanPham> getSanPhamByid(Long id) {
        return productRepository.findById(id);
    }
    @Override
    public SanPham findByID(int id){
        return list.get(id);
    }
}
