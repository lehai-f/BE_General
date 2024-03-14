package be.general.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import be.general.model.KhachHang;
import be.general.repositories.KhachHangRepo;

@Service
public class KhachHangServices {
    @Autowired
    private KhachHangRepo khRepo;

    public boolean isExistsDK(String maKH) {
        return khRepo.existsById(maKH);
    }

    public void saveKH(KhachHang kh) {
        khRepo.save(kh);
    }

    public Page<KhachHang> getAllKH(Pageable pageAble) {
        return khRepo.findAll(pageAble);
    }

    public KhachHang getKHByID(String maKH) {
        return khRepo.findById(maKH).get();
    }

    public Page<KhachHang> searchList(String text, Pageable pageAble) {
        return khRepo.searchKH(text, pageAble);
    }
    
    
    
}
