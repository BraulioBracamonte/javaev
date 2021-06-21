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
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
      <title>JSP Page</title>
    </head>
    <body>
      <%
          HttpSession sess = request.getSession(false);
          out.print(sess.getAttribute("isloged") );
        %>
      <h1>tasdfasdf asdf asdf asdf</h1>
      Atts = ${atts}
      <br/>
      ->${usuario.pass}
      <br/>
      done!
    </body>
  </html>
