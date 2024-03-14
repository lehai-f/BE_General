package be.general.services;

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

}
