<%-- 
    Document   : listado_jstl.jsp
    Created on : 24-may-2019, 13:49:22
    Author     : Admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.sinensia.modelo.Cliente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--Se hace un cast para convertir el objeto que devuelve el getAtributes a un arraylist --%>
<% List<Cliente> listaCliPorNombre = (ArrayList<Cliente>)request.getAttribute("listaPorNombre"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista con Beans</title>
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
            
            <%-- Manera rollo JSP medio cutre--%>           
            <% for (int i = 0; i < listaCliPorNombre.size(); i++) { %>
            <tr>
                <td><%= listaCliPorNombre.get(i).getNombre() %></td>
                <td><%= listaCliPorNombre.get(i).getEmail() %></td>
                <td><%= listaCliPorNombre.get(i).getEdad() %></td>
                <td><%= listaCliPorNombre.get(i).getActivo() %></td>                
            </tr>
            <% } %>          
        </table>
    </body>
</html>
