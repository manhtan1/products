package com.shop.product.dto;

import java.util.Date;

public class DonHangDto {
    private Long id;
    private Date NGAY_LAP_DON;
    private Date NGAY_GIAO;
    private double TONG_TIEN;

    public DonHangDto(Long id, Date NGAY_LAP_DON, Date NGAY_GIAO, double TONG_TIEN) {
        this.id = id;
        this.NGAY_LAP_DON = NGAY_LAP_DON;
        this.NGAY_GIAO = NGAY_GIAO;
        this.TONG_TIEN = TONG_TIEN;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getNGAY_LAP_DON() {
        return NGAY_LAP_DON;
    }

    public void setNGAY_LAP_DON(Date NGAY_LAP_DON) {
        this.NGAY_LAP_DON = NGAY_LAP_DON;
    }

    public Date getNGAY_GIAO() {
        return NGAY_GIAO;
    }

    public void setNGAY_GIAO(Date NGAY_GIAO) {
        this.NGAY_GIAO = NGAY_GIAO;
    }

    public double getTONG_TIEN() {
        return TONG_TIEN;
    }

    public void setTONG_TIEN(double TONG_TIEN) {
        this.TONG_TIEN = TONG_TIEN;
    }
}
