package com.shop.product.service;

import com.shop.product.model.KhachHang;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public interface KhachHangService {
    List<KhachHang> getAllUser();

    void updateUser(KhachHang user);

    void removeUserById(Long id);

    Optional<KhachHang> getUserById(Long id);

    List<KhachHang> getUserByEMAIL(String email);

}
