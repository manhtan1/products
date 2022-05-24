package com.shop.product.repository;
import com.shop.product.model.SanPham;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanphamRepository extends CrudRepository<SanPham, Long> {
    List<SanPham> findAll();
    List<SanPham> findByname(String name);
}
