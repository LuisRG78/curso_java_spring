<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header><h1>Web Ventas</h1></header>
<nav>
    <c:if test="${login != 'ok'}">
        <a href="login.jsp">Login</a>
        <a href="registro.jsp">Nuevo cliente</a>
    </c:if>
        
        <a href="editar.jsp">Editar AJAX+REST</a>
    
    <c:if test="${login == 'ok'}">       
        <a href="listado.jsp">Listado Clientes</a>
        <a href="listado_sql.jsp">Listado JSTL+SQL</a>
        <a href="listado_jstl.jsp">Listado JSTL y JavaBeans</a>
        
        
        <%-- <span><%= request.getCookies().length <= 1 ? "" : request.getCookies()[1].getValue()%></span> --%>
    <%-- <Cookies con EL (Expression Language) --%>
    <span>${cookie.nombre_busqueda.value}</span>
    <span id="span_cookie_nom"></span>
    
     <form method="GET" action="clientes.do">
            <br/><input type="text" id="nombre" name="nombre"/>
            <input type="submit" value="BUSCAR"/><br/>
        
    </c:if>   
    
    
    </form>   
</nav>
<script src="js/cookies.js"></script>