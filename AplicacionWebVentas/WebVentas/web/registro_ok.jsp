<%@page import="com.sinensia.modelo.logica.ServicioClientes"%>
<!DOCTYPE html>
<%-- 
    Document   : registro_ok.jsp
    Created on : 24-may-2019, 9:59:03
    Author     : Admin
--%>

<%@page import="com.sinensia.modelo.*" %>
<html>
    <head>
        <title>Registro Ok</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%@include file="cabecera.jsp" %>
        <%= (new ServicioClientes()).obtenerUno("prueba@email.com").getNombre() %>
        
       <% for (int i = 0; i < 10; i++) 
       {
           %>
           
        <div>Registro Ok</div>
        
           <%
       } %>
        
    </body>
</html>
