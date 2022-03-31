package com.shop.product.model;
import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "ct_dh")
public class Ct_DH {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "maSanpham" )
    private SanPham sanpham;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "madonhang")
    private DonDatHang donDatHang;
    private Integer SO_LUONG;
    private Float THANH_TIEN;
    private Float DON_GIA;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SanPham getSanpham() {
        return sanpham;
    }

    public void setSanpham(SanPham sanpham) {
        this.sanpham = sanpham;
    }

    public DonDatHang getDonDatHang() {
        return donDatHang;
    }

    public void setDonDatHang(DonDatHang donDatHang) {
        this.donDatHang = donDatHang;
    }

    public Integer getSO_LUONG() {
        return SO_LUONG;
    }

    public void setSO_LUONG(Integer SO_LUONG) {
        this.SO_LUONG = SO_LUONG;
    }

    public Float getTHANH_TIEN() {
        return THANH_TIEN;
    }

    public void setTHANH_TIEN(Float THANH_TIEN) {
        this.THANH_TIEN = THANH_TIEN;
    }

    public Float getDON_GIA() {
        return DON_GIA;
    }

    public void setDON_GIA(Float DON_GIA) {
        this.DON_GIA = DON_GIA;
    }



}