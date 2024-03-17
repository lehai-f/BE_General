package be.general.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import be.general.dto.InfoFull;
import be.general.dto.KhachHangIFDTO;
import be.general.model.KhachHang;

@Repository
public interface KhachHangRepo extends JpaRepository<KhachHang, String> {
    
    @Query("FROM KhachHang kh WHERE kh.maKH LIKE %:key% OR kh.tenKH LIKE %:key% OR kh.email LIKE %:key% OR kh.diaChi LIKE %:key% OR kh.soDT LIKE %:key%")
    public Page<KhachHang> searchKH(@Param("key") String key,Pageable page);

    
    @Query("SELECT new be.general.dto.InfoFull (kh.maKH, kh.tenKH, m.maMay, m.viTri, m.trangThai, sdm.sdmID.ngaySD, sdm.sdmID.gioSD, sdm.thoiGianSD, dv.maDV ,sddv.sddvID.ngaySD,sddv.sddvID.gioSD,sddv.soLuong,(sddv.soLuong * dv.donGia) AS tongTien) "
    		+ " FROM KhachHang kh "
    		+ "	LEFT JOIN kh.sddvList sddv "
    		+ " LEFT JOIN kh.sdmList sdm "
    		+ " LEFT JOIN sddv.sddvDV dv "
    		+ " LEFT JOIN sdm.sdMay m "
    		+ " WHERE sddv.sddvID.maKH IS NOT NULL OR sdm.sdmID.maKH IS NOT NULL")
	public Page<InfoFull> getAllInfo(Pageable pageAble);
    
    
    @Query("SELECT new be.general.dto.KhachHangIFDTO (kh.maKH, kh.tenKH)"
    		+ " FROM KhachHang kh")
    public List<KhachHangIFDTO> getMaKHTenKH();
}
