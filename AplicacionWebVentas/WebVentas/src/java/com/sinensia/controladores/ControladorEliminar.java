
package com.sinensia.controladores;

import com.google.gson.Gson;
import com.sinensia.modelo.Cliente;
import com.sinensia.modelo.logica.ServicioClientes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Admin
 */
public class ControladorEliminar extends HttpServlet{
    
    /**
     * API REST Handles the HTTP <code>PUT</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        try(PrintWriter salida = response.getWriter()){

            String email = request.getParameter("email");

            ServicioClientes servCli = new ServicioClientes();
            servCli.eliminar(email);
            ArrayList<String> mensaje = new ArrayList<>();
            mensaje.add("Todo guay");
            Gson gson = new Gson();
            gson.toJson(mensaje);
        }
    }
    
}
