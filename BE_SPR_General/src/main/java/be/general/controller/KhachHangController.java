package be.general.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import be.general.model.KhachHang;
import be.general.services.KhachHangServices;

@Controller
@RequestMapping("/khachhang")
public class KhachHangController {
    @Autowired
    private KhachHangServices khServices;
    
    @GetMapping("/newKH")
    public String showFromNewKH(Model model) {
        model.addAttribute("khForm", new KhachHang());
        return "khachhang/newkh";
    }
    
    @PostMapping("/save")
    public String saveNewKhachHang(Model model, @ModelAttribute("khForm") @Valid KhachHang kh, BindingResult rs) {
       if(rs.hasErrors()) {
           return "/khachhang/newkh";
       }
       boolean existsKH = khServices.isExistsDK(kh.getMaKH());
       if(existsKH) {
           model.addAttribute("tontai","Da ton tai KH voi ID da nhap");
           return "khachhang/newkh";
       }
       khServices.saveKH(kh);
       return "redirect:/khachhang/listKH";
    }
    
    @GetMapping("/listKH")
    public String showAllKH(Model model, @RequestParam(defaultValue = "0") Integer page) {
        Pageable pageAble = PageRequest.of(page, 5);
        Page<KhachHang> khList = khServices.getAllKH(pageAble);
        model.addAttribute("khList",khList.getContent());
        model.addAttribute("ttPage",khList.getTotalPages());
        model.addAttribute("crPage",page);
        return "/khachhang/listkh";
    }
    
    @GetMapping("/update/{id}")
    public String showFormUpdateKH(@PathVariable(name = "id") String maKH, Model model) {
        KhachHang kh = khServices.getKHByID(maKH);
        model.addAttribute("khFormUD", kh);
        model.addAttribute("maKH", maKH);
        return "/khachhang/updateKH";
    }
    
    @PostMapping("/update")
    public String doUpdateKH(@ModelAttribute("khFormUD") @Validated KhachHang kh, BindingResult rs,Model model) {
        if(rs.hasErrors()) {
            return "/khachhang/updateKH";
        }
        khServices.saveKH(kh);
        return "redirect:/khachhang/listKH";
    }
    
    @GetMapping("/searchKH")
    public String searchKH(@RequestParam("searchKey") String text, Model model,  @RequestParam(defaultValue = "0") Integer page) {
        Pageable pageAble = PageRequest.of(page, 5);
        Page<KhachHang> khList = khServices.searchList(text,pageAble);
        model.addAttribute("khList",khList.getContent());
        model.addAttribute("ttPage",khList.getTotalPages());
        model.addAttribute("crPage",page);
        return "/khachhang/listkh";
    }
    
}
