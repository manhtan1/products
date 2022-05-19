package com.shop.product.controller;

import com.shop.product.dto.Khachhangdto;
import com.shop.product.dto.ProductDTO;
import com.shop.product.dto.Staffdto;
import com.shop.product.model.Admin;
import com.shop.product.model.KhachHang;
import com.shop.product.model.NhanVien;
import com.shop.product.model.SanPham;
import com.shop.product.repository.DonHangRepository;
import com.shop.product.service.KhachHangService;
import com.shop.product.service.ProductService;
import com.shop.product.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
public class AdminController {
    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/img";

    @Autowired
    DonHangRepository donHangRepository;
    @Autowired
    ProductService productService;
    @Autowired
    KhachHangService khachHangService;
    @Autowired
    StaffService staffService;
    private String emailAdmin = "admin@gmail.com";
    private String password = "123456789";


    //user
    @GetMapping("/admin")
    public String index() {
        return "homeAdmin";
    }
    @PostMapping("/login")
    public ModelAndView login(Admin model) {
        ModelAndView homeAdmin = new ModelAndView("homeAdmin");
        ModelAndView loginadmin = new ModelAndView("loginAdmin");
        if(model.email.equals(this.emailAdmin) && model.password.equals(this.password)){
            return homeAdmin;
        }
        loginadmin.addObject("ErrorMessage","Tài khoản hoặc mật khẩu không chính xác");
        return loginadmin;
    }
    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView loginadmin = new ModelAndView("loginAdmin");
        return loginadmin;
    }
    @GetMapping("/admin/users")
    public String getAcc(Model model){
        model.addAttribute("users", khachHangService.getAllUser());
        return "users";
    }
    @GetMapping("/admin/users/add")
    public String getUserAdd(Model model){
        model.addAttribute("userDTO", new Khachhangdto());
        return "usersAdd";
    }
    @PostMapping("/admin/users/add")
    public String postUserAdd(@ModelAttribute("userDTO") Khachhangdto userDTO) {
        //convert dto > entity
        KhachHang user = new KhachHang();
        user.setId(userDTO.getId());
        user.setEMAIL(userDTO.getEMAIL());
        user.setMAUKHAU(userDTO.getMAUKHAU());
//        user.setMAUKHAU(bCryptPasswordEncoder.encode(userDTO.getMAUKHAU()));
        user.setTEN_KH(userDTO.getTEN_KH());
        user.setSDT(userDTO.getSDT());
        user.setDIA_CHI(userDTO.getDIA_CHI());
        khachHangService.updateUser(user);
        return "redirect:/admin/users";
    }
    @GetMapping("/admin/users/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        khachHangService.removeUserById(id);
        return "redirect:/admin/users";
    }//delete 1 user

    @GetMapping("/admin/users/update/{id}")
    public String updateUser(@PathVariable Long id, Model model){
        Optional<KhachHang> opUser = khachHangService.getUserById(id);
        if (opUser.isPresent()){
            KhachHang user = opUser.get();
            //convert entity > dto
            Khachhangdto userDTO = new Khachhangdto();
            userDTO.setId(user.getId());
            userDTO.setEMAIL(user.getEMAIL());
            userDTO.setMAUKHAU("");
            userDTO.setMAUKHAU(user.getMAUKHAU());
//            userDTO.setMAUKHAU(bCryptPasswordEncoder.encode(user.getMAUKHAU()));
            userDTO.setTEN_KH(user.getTEN_KH());
            userDTO.setSDT(user.getSDT());
            userDTO.setDIA_CHI(user.getDIA_CHI());
            model.addAttribute("userDTO", userDTO);
            return "usersAdd";
        }else {
            return "redirect:/admin/users";
        }

    }
    //staff
    @GetMapping("/admin/staffs")
    public String getAccstaff(Model model){
        model.addAttribute("staffs", staffService.getAllStaff());
        return "staff";
    }
    @GetMapping("/admin/staffs/add")
    public String getstaffAdd(Model model){
        model.addAttribute("staffDTO", new Staffdto());
        return "staffAdd";
    }
    @PostMapping("/admin/staffs/add")
    public String poststaffAdd(@ModelAttribute Staffdto staffdto) {
        //convert dto > entity
        NhanVien staff = new NhanVien();
        staff.setId(staffdto.getId());
        staff.setTEN_NV(staffdto.getTEN_NV());
        staff.setEMAIL_NV(staffdto.getEMAIL_NV());
        staff.setCHUCVU(staffdto.getCHUCVU());
        staffService.updatestaff(staff);
        return "redirect:/admin/staffs";
    }
    @GetMapping("/admin/staffs/delete/{id}")
    public String deletestaff(@PathVariable Long id){
        staffService.removestaffById(id);
        return "redirect:/admin/staffs";
    }//delete 1 staff

    @GetMapping("/admin/staffs/update/{id}")
    public String updatestaff(@PathVariable Long id, Model model){
        Optional<NhanVien> opStaff = staffService.getstaffById(id);
        if (opStaff.isPresent()){
            NhanVien staff = opStaff.get();
            //convert entity > dto
            Staffdto staffdto = new Staffdto();
            staffdto.setId(staff.getId());
            staffdto.setTEN_NV(staff.getTEN_NV());
            staffdto.setCHUCVU(staff.getCHUCVU());
            staffdto.setDIACHI(staff.getDIACHI());
            model.addAttribute("staffDTO", staffdto);
            return "staffAdd";
        }else {
            return "404";
        }

    }

    //CRUD PRODUCTS
    @GetMapping("/admin/products")
    public String getPro(Model model){
        model.addAttribute("products", productService.getAllProduct());
        return "products";
    }//view all products

    @GetMapping("/admin/products/add")
    public String getProAdd(Model model){
        model.addAttribute("productDTO", new ProductDTO());
        return "productsAdd";
    }// form add new product
    @PostMapping("/admin/products/add")
    public String postProAdd(@ModelAttribute("productDTO") ProductDTO productDTO,
                             @RequestParam("productImage") MultipartFile fileProductImage,
                             @RequestParam("imgName") String imgName) throws IOException {
        //convert dto > entity
        SanPham product = new SanPham();
        product.setId(productDTO.getId());
        product.setTEN_SAN_PHAM(productDTO.getTEN_SAN_PHAM());
        product.setDON_GIA(productDTO.getDON_GIA());
        product.setMO_TA(productDTO.getMO_TA());
        product.setSL_ton(productDTO.getSL_ton());
        String imageUUID;
        if(!fileProductImage.isEmpty()){
            imageUUID = fileProductImage.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
            Files.write(fileNameAndPath, fileProductImage.getBytes());
        }else {
            imageUUID = imgName;
        }//save image
        product.setHINHANH("img/"+imageUUID);

        productService.updateProduct(product);
        return "redirect:/admin/products";
    }//form add new product > do add
    @GetMapping("/admin/products/delete/{id}")
    public String deletePro(@PathVariable long id){
        productService.removeProductById(id);
        return "redirect:/admin/products";
    }//delete 1 product

    @GetMapping("/admin/products/update/{id}")
    public String updatePro(@PathVariable long id, Model model){
        Optional<SanPham> opProduct = productService.getSanPhamByid(id);
        if (opProduct.isPresent()){
            SanPham product = opProduct.get();
            //convert entity > dto
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setTEN_SAN_PHAM(product.getTEN_SAN_PHAM());
            productDTO.setDON_GIA(product.getDON_GIA());
            productDTO.setMO_TA(product.getMO_TA());
            productDTO.setHINHANH(product.getHINHANH());
            productDTO.setSL_ton(product.getSL_ton());

            model.addAttribute("productDTO", productDTO);
            return "productsAdd";
        }else {
            return "404";
        }

    }//form edit product, fill old data into form

    //Đơn Hàng
    @GetMapping("/admin/Donhang")
    public String getDon(Model model){
        model.addAttribute("DonHang",donHangRepository.findAll());
        return "DonHang";
    }
    @GetMapping("/admin/DonHang/delete/{id}")
    public String deleteDH(@PathVariable long id){
        donHangRepository.deleteById(id);
        return "redirect:/admin/Donhang";
    }//delete 1 product

}
