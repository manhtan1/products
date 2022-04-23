package com.shop.product.service;

import com.shop.product.model.KhachHang;

import java.util.List;
import java.util.Optional;

public interface KhachHangService {
    List<KhachHang> getAllUser();

    void updateUser(KhachHang user);

    void removeUserById(Long id);

    Optional<KhachHang> getUserById(Long id);

    Optional<KhachHang> getUserByEmail(String email);
}
