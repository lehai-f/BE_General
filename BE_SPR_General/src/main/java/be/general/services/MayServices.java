package be.general.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import be.general.model.May;
import be.general.repositories.MayRepo;

@Service
public class MayServices {
    
    @Autowired
    private MayRepo mayRepo;

    public boolean isExistsMay(String maMay) {
        return mayRepo.existsById(maMay);
    }

    public void saveMay(May may) {
        mayRepo.save(may);
    }

    public Page<May> getAllMay(Pageable pageAble) {
        // TODO Auto-generated method stub
        return mayRepo.findAll(pageAble);
    }

    public May getMayByID(String maMay) {
        // TODO Auto-generated method stub
        return mayRepo.findById(maMay).get();
    }

    public List<May> getAllMay() {
        return mayRepo.findAll();
    }
    
    public List<String> getAllMaMay(){
        return mayRepo.findAllMaMay();
    }

	public void delMayByID(String maMay) {
		// TODO Auto-generated method stub
		mayRepo.deleteById(maMay);
	}
}
