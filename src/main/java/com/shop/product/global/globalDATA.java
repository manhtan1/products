package com.shop.product.global;

import com.shop.product.model.SanPham;

import java.util.ArrayList;
import java.util.List;

public class globalDATA {
        //tao bien toan cuc
        public static List<SanPham> cart;

        static {
            cart = new ArrayList<>();
        }
}
