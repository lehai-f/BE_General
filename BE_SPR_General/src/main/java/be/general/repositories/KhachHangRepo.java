package be.general.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import be.general.model.KhachHang;

@Repository
public interface KhachHangRepo extends JpaRepository<KhachHang, String> {
    
    @Query("FROM KhachHang kh WHERE kh.maKH LIKE %:key% OR kh.tenKH LIKE %:key% OR kh.email LIKE %:key% OR kh.diaChi LIKE %:key% OR kh.soDT LIKE %:key%")
    public Page<KhachHang> searchKH(@Param("key") String key,Pageable page);
}
