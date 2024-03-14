package be.general.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.general.model.SuDungDichVu;
import be.general.model.SuDungDichVuID;

@Repository
public interface SDDVRepo  extends JpaRepository<SuDungDichVu, SuDungDichVuID>{

}
