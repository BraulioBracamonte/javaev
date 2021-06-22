package com.itesm.evidencia;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImcsController {
  
  @Autowired
  private ImcsService service;
  
  @Autowired
  ImcsRepository repo;
  
  @GetMapping("/imcs")
  public List<Imcs> list(){
    return service.listAll();
  }
  
  @PostMapping("/newimc")
  public ResponseEntity<Imcs> add(@RequestBody Imcs imc ){
    //service.save(user);
    Imcs Imc = service.save(imc);
    return new ResponseEntity<Imcs>(Imc, HttpStatus.OK);
  }
  
  @GetMapping("/imcsf/{userid}")
    public ResponseEntity<List<Imcs>> getbyuserid(@PathVariable Integer userid){
      return new ResponseEntity<List<Imcs>>(repo.findByUserid(userid), HttpStatus.OK);
    }
  
}
