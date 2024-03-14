package be.general.controller;

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

import be.general.model.DichVu;
import be.general.services.DichVuServices;

@Controller
@RequestMapping("/dichvu")
public class DichVuController {
    @Autowired
    private DichVuServices dvServices;

    @GetMapping("/newDV")
    public String showAddForm(Model model) {
        model.addAttribute("dvForm", new DichVu());
        return "dichvu/newdv";
    }

    @PostMapping("/save")
    public String saveNewDV(Model model, @ModelAttribute("dvForm") @Validated DichVu dv, BindingResult rs) {
        if (rs.hasErrors()) {
            return "/dichvu/newdv";
        }
        boolean exists = dvServices.isExistsDV(dv.getMaDV());
        if (exists) {
            model.addAttribute("tontai", "Da tồn tại DV với id đã nhập");
            return "dichvu/newdv";
        }
        dvServices.saveNewDv(dv);
        return "redirect:/dichvu/listDV";
    }
    
    @GetMapping("/listDV")
    public String showAllDV(Model model, @RequestParam(defaultValue = "0") Integer page) {
        Pageable pageAble = PageRequest.of(page, 5);
        Page<DichVu> dvList = dvServices.getAllDV(pageAble);
        model.addAttribute("dvList", dvList.getContent());
        model.addAttribute("ttPage", dvList.getTotalPages());
        model.addAttribute("crPage",page);
        return "/dichvu/listdv";
    }
    
    @GetMapping("/update/{id}")
    public String showFromUpdateDV(@PathVariable(name = "id") String maDV,Model model) {
        DichVu dv = dvServices.getDVByID(maDV);
        model.addAttribute("formUpDV", dv);
        model.addAttribute("maDV",maDV);
        return "/dichvu/updateDV";
    }
    
    @PostMapping("/update")
    public String updateDV(@ModelAttribute("formUpDV") @Validated DichVu dv, Model model , BindingResult rs) {
        if(rs.hasErrors()) {
            return "dichvu/updateDV";
        }
        dvServices.saveNewDv(dv);
        return "redirect:/dichvu/listDV";
    }
    
    @GetMapping("/searchDV")
    public String searchDV(@RequestParam("searchKey") String text, Model model, @RequestParam(defaultValue = "0") Integer page) {
        Pageable pageAble = PageRequest.of(page, 5);
        Page<DichVu> dvList = dvServices.seachList(text,pageAble);
        model.addAttribute("dvList", dvList.getContent());
        model.addAttribute("ttPage", dvList.getTotalPages());
        model.addAttribute("crPage",page);
        model.addAttribute("dichvu", new DichVu());
        return "/dichvu/listdv";
    }
    
    //haskdfsm.nvcb.xkdhfb.Sdjfb.cnvxcnvbxcnvbx,cn
}
