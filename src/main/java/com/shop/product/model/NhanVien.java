package com.shop.product.model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "nhan_vien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String TEN_NV;
    private String GT;
    private String DIACHI;
    private String EMAIL_NV;
    private String CHUCVU;

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
}
