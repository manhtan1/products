package com.shop.product.service.impl;

import com.shop.product.model.SanPham;
import com.shop.product.repository.ProductRepository;
import com.shop.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
@SessionScope
public class ProductServiceimpl implements ProductService{
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<SanPham> getAllProduct() {
        return productRepository.findAll();
    }//findAll


    private static List<SanPham> list=new ArrayList<>();
    @Override
    public Optional<SanPham> getSanPhamByid(Long id) {
        return productRepository.findById(id);
    }
    @Override
    public SanPham findByID(int id){
        return list.get(id);
    }
    @Override
    public void updateProduct(SanPham product) {
        productRepository.save(product);
    }//add or update (tuy vao pri-key)

    @Override
    public void removeProductById(long id) {
        productRepository.deleteById(id);
    }//delete dua vao pri-key
}
