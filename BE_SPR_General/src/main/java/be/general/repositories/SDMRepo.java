package be.general.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.general.model.SuDungMay;
import be.general.model.SuDungMayID;

@Repository
public interface SDMRepo extends JpaRepository<SuDungMay, SuDungMayID> {

}
