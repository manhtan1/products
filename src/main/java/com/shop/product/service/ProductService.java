package com.shop.product.service;

import com.shop.product.model.SanPham;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service

public interface ProductService {
    Optional<SanPham> getSanPhamByid(Long id);

    SanPham findByid(int id);
}
