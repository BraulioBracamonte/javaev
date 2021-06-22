package com.itesm.evidencia;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImcsService {
  
  @Autowired
  private ImcsRepository repo;
  
  public List<Imcs> listAll(){
    return repo.findAll();
  }
  
  public Imcs save(Imcs imc){
    return repo.save(imc);
  }
  
  public Imcs get(Integer id){
    return repo.findById(id).get();
  }
  
  public void delete(Integer id){
    repo.deleteById(id);
  }
  
}