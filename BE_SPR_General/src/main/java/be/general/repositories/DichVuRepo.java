package be.general.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import be.general.model.DichVu;

@Repository
public interface DichVuRepo extends JpaRepository<DichVu, String> {
    
    @Query("FROM DichVu dv WHERE dv.maDV LIKE %:keySearch% OR dv.tenDV LIKE %:keySearch% OR dv.donGia LIKE %:keySearch% ")
    public Page<DichVu> searchDV(@Param("keySearch") String keySearch, Pageable page);
    
    @Query("SELECT dv.maDV FROM DichVu dv")
	public List<String> findAllMaDV();
}
