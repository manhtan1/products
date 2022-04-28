package com.shop.product.service.impl;

import com.shop.product.model.NhanVien;
import com.shop.product.repository.StaffResponsitory;
import com.shop.product.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class StaffServiceimpl implements StaffService {
    @Autowired
    StaffResponsitory staffResponsitory;
    @Override
    public List<NhanVien> getAllStaff() {
        return staffResponsitory.findAll();
    }
    @Override
    public void updatestaff(NhanVien staff) {
        staffResponsitory.save(staff);
    }
    @Override
    public void removestaffById(Long id) {
        staffResponsitory.deleteById(id);
    }
    @Override
    public Optional<NhanVien> getstaffById(Long id) {
        return staffResponsitory.findById(id);
    }
}
