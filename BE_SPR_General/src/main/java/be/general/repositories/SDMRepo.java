package be.general.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import be.general.dto.SuDungMayFormDTO;
import be.general.model.SuDungMay;
import be.general.model.SuDungMayID;

@Repository
public interface SDMRepo extends JpaRepository<SuDungMay, SuDungMayID> {

    @Query("SELECT new be.general.dto.SuDungMayFormDTO (sdm.sdmID.maKH, sdm.sdmID.maMay , sdm.sdmID.ngaySD, sdm.sdmID.gioSD, sdm.thoiGianSD ) "
            + " FROM SuDungMay sdm")
    public Page<SuDungMayFormDTO> getAllSDMayDTO(Pageable page);
    
    
    @Query("SELECT new be.general.dto.SuDungMayFormDTO (sdm.sdmID.maKH, sdm.sdmID.maMay , sdm.sdmID.ngaySD, sdm.sdmID.gioSD, sdm.thoiGianSD,m.viTri,m.trangThai ) "
            + " FROM SuDungMay sdm "
            + " INNER JOIN sdm.sdMay m")
    public List<SuDungMayFormDTO> getAllSDMDTO();
}
