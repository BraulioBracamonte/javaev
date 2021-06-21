package com.itesm.evidencia;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users implements Serializable {
  private Integer id;
  private String user;
  private String pass;
  private String name;
  private Float height;
  private Float weight;
  private Integer age;
  private String gender;
  
  public Users(){}

  public Users(Integer id, String user, String pass, String name, Float height, Float weight, Integer age, String gender){
    this.id = id;
    this.user = user;
    this.pass = pass;
    this.name = name;
    this.height = height;
    this.weight = weight;
    this.age = age;
    this.gender = gender;
  }
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
  
  @Column(name="user", unique=true)
  public String getUser() {
    return user;
  }
  
  public void setUser(String user) {
    this.user = user;
  }

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Float getHeight() {
    return height;
  }

  public void setHeight(Float height) {
    this.height = height;
  }

  public Float getWeight() {
    return weight;
  }

  public void setWeight(Float weight) {
    this.weight = weight;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }
  
  
  
}
