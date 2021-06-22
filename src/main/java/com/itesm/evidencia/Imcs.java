package com.itesm.evidencia;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Imcs implements Serializable {
  
  private Integer id;
  private Integer userid;
  private Float height;
  private Float weight;
  private Float imc;
  private String date;
  
  public Imcs(){
    
  }
  
  public Imcs(Integer id, Integer userid, Float height, Float weight, Float imc, String date) {
    this.id = id;
    this.userid = userid;
    this.height = height;
    this.weight = weight;
    this.imc = imc;
    this.date = date;
  }
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUserid() {
    return userid;
  }

  public void setUserid(Integer userid) {
    this.userid = userid;
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

  public Float getImc() {
    return imc;
  }

  public void setImc(Float imc) {
    this.imc = imc;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }
  
  
  
}
