package com.shop.product.service.impl;

import com.shop.product.model.KhachHang;
import com.shop.product.repository.KhachhangRespository;
import com.shop.product.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class KhachHangServiceimpl implements KhachHangService {
    @Autowired
    KhachhangRespository khachhangRespository;
    @Override
    public List<KhachHang> getAllUser() {
        return khachhangRespository.findAll();
    }
    @Override
    public void updateUser(KhachHang user) {
        khachhangRespository.save(user);
    }
    @Override
    public void removeUserById(Long id) {
        khachhangRespository.deleteById(id);
    }
    @Override
    public Optional<KhachHang> getUserById(Long id) {
        return khachhangRespository.findById(id);
    }
    @Override
    public Optional<KhachHang> getUserByEmail(String email) {
        return khachhangRespository.findKhachHangByEMAIL(email);
    }

}
