package com.shop.product.service;

import com.shop.product.model.Carts;

import java.util.Collection;

public interface CartService {
    void addproduct(Carts item);

    Collection<Carts> getCarts();

    void clear();

    void update(Long id, Integer SL);
}
