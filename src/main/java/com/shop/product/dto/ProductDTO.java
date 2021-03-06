package com.shop.product.dto;

import java.util.Date;

public class ProductDTO {
    private Long id;
    private String TEN_SAN_PHAM;
    private Float DON_GIA;
    private Integer DON_VI_TINH;
    private String MO_TA;
    private Date NGAY_NHAP_KHO;
    public ProductDTO(){
        super();
    }

    public ProductDTO(Long id, String TEN_SAN_PHAM, Float DON_GIA, Integer DON_VI_TINH, String MO_TA, Date NGAY_NHAP_KHO, Integer SL_ton, String HINHANH) {
        this.id = id;
        this.TEN_SAN_PHAM = TEN_SAN_PHAM;
        this.DON_GIA = DON_GIA;
        this.DON_VI_TINH = DON_VI_TINH;
        this.MO_TA = MO_TA;
        this.NGAY_NHAP_KHO = NGAY_NHAP_KHO;
        this.SL_ton = SL_ton;
        this.HINHANH = HINHANH;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTEN_SAN_PHAM() {
        return TEN_SAN_PHAM;
    }

    public void setTEN_SAN_PHAM(String TEN_SAN_PHAM) {
        this.TEN_SAN_PHAM = TEN_SAN_PHAM;
    }

    public Float getDON_GIA() {
        return DON_GIA;
    }

    public void setDON_GIA(Float DON_GIA) {
        this.DON_GIA = DON_GIA;
    }

    public Integer getDON_VI_TINH() {
        return DON_VI_TINH;
    }

    public void setDON_VI_TINH(Integer DON_VI_TINH) {
        this.DON_VI_TINH = DON_VI_TINH;
    }

    public String getMO_TA() {
        return MO_TA;
    }

    public void setMO_TA(String MO_TA) {
        this.MO_TA = MO_TA;
    }

    public Date getNGAY_NHAP_KHO() {
        return NGAY_NHAP_KHO;
    }

    public void setNGAY_NHAP_KHO(Date NGAY_NHAP_KHO) {
        this.NGAY_NHAP_KHO = NGAY_NHAP_KHO;
    }

    public Integer getSL_ton() {
        return SL_ton;
    }

    public void setSL_ton(Integer SL_ton) {
        this.SL_ton = SL_ton;
    }

    public String getHINHANH() {
        return HINHANH;
    }

    public void setHINHANH(String HINHANH) {
        this.HINHANH = HINHANH;
    }

    private Integer SL_ton;
    private String HINHANH;
}
