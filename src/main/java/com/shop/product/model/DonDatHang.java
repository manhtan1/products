package com.shop.product.model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "don_dat_hang")
public class DonDatHang {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date NGAY_LAP_DON;
    private Date NGAY_GIAO;

    public double getTONG_TIEN() {
        return TONG_TIEN;
    }

    public void setTONG_TIEN(double TONG_TIEN) {
        this.TONG_TIEN = TONG_TIEN;
    }

    private double TONG_TIEN;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "maKhachHang" )
    private KhachHang khachHang;
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

    public KhachHang getKhachHang(Long i) {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

}
