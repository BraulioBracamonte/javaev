package com.itesm.evidencia;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
  
  List<Users> findByName(String name);
  Users findByuser(String user);
  
}
