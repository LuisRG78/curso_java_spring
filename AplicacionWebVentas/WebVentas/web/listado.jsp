<%-- 
    Document   : listado.jsp
    Created on : 24-may-2019, 9:41:55
    Author     : Admin
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.sinensia.modelo.logica.*" %>
<%@page import="com.sinensia.modelo.Cliente" %>
<%! ServicioClientes srvCli; %>
<% srvCli = new ServicioClientes();
List<Cliente> clientes = srvCli.obtenerTodos();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Clientes</title>
    </head>
    <body>
        <%@include file="cabecera.jsp" %>
         <h2>Listado Clientes</h2>
        <table border="2">
            <thead>
                <tr>
                    <th>Nombre:</th>
                    <th>Email:</th>
                    <th>Edad:</th>
                    <th>Activo:</th>
                </tr>
            </thead>
            <%-- Manera rollo servlet cutre --%>
             <% for (Cliente cli: clientes){ 
                out.println("<tr><td>" + cli.getNombre()+ "</td>");
                out.println("<td>" + cli.getEmail() + "</td>");
                out.println("<td>" + cli.getEdad() + "</td>");
                out.println("<td>" + cli.getActivo() + "</td></tr>");
             }%>
            <%-- Manera rollo JSP medio cutre--%>
            
            <% for (int i = 0; i < clientes.size(); i++) { %>
            <tr>
                <td><%= clientes.get(i).getNombre() %></td>
                <td><%= clientes.get(i).getEmail() %></td>
                <td><%= clientes.get(i).getEdad() %></td>
                <td><%= clientes.get(i).getActivo() %></td>
                
            </tr>
            <% } %>
            
            <%-- Manera molona --%>
            <%--    
            <% for (Cliente cli: clientes){ %>
             <tr>
                 <td> <% out.println(cli.getNombre());%> </td>
                 <td> <% out.println(cli.getEmail());%> </td>
                 <td> <% out.println(cli.getEdad());%> </td>
                 <td> <% out.println(cli.getActivo());%> </td>
             </tr>
            <% } %>
            --%>
        </table>
    </body>
</html>
