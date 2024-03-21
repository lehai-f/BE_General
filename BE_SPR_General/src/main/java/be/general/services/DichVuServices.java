package be.general.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import be.general.model.DichVu;
import be.general.repositories.DichVuRepo;

@Service
public class DichVuServices {
    @Autowired
   private DichVuRepo dvRepo;
    
   public void saveNewDv(DichVu dv) {
       dvRepo.save(dv);
   }
   
   public boolean isExistsDV(String id) {
       return dvRepo.existsById(id);
   }

public Page<DichVu> getAllDV(Pageable pageAble) {
    return dvRepo.findAll(pageAble);
}

public DichVu getDVByID(String maDV) {
    return dvRepo.findById(maDV).get();
}

public Page<DichVu> seachList(String text, Pageable pageAble) {
    return dvRepo.searchDV(text, pageAble);
}

public List<String> allMaDV(){
	return dvRepo.findAllMaDV();
}

public void delDVByID(String maDV) {
	dvRepo.deleteById(maDV);
	
}
}
