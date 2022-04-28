package com.shop.product.service;

import com.shop.product.model.SanPham;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ProductService {
    List<SanPham> getAllProduct()//findAll
    ;

    Optional<SanPham> getSanPhamByid(Long id);

    SanPham findByID(int id);

    void updateProduct(SanPham product)//add or update (tuy vao pri-key)
    ;

    void removeProductById(long id)//delete dua vao pri-key
    ;
}
