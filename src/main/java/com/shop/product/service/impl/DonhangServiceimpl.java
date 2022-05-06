package com.shop.product.service.impl;

import com.shop.product.model.DonDatHang;
import com.shop.product.repository.DonHangRespository;
import com.shop.product.service.Donhangservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DonhangServiceimpl implements Donhangservice {
    @Autowired
    DonHangRespository donHangRespository;
    @Override
    public void updatedonhang(DonDatHang datHang) {
        donHangRespository.save(datHang);
    }

}
