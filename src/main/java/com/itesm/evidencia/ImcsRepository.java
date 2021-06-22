package com.itesm.evidencia;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImcsRepository extends JpaRepository<Imcs, Integer> {
  
  List<Imcs> findByUserid(Integer userid);
  //Users findByuser(String user);
  
}