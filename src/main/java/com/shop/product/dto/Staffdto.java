package com.shop.product.dto;

public class Staffdto {
    private Long id;
    private String TEN_NV;
    private String GT;
    private String DIACHI;
    private String EMAIL_NV;
    private String CHUCVU;
    private String TK;
    private String MK;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTEN_NV() {
        return TEN_NV;
    }

    public void setTEN_NV(String TEN_NV) {
        this.TEN_NV = TEN_NV;
    }

    public String getGT() {
        return GT;
    }

    public void setGT(String GT) {
        this.GT = GT;
    }

    public String getDIACHI() {
        return DIACHI;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }

    public String getEMAIL_NV() {
        return EMAIL_NV;
    }

    public void setEMAIL_NV(String EMAIL_NV) {
        this.EMAIL_NV = EMAIL_NV;
    }

    public String getCHUCVU() {
        return CHUCVU;
    }

    public void setCHUCVU(String CHUCVU) {
        this.CHUCVU = CHUCVU;
    }

    public String getTK() {
        return TK;
    }

    public void setTK(String TK) {
        this.TK = TK;
    }

    public String getMK() {
        return MK;
    }

    public void setMK(String MK) {
        this.MK = MK;
    }

    public Staffdto(Long id, String TEN_NV, String GT, String DIACHI, String EMAIL_NV, String CHUCVU, String TK, String MK) {
        this.id = id;
        this.TEN_NV = TEN_NV;
        this.GT = GT;
        this.DIACHI = DIACHI;
        this.EMAIL_NV = EMAIL_NV;
        this.CHUCVU = CHUCVU;
        this.TK = TK;
        this.MK = MK;
    }
    public Staffdto(){
        super();
    }

}
