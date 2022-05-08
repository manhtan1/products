package com.shop.product.model;

import javax.persistence.*;
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
    private int SO_LUONG;


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

    public int getSO_LUONG() {
        return SO_LUONG;
    }

    public void setSO_LUONG(int SO_LUONG) {
        this.SO_LUONG = SO_LUONG;
    }


}