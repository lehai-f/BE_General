package be.general.controller;

import java.util.ArrayList;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import be.general.dto.InfoFull;
import be.general.dto.MayFormDTO;
import be.general.dto.SDNhieuMayDTO;
import be.general.dto.SuDungDVFormDTO;
import be.general.dto.SuDungMayFormDTO;
import be.general.services.DichVuServices;
import be.general.services.KhachHangServices;
import be.general.services.MayServices;
import be.general.services.SVServices;
import be.general.validator.AddNhieuMayValidator;

@Controller
@RequestMapping("Services")
public class ServicesController {

    @Autowired
    private SVServices sv;

    @Autowired
    private KhachHangServices khServices;

    @Autowired
    private MayServices mayServices;

    @Autowired
    private DichVuServices dvServices;
    
    @Autowired
    private AddNhieuMayValidator addValid;

    @GetMapping("/newSuDungMay")
    public String showFormSDMay(Model model) {
        if (!model.containsAttribute("newSDMay")) {
            model.addAttribute("listKH", khServices.getAllKH());
            model.addAttribute("listMay", mayServices.getAllMay());
            model.addAttribute("dkSDMayForm", new SuDungMayFormDTO());
        }
        return "/services/dkSDMay";
    }

    @PostMapping("/saveSDMay")
    public String saveNewSDMay(@ModelAttribute("dkSDMayForm") @Valid SuDungMayFormDTO sdMay, BindingResult rs,
            Model model) {
        if (rs.hasErrors()) {
            model.addAttribute("listKH", khServices.getAllKH());
            model.addAttribute("listMay", mayServices.getAllMay());
            return "/services/dkSDMay";
        }
        sv.saveNewSDMay(sdMay);
        return "redirect:/Services/listSDMay";
    }

    @GetMapping("/listSDMay")
    public String listSDMay(Model model, @RequestParam(defaultValue = "0") Integer page) {
        Pageable pageAble = PageRequest.of(page, 5);
        Page<SuDungMayFormDTO> listSD = sv.getAllSuDungMayDTO(pageAble);
        model.addAttribute("listSD", listSD.getContent());
        model.addAttribute("ttPage", listSD.getTotalPages());
        model.addAttribute("crPage", page);
        return "/services/listSDMay";
    }

    @GetMapping("/newSDDV")
    public String showFormSDDV(Model model) {
        if (!model.containsAttribute("newSDDV")) {
            model.addAttribute("listKH", khServices.getAllKH());
            model.addAttribute("listDV", dvServices.allMaDV());
            model.addAttribute("dkSDDVForm", new SuDungDVFormDTO());
        }

        return "/services/dkSDDV";
    }

    @PostMapping("/saveSDDV")
    public String saveNewSDDV(@ModelAttribute("dkSDDVForm") @Valid SuDungDVFormDTO sddv, BindingResult rs,
            Model model) {
        if (rs.hasErrors()) {
            model.addAttribute("listKH", khServices.getAllKH());
            model.addAttribute("listDV", dvServices.allMaDV());
            return "/services/dkSDDV";
        }
        sv.saveNewSDDV(sddv);
        return "redirect:/Services/listSDDV";
    }

    @GetMapping("/listSDDV")
    public String listSDDV(Model model, @RequestParam(defaultValue = "0") Integer page) {
        Pageable pageAble = PageRequest.of(page, 5);
        Page<SuDungDVFormDTO> listSDDV = sv.getAllSuDungDVDTO(pageAble);
        model.addAttribute("listSD", listSDDV.getContent());
        model.addAttribute("ttPage", listSDDV.getTotalPages());
        model.addAttribute("crPage", page);
        return "/services/listSDDV";
    }
    
    @GetMapping("/dkListSDMay/{id}")
    public String addListSDDV(@PathVariable(name = "id") String idKH,Model model) {
        if (!model.containsAttribute("newListSDDV")) {
            model.addAttribute("listMM", mayServices.getAllMaMay());
            ArrayList<MayFormDTO> listMay = new ArrayList<MayFormDTO>();
            listMay.add(new MayFormDTO());
            SDNhieuMayDTO abc = new SDNhieuMayDTO(idKH, listMay);
            model.addAttribute("sudungMays", abc);
            model.addAttribute("idKH", idKH);
        }
        return "/services/dkNhieuMay";
    }
    
    @PostMapping("/saveNhieuMay")
    public String saveNhieuMay(@ModelAttribute("sudungMays") SDNhieuMayDTO sdm, BindingResult rs , Model model) {
        addValid.validate(sdm, rs);
        if(rs.hasErrors()) {
        	model.addAttribute("idKH", sdm.getMaKH());
        	model.addAttribute("listMM", mayServices.getAllMaMay());
        	model.addAttribute("sudungMays", sdm);
        	return "/services/dkNhieuMay";
        }
        return "/index";
    }
    
    @GetMapping("/listFullinfor")
    public String getAllInfomation(Model model, @RequestParam(defaultValue = "0") Integer page) {
    	Pageable pageAble = PageRequest.of(page, 5);
    	Page<InfoFull> listFullIF = sv.getAllListInfo(pageAble);
        model.addAttribute("khList", listFullIF.getContent());
        model.addAttribute("ttPage", listFullIF.getTotalPages());
        model.addAttribute("crPage", page);
    	return "/services/FullInformation";
    }
}
