package com.shop.product.repository;

import com.shop.product.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface KhachhangRespository extends JpaRepository<KhachHang,Long> {
    Optional<KhachHang> findKhachHangByEMAIL(String EMAIL);
}
