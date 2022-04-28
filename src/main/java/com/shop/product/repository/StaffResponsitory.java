package com.shop.product.repository;

import com.shop.product.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StaffResponsitory extends JpaRepository<NhanVien, Long> {
    List<NhanVien> findAllByid(Long id);
}
