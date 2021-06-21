package com.itesm.evidencia;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsersService {
  
  @Autowired
  private UsersRepository repo;
  
  public List<Users> listAll(){
    return repo.findAll();
  }
  
  public Users save(Users users){
    return repo.save(users);
  }
  
  public Users get(Integer id){
    return repo.findById(id).get();
  }
  
  public void delete(Integer id){
    repo.deleteById(id);
  }
  
  /*public Users getuser(String user){
    repo.get(user);
  }//*/
  
}
