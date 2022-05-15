package com.shop.product.repository;

import com.shop.product.model.DonDatHang;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DonHangRepository extends CrudRepository<DonDatHang,Long> {
    List<DonDatHang> findAll();
}
