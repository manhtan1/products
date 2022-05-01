package com.shop.product.repository;

import com.shop.product.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface KhachhangRespository extends JpaRepository<KhachHang,Long> {
    Optional<KhachHang> findKhachHangByEMAIL(String EMAIL);
    List<KhachHang> findByEMAILAndMAUKHAU(String EMAIL, String MATKHAU);

}
