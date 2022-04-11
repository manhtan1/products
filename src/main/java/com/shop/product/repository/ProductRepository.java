package com.shop.product.repository;

import com.shop.product.model.SanPham;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<SanPham, Long> {
    Optional<SanPham> getSanPhamByid(Long id);
    Iterable<SanPham> findByid(Long id);
}
