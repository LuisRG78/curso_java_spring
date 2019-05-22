/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.test;

import com.sinensia.modelo.Cliente;
import com.sinensia.modelo.dao.ClienteDAO;
import com.sinensia.modelo.dao.Constantes;
import com.sinensia.modelo.dao.InterfazDAO;
import com.sinensia.modelo.dao.MySQLClienteDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class ClienteDAOTest {
    
    private static MySQLClienteDAO daoCli;
    
    @BeforeClass
    public static void setUpClass() {
        daoCli = new MySQLClienteDAO();
        assertNotNull("Error inicialización DAO", daoCli);
    }
    
    @Test
    public void clienteBien_1(){
        assertNotNull(
            daoCli.insertar(new Cliente(null,"Pru1", "pru@email.com", (short) 20, (short) 3, "Pru203")));
        assertEquals("pru@email.com", daoCli.obtenerUno("pru@email.com").getEmail());
        daoCli.eliminar("pru@email.com");
        assertNull(daoCli.obtenerUno("pru@email.com"));
    }
    @Test
    public void clienteMal_1(){
        assertNull(daoCli.insertar(new Cliente(null, "Pru", "pru2@email.com", (short) 23, (short) 4, "Pru234")));
        assertEquals("pru2@email.com", daoCli.obtenerUno(1).getEmail());
    }
      
    @Test
    public void eliminar(Integer id){
        try(Connection conex = DriverManager.getConnection(Constantes.CONEXION, Constantes.USUARIO, Constantes.PASSWORD)){
            String sqlQuery = "DELETE FROM cliente WHERE id=?";
            PreparedStatement sentencia = conex.prepareStatement(sqlQuery);
            sentencia.setInt(1, id);
            
            sentencia.executeUpdate();
            
        } catch (SQLException ex){
          Logger.getLogger(MySQLClienteDAO.class.getName())
                  .log(Level.SEVERE, "Error SQL", ex);      
        }      
    }
}
