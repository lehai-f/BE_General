package be.general.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.general.model.May;

@Repository
public interface MayRepo extends JpaRepository<May, String>{

}
