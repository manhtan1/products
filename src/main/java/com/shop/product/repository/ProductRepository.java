package com.shop.product.repository;

import com.shop.product.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<SanPham, Long> {
    List<SanPham> findAllByid(Long id);
    Optional<SanPham> getSanPhamByid(Long id);

}
