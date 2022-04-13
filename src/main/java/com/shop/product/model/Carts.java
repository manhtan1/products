package com.shop.product.model;

import javax.persistence.*;


@Entity
@Table(name = "san_pham")
public class Carts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String TEN_SAN_PHAM;
    private Float DON_GIA;
    private String HINHANH;
    private Integer SL;
    private Float Total;


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

    public String getHINHANH() {
        return HINHANH;
    }

    public void setHINHANH(String HINHANH) {
        this.HINHANH = HINHANH;
    }

    public Integer getSL() {
        return SL;
    }

    public void setSL(Integer SL) {
        this.SL = SL;
    }

    public Float getTotal() {
        return SL*DON_GIA;
    }

    public void setTotal(Float total) {
        Total = total;
    }

}
