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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import be.general.model.May;
import be.general.services.MayServices;

@Controller
@RequestMapping("/may")
public class MayController {
    
    @Autowired
    private MayServices mayServices;
    
    @GetMapping("/newMay")
    public String showNewMay(Model model) {
        model.addAttribute("formMay", new May());
        return "/may/newMay";
    }
    
    @PostMapping("/save")
    public String saveMay(@ModelAttribute("formMay") @Validated May may, Model model, BindingResult rs) {
        if(rs.hasErrors()) {
            return "/may/newMay";
        }
        boolean checkID = mayServices.isExistsMay(may.getMaMay());
        if(checkID) {
            model.addAttribute("tontai", "Tồn tại May với MaMay đã nhập");
            return "/may/newMay";
        }
        mayServices.saveMay(may);
        return "redirect:/may/listMay";
    }
    
    @GetMapping("/listMay")
    public String listMay(Model model, @RequestParam(defaultValue = "0") Integer page) {
        Pageable pageAble = PageRequest.of(page, 5);
        Page<May> listMay = mayServices.getAllMay(pageAble);
        model.addAttribute("mayList", listMay.getContent());
        model.addAttribute("ttPage", listMay.getTotalPages());
        model.addAttribute("crPage",page);
        return "/may/listMay";
    }
    
}
