<%-- 
    Document   : index
    Created on : 20/06/2021, 02:52:56 PM
    Author     : brbr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <title>Inicio</title>
    <jsp:include page="/static/head.jsp"></jsp:include>
  </head>
  <body>
    <div class="container">
      <div class="row">
        <div class="col-sm-12">
          <h1>Calculadora de índice de Masa Corporal</h1>
        <%
          //HttpSession sess = request.getSession(false);
          //sess.setAttribute("isloged","") ;
        %>
        </div>
      </div>
      <div class="row">
        <div class="col-md-6">
          <h3>Iniciar Sesión</h3>
          <form action="loged" method="post" >
            <div class="form-group" >
              <label>Usuario:</label>
              <input type="text" class="form-control" id="userl" name="user" required />
            </div>
            <div class="form-group" >
              <label>Contraseña:</label>
              <input type="text" class="form-control" id="passl" name="pass" required />
            </div>
            <div class="form-group" >
              <label>&nbsp;</label>
              <input type="submit" class="form-control btn-primary" />
            </div>
          </form>
        </div>
        <div class="col-md-6">
          <h3>Registrarse</h3>
          <form action="newuser" method="post" id="form2" >
            <div class="form-group">
              <label>Nombre completo:</label>
              <input type="text" id="name" name="name" class="form-control" required />
            </div>
            <div class="form-group">
              <label>Edad:</label>
              <input type="text" id="age" name="age" class="form-control" required />
            </div>
            <div class="form-group">
              <label>Sexo:</label>
              <input type="text" id="gender" name="gender" class="form-control" required />
            </div>
            <!--div class="form-group">
              <label>Altura (centímetros):</label>
              <input type="text" id="height" name="height" class="form-control" required/>
            </div>
            <div class="form-group">
              <label>Peso:</label>
              <input type="text" id="weight" name="weight" class="form-control" required/>
            </div-->
            <div class="form-group">
              <label>Usuario:</label>
              <input type="text" id="user" name="user" class="form-control" required/>
            </div>
            <div class="form-group">
              <label>Contraseña:</label>
              <input type="text" id="pass" name="pass" class="form-control" required/>
            </div>
            <div class="form-group">
              <label>&nbsp;</label>
              <button type="button" class="form-control btn-primary" onclick="save()">Registrar</button>
            </div>
          </form>
        </div>
      </div>
    </div>
    <script>
      function save(){
        var form2 = document.getElementById("form2");
        if(form2.checkValidity() ){
          $.ajax({
            url:"newuser",
            data:JSON.stringify({
              user:$("#user").val(),
              pass:$("#pass").val(),
              name:$("#name").val(),
              age:$("#age").val(),
              gender:$("#gender").val()
              //height:$("#height").val(),
              //weight:$("#weight").val()
            }),
            error:function(xhr,status,error){
              //console.log(xhr.responseJSON.message);
              //console.log(xhr);
              alert("El usuario ya está registrado \n\n Intenta con un usuario diferente");
            },
            type:"POST",
            contentType:"application/json; charset=utf-8",
            success:function(data,status){
              form2.reset();
              alert("Registro exitoso\n" +
              //"Tu Usuario es: " + data.id +
              "\n\n Ahora puede iniciar sesión");
              //$("#user").val(data.id);
              //$("#user").attr("readonly","readonly");
            }
            
          });
        }else{
          form2.reportValidity();
        }
        
      }
    </script>
  </body>
</html>
