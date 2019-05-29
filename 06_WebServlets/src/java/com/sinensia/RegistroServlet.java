package com.sinensia;

import com.google.gson.Gson;
import com.sinensia.RegistroRestController;
import com.sinensia.modelo.Cliente;
import com.sinensia.modelo.MySQLCliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Los servlets heredan de la clase HttpServlet
 *
 * @author Admin - German
 */
public class RegistroServlet extends HttpServlet {

    class Cliente{
        private String nombre;
        private String email;
        private String activo;
        private String edad;
        
        public Cliente(){ }

        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getActivo() { return activo; }
        public void setActivo(String activo) { this.activo = activo; }

        public String getEdad() { return edad; }
        public void setEdad(String edad) { this.edad = edad; }
        
    }
    @Override
    protected void doGet(HttpServletRequest peticion,
            HttpServletResponse respuesta)
            throws ServletException, IOException {
        respuesta.setContentType("text/html;charset=UTF-8");
        try (PrintWriter salida = respuesta.getWriter()) {
            salida.println("<html><head>");
            salida.println("<title>Web servlet desde Java</title>");
            salida.println("</head><body>");
            salida.println("<h1>Respuesta al registro</h1>");
            salida.println("<h2>Ruta del servlet: "
                    + peticion.getContextPath() + ", metodo: "
                    + peticion.getMethod() + "</h2>");
            salida.println("<ul>");
            for (int i = 0; i < 3; i++) {
                salida.println("<li>Num " + i + "</li>");
            }
            salida.println("</ul>");
            
            String nombre = peticion.getParameter("nombre");
            String strEdad = peticion.getParameter("edad");
            int edad = Integer.parseInt(strEdad);
            String email = peticion.getParameter("email");
            String strActivo = peticion.getParameter("activo");
            boolean activo = false;
            if (strActivo != null)  
                activo = true;
            // boolean activo = strActivo != null;
            
            salida.println("<p>nombre = " + nombre + "</p>");
            salida.println("<p>edad = " + edad+ "</p>");
            salida.println("<p>email = " + email+ "</p>");
            salida.println("<p>activo = " + activo+ "</p>");
            
            MySQLCliente bdCliente = new MySQLCliente();
            if (bdCliente.crear(nombre, email, "Passwd1234", edad, activo)) {                
                salida.println("<p>Guardado correctamente</p>");
            } else {
                salida.println("<p>Guardado ERRONEAMENTE</p>");
            }
            
            salida.println("</body></html>");
            salida.println("");
            salida.println("");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest peticion,
            HttpServletResponse respuesta)
            throws ServletException, IOException {
        respuesta.setContentType("application/json;charset=UTF-8");
        
        try(PrintWriter salida = respuesta.getWriter()){
            String nombre = peticion.getParameter("nombre");
            String email = peticion.getParameter("email");
            String edad = peticion.getParameter("edad");
            Short edadShort = Short.parseShort(edad);
            String activo = peticion.getParameter("activo");
            Short activoShort = Short.parseShort(activo);
            
            Gson gson = new Gson();
            gson.toJson(jsonElement);
        
            Cliente cli;
            cli = new Cliente();
            cli.setNombre(nombre + "modificado");
            cli.setEdad(edad);
            cli.setEmail("modificado_" + email);
            cli.setActivo(activo);
            
            String jsonCli = " { ";
           
            if(cli != null){
                                   
            }               
            
            jsonCli += "}";
            salida.print(jsonCli);
            System.out.println(">>>>>> " + jsonCli);
        
        }
    }

    @Override
    public String getServletInfo() {
        return "Registro clientes";
    }
}
