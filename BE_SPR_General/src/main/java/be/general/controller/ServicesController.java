package be.general.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import be.general.dto.SuDungMayFormDTO;
import be.general.services.KhachHangServices;
import be.general.services.MayServices;
import be.general.services.SVServices;

@Controller
@RequestMapping("Services")
public class ServicesController {
    
    @Autowired
    private SVServices sv;
    
    @Autowired
    private KhachHangServices khServices;
    
    @Autowired
    private MayServices mayServices;
    
    @GetMapping("/newSuDungMay")
    public String showFormSDMay(Model model) {
        if(!model.containsAttribute("newSDMay")) {
            model.addAttribute("listKH", khServices.getAllKH());
            model.addAttribute("listMay", mayServices.getAllMay());
            model.addAttribute("dkSDMayForm", new SuDungMayFormDTO());
        }
        return "/services/dkSDMay";
    }
    
    @PostMapping("/saveSDMay")
    public String saveNewSDMay(@ModelAttribute("dkSDMayForm") @Valid SuDungMayFormDTO sdMay, BindingResult rs,Model model) {
        if(rs.hasErrors()) {
            model.addAttribute("listKH", khServices.getAllKH());
            model.addAttribute("listMay", mayServices.getAllMay());
            return "/services/dkSDMay";
        }
        sv.saveNewSDMay(sdMay);
        return "redirect:/Services/listSDMay";
    }
    
    @GetMapping("/listSDMay")
    public String listSDMay(Model model,@RequestParam(defaultValue = "0") Integer page) {
        Pageable pageAble = PageRequest.of(page, 5);
        Page<SuDungMayFormDTO> listSD = sv.getAllSuDungMayDTO(pageAble);
        model.addAttribute("listSD", listSD.getContent());
        model.addAttribute("ttPage", listSD.getTotalPages());
        model.addAttribute("crPage",page);
        return "/services/listSDMay";
    }
}
