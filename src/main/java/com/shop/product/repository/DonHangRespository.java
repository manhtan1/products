package com.shop.product.repository;

import com.shop.product.model.DonDatHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonHangRespository extends JpaRepository<DonDatHang, Long> {
}
