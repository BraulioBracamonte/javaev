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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
 
    @Autowired
    private UsersService service;
    
    @Autowired
    UsersRepository repo;
    
    @GetMapping("/users")
    public List<Users> list(){
      return service.listAll();
    }
    
    @GetMapping("/users/{id}")
    public ResponseEntity<Users> get(@PathVariable Integer id){
      try {
        Users user = service.get(id);
        return new ResponseEntity<Users>(user, HttpStatus.OK);
      } catch (NoSuchElementException e) {
        return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
      }
    }
    
    @GetMapping("/login2/{id}")
    public ResponseEntity<Users> login(@PathVariable Integer id){
      try {
        Users user = service.get(id);
        //se
        return new ResponseEntity<Users>(user, HttpStatus.OK);
      } catch (NoSuchElementException e) {
        return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
      }
    }
    
    @PostMapping("/newuser")
    public ResponseEntity<Users> add(@RequestBody Users user ){
      //service.save(user);
      Users usr = service.save(user);
      return new ResponseEntity<Users>(usr, HttpStatus.OK);
    }
    
    @GetMapping("/usersss")
    public ResponseEntity<List<Users>> getbyname(@RequestParam String name){
      return new ResponseEntity<List<Users>>(repo.findByName(name), HttpStatus.OK);
    }
    
    @GetMapping("/user")
    public ResponseEntity<Users> getbyuser(@RequestParam String name){
      return new ResponseEntity<Users>(repo.findByuser(name), HttpStatus.OK);
    }
    
}