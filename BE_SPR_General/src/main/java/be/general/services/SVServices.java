package be.general.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import be.general.dto.SuDungMayFormDTO;
import be.general.model.KhachHang;
import be.general.model.May;
import be.general.model.SuDungMay;
import be.general.model.SuDungMayID;
import be.general.repositories.SDDVRepo;
import be.general.repositories.SDMRepo;

@Service
public class SVServices {
    @Autowired
    private SDDVRepo sddvRepo;
    
    @Autowired
    private SDMRepo sdmRepo;
    
    @Autowired
    private ModelMapper modelMap;

    public void saveNewSDMay(SuDungMayFormDTO sdMay) {
        SuDungMayID sdID = modelMap.map(sdMay, SuDungMayID.class);
        SuDungMay sdMayEntites = modelMap.map(sdMay, SuDungMay.class);
        sdMayEntites.setSdMay(new May(sdMay.getMaMay()));
        sdMayEntites.setSdmKH(new KhachHang(sdMay.getMaKH()));;
        sdMayEntites.setSdmID(sdID);
        sdmRepo.save(sdMayEntites);
    }

    public Page<SuDungMayFormDTO> getAllSuDungMayDTO(Pageable pageAble) {
        return sdmRepo.getAllSDMayDTO(pageAble);
    }
    
}
