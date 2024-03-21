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
    public String saveMay(Model model, @ModelAttribute("formMay") @Valid May may, BindingResult rs) {
        if (rs.hasErrors()) {
            return "/may/newMay";
        }
        boolean checkID = mayServices.isExistsMay(may.getMaMay());
        if (checkID) {
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
        model.addAttribute("crPage", page);
        return "/may/listMay";
    }

    @GetMapping("/update/{id}")
    public String showFormUDMay(@PathVariable(name = "id") String maMay, Model model) {
        May may = mayServices.getMayByID(maMay);
        model.addAttribute("formUpdate", may);
        model.addAttribute("maMay", maMay);
        return "/may/updateMay";
    }

    @PostMapping("/update")
    public String doUpdateMay(@ModelAttribute("formUpdate") @Validated May may, Model model, BindingResult rs) {
        if (rs.hasErrors()) {
            return "/may/updateMay";
        }
        mayServices.saveMay(may);
        return "redirect:/may/listMay";
    }
    
	@GetMapping("/delete")
	public String deleteDichVu(@RequestParam("id") String maDV, Model model) {
		mayServices.delMayByID(maDV);
		return "redirect:/may/listMay";
	}
}
