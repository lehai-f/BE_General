package be.general.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.general.dto.KhachHangIFDTO;
import be.general.dto.SuDungDVFormDTO;
import be.general.dto.SuDungMayFormDTO;
import be.general.repositories.KhachHangRepo;
import be.general.repositories.SDDVRepo;
import be.general.repositories.SDMRepo;

@Service
@Transactional
public class TestServices {
	@Autowired
	KhachHangRepo khRepo;
	
	@Autowired
	SDDVRepo sddvRepo;
	
	@Autowired
	SDMRepo sdmRepo;
	
	public List<KhachHangIFDTO> getKHIFDTO(){
		List<KhachHangIFDTO> listKH = khRepo.getMaKHTenKH();
		List<SuDungDVFormDTO> sddvList = sddvRepo.getSDDVDTO();
		List<SuDungMayFormDTO> sdmList = sdmRepo.getAllSDMDTO();
		for (KhachHangIFDTO kh : listKH) {
			for (SuDungMayFormDTO may : sdmList) {
				if(kh.getMaKH().equals(may.getMaKH())) {
					kh.addMay(may);
				}
			}
			int tongtien = 0;
			for (SuDungDVFormDTO dv : sddvList) {
				if(kh.getMaKH().equals(dv.getMaKH())) {
					tongtien += dv.getSoLuong()*dv.getDonGia();
					kh.addDV(dv);
				}
			}
			kh.setTongTien(tongtien);
		}
		return listKH;
	}
}
