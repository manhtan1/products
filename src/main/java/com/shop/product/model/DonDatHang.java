package com.shop.product.model;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Table(name = "don_dat_hang")
public class DonDatHang {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date NGAY_LAP_DON;

    private String GHI_CHU;

    private LocalDateTime NGAY_GIAO;

    public Float getTONG_TIEN() {
        return TONG_TIEN;
    }

    public void setTONG_TIEN(Float TONG_TIEN) {
        this.TONG_TIEN = TONG_TIEN;
    }

    private Float TONG_TIEN;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "maKhachHang" )
    private KhachHang khachHang;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "maNhanVien")
    private NhanVien nhanVien;

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

    public String getGHI_CHU() {
        return GHI_CHU;
    }

    public void setGHI_CHU(String GHI_CHU) {
        this.GHI_CHU = GHI_CHU;
    }

    public LocalDateTime getNGAY_GIAO() {
        return NGAY_GIAO;
    }

    public void setNGAY_GIAO(LocalDateTime NGAY_GIAO) {
        this.NGAY_GIAO = NGAY_GIAO;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public NhanVien getNhanVien(int i) {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }
}
