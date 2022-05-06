package com.shop.product.service;

import com.shop.product.model.DonDatHang;
import org.springframework.stereotype.Service;

@Service
public interface Donhangservice {
    void updatedonhang(DonDatHang datHang);
}
