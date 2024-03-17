package be.general.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import be.general.dto.KhachHangIFDTO;
import be.general.services.TestServices;

@Controller
@RequestMapping("/newTN")
public class NewTinhNangController {
	@Autowired
	TestServices tSV;
	
	@GetMapping("/listFullinfor")
	public String newTask(Model model) {
		if(!model.containsAttribute("newInfoTest")) {
			List<KhachHangIFDTO> khList = tSV.getKHIFDTO();
			model.addAttribute("khList", khList);
		}
		return "/TestList/TestInfoList";
	}
}
