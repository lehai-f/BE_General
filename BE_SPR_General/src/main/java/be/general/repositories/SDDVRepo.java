package be.general.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import be.general.dto.SuDungDVFormDTO;
import be.general.model.SuDungDichVu;
import be.general.model.SuDungDichVuID;

@Repository
public interface SDDVRepo extends JpaRepository<SuDungDichVu, SuDungDichVuID> {

	@Query("SELECT new be.general.dto.SuDungDVFormDTO (sddv.sddvID.maKH, sddv.sddvID.maDV, sddv.sddvID.ngaySD, sddv.sddvID.gioSD, sddv.soLuong ) "
			+ " FROM SuDungDichVu sddv")
	public Page<SuDungDVFormDTO> getAllSuDungDVDTO(Pageable pageAble);

}
