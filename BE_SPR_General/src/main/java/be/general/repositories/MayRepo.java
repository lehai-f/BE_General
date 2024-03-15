package be.general.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import be.general.model.May;

@Repository
public interface MayRepo extends JpaRepository<May, String>{
    
    @Query("SELECT m.maMay FROM May m")
    List<String> findAllMaMay();

}
