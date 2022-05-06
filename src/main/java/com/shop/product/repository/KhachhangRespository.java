package com.shop.product.repository;

import com.shop.product.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KhachhangRespository extends JpaRepository<KhachHang,Long> {
    List<KhachHang> findKhachHangByEMAIL(String EMAIL);
    List<KhachHang> findByEMAILAndMAUKHAU(String EMAIL, String MAUKHAU);

}
