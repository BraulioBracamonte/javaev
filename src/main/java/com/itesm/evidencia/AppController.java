/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itesm.evidencia;

import java.io.IOException;
import java.util.NoSuchElementException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author brbr
 */
@Controller
public class AppController {
  
  @RequestMapping("/")
  public String page(Model model, HttpSession session) {
    //model.addAttribute("attribute", "value");
    session.setAttribute("isloged", "");
    return "index";
  }
  
  @Autowired
  UsersRepository repo;
  
  @RequestMapping("/loged")
  public String newuser(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session ) throws IOException{
    model.addAttribute("atts", request.getParameter("pass") );
    //Integer usr = Integer.parseInt(request.getParameter("user") );
    try{
      Users user = repo.findByuser(request.getParameter("user"));
      
      model.addAttribute("usuario", user );
      
      if(user!=null && user.getPass().equals(request.getParameter("pass")) ){
        session.setAttribute("isloged", "isloged");
      }else{
        //session.setAttribute("isloged", "");
      }
      
    }catch(NoSuchElementException e){
      
    }
    if(!session.getAttribute("isloged").equals("isloged") ){
      response.sendRedirect("/"); 
    }
    return "nuevo";
  }//*/
  
}
