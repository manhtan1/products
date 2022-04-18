package com.shop.product.service;

import com.shop.product.model.Carts;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public interface CartService {
    void addproduct(Carts item);

    Collection<Carts> getCarts();

    void clear();

    void updateGioHang(Long id, Long SL);

    void remove(Long id);
}
