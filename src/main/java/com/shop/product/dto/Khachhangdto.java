package com.shop.product.dto;

import lombok.Data;

import java.util.Date;
@Data
public class Khachhangdto {
    private Long id;
    private String TEN_KH;
    private String DIA_CHI;
    private Date NGAY_SINH;
    private Integer SDT;
    private String EMAIL;

    private String GIOITINH;
    private String TAIKHOAN;
    private String MAUKHAU;

    public Khachhangdto(Long id, String TEN_KH, String DIA_CHI, Date NGAY_SINH, Integer SDT, String EMAIL, String GIOITINH, String TAIKHOAN, String MAUKHAU) {
        this.id = id;
        this.TEN_KH = TEN_KH;
        this.DIA_CHI = DIA_CHI;
        this.NGAY_SINH = NGAY_SINH;
        this.SDT = SDT;
        this.EMAIL = EMAIL;
        this.GIOITINH = GIOITINH;
        this.TAIKHOAN = TAIKHOAN;
        this.MAUKHAU = MAUKHAU;
    }
    public Khachhangdto(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTEN_KH() {
        return TEN_KH;
    }

    public void setTEN_KH(String TEN_KH) {
        this.TEN_KH = TEN_KH;
    }

    public String getDIA_CHI() {
        return DIA_CHI;
    }

    public void setDIA_CHI(String DIA_CHI) {
        this.DIA_CHI = DIA_CHI;
    }

    public Date getNGAY_SINH() {
        return NGAY_SINH;
    }

    public void setNGAY_SINH(Date NGAY_SINH) {
        this.NGAY_SINH = NGAY_SINH;
    }

    public Integer getSDT() {
        return SDT;
    }

    public void setSDT(Integer SDT) {
        this.SDT = SDT;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getGIOITINH() {
        return GIOITINH;
    }

    public void setGIOITINH(String GIOITINH) {
        this.GIOITINH = GIOITINH;
    }

    public String getTAIKHOAN() {
        return TAIKHOAN;
    }

    public void setTAIKHOAN(String TAIKHOAN) {
        this.TAIKHOAN = TAIKHOAN;
    }

    public String getMAUKHAU() {
        return MAUKHAU;
    }

    public void setMAUKHAU(String MAUKHAU) {
        this.MAUKHAU = MAUKHAU;
    }
}
