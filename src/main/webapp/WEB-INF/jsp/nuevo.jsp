<%-- 
    Document   : nuevo
    Created on : 20/06/2021, 05:45:42 PM
    Author     : brbr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

  <html>
    <head>
      <title>JSP Page</title>
      <jsp:include page="/static/head.jsp"></jsp:include>
      <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.25/sb-1.1.0/sp-1.3.0/datatables.min.css"/>

      <script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.25/sb-1.1.0/sp-1.3.0/datatables.min.js"></script>
    </head>
    <body>
      <div class="container">
        <div class="row">
          <h1>Calculadora de índice de masa corporal</h1>
        </div>
        <div class="row">
          <div class="col-lg-6">
            <h3>Datos del usuario</h3>
            <table style="width: 100%;">
              <tr><th>Nombre:</th><td>${usuario.name}</td></tr>
              <tr><th>Edad:</th><td>${usuario.age}</td></tr>
              <tr><th>Género:</th><td>${usuario.gender}</td></tr>
            </table>
            <a href="/"><button class="btn btn-danger" >Cerrar sesión</button></a>
          </div>
          <div class="col-lg-6">
            <h3>Historial IMC</h3>
            <form id="form1">
              <div class="input-group mb-3">
                <div class="input-group-prepend">
                  <span class="input-group-text">Altura en centímetros</span>
                </div>
                <input type="number" min="100" max="250" step="1" class="form-control" id="height" />
              </div>
              <div class="input-group mb-3">
                <div class="input-group-prepend">
                  <span class="input-group-text">Peso en Kilogramos</span>
                </div>
                <input type="number" step="1" class="form-control" id="weight" />
              </div>
              <input type="date" id="date" required="required" class="" />
              <button type="button" onclick="saveimc()" class="btn btn-primary">Calcular</button>
            </form>
            <script>
              function saveimc(){
                var form1 = document.getElementById("form1");
                if(form1.checkValidity() ){
                  var h = $("#height").val()/100;
                  $.ajax({
                    url:"newimc",
                    data:JSON.stringify({
                      userid:${usuario.id},
                      height:$("#height").val(),
                      weight:$("#weight").val(),
                      imc:$("#weight").val()/(h * h ) ,
                      date:$("#date").val()
                    }),
                    error:function(xhr,status,error){
                      alert(xhr.responseJSON.message);
                    },
                    type:"POST",
                    contentType:"application/json; charset=utf-8",
                    success:function(data,status){
                      form1.reset();
                      alert("Registro exitoso\n");
                      table1.ajax.reload();
                    }

                  });
                }else{
                  form1.reportValidity();
                }

              }
            </script>
          </div>
        </div>
        <br/>
        <div class="row">
          <div class="col-sm-12">
            <table class="table table-striped table-bordered table-condensed" width='100%' id="table1"></table>
            <script>
              var table1;// se declara global el nombre de esta tabla
              $(document).ready(function() {
                table1 = $('#table1').DataTable( {
                  ajax:{
                    url: "/imcsf/${usuario.id}",
                    dataSrc: ""
                  }//*/
                  //data:""
                  //,colReorder:true
                  //,responsive: true
                  //,select:{blurable:true, style:'os' }
                  /*,dom:
                    "<'row'<'col-sm-8' B><'col-sm-4'l>>" +
                    //"<'row'<'col-lg' B > >"+
                    "<'row'<'col-md-3'i><'col-md-9'p>>"+
                    "<'row'<'col-lg'tr>>" +
                    "<'row'<'col-md-3'i><'col-md-9'p>>"//*/
                  ,"drawCallback": function(settings){
                    //dtafterdraw(table1);
                  }//FIN DE DRAW CALL BACK
                  ,"order":[[3,"desc"]]
                  ,columns:[
                    {data:"height", title:"Altura (cm)"}
                    ,{data:"weight", title:"Peso (Kg)"}
                    ,{data:"imc", title:"IMC"}
                    ,{data:"date", title:"Fecha(aaaa-mm-dd)"}
                  ]// FIN DE COLUMNS
                  
                });// FIN DE CREACION DE DATATABLES
                //dtafterinitialize(table1);
                //table1.columns([4] ).visible(false);
              });// FIN DE ON DOCUMENT READY
            </script>
          </div>
        </div>
      </div>
      
    </body>
  </html>
