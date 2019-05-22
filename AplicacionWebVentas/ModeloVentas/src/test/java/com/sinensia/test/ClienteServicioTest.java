package com.sinensia.test;

import com.sinensia.modelo.logica.ServicioClientes;
import com.sinensia.modelo.Cliente;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class ClienteServicioTest {
    
    private static ServicioClientes servCli;
    
    public ClienteServicioTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        servCli = new ServicioClientes();
    }   
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test
    @Test
    public void clienteOK_1() {
        assertNotNull(servCli.insertar("Ok", "pru@email.com", "ok12", "30", "on"));
        assertEquals(servCli.obtenerUno("pru@email.com").getNombre(), "Ok");
        //Lo eliminamos
        servCli.eliminar("pru@email.com");
        //Comprobamos que ya no existe
        assertNull(servCli.obtenerUno("pru@email.com"));
    }
    
    @Test
    public void clienteOk_2(){
        servCli.insertar("Ok", "pru@email.com", "ok12", "30", "on");
        servCli.insertar("Cliente Ok", "pru2@email.com", "ok22", "25", "on");
        assertEquals(servCli.obtenerUno("pru@email.com").getEdad(), "30");
        assertTrue(servCli.obtenerUno("pru2@email.com").getActivo() == 1);
        //Los eliminamos
        servCli.eliminar("pru@email.com");
        servCli.eliminar("pru2@email.com");
        //Comprobamos que ya no existen
        assertNull(servCli.obtenerUno("pru@email.com"));       
        assertNull(servCli.obtenerUno("pru2@email.com"));
    }
    
    @Test
    public void clienteMal_Nombre(){
        servCli.insertar(null, "emailok@ok.com", "ok12", "30", "on");
        assertNull(servCli.obtenerUno("emailok@ok.com"));
    }
    
    @Test
    public void clienteMal_OtrosCampos(){
        servCli.insertar("Nombre bien", "", "ok12", "30", "on");
        assertNull(servCli.obtenerUno(""));
        servCli.insertar("Bien", "clien@ok.com", "", "30", "on");
        servCli.insertar("Ok", "client_50@ok.com", "ok12", "30", "on");
        servCli.insertar("Nombre bien", "client_55@ok.com", "ok12", "30", "on");
       
        assertNull(servCli.obtenerUno("clien@ok.com"));
        assertNull(servCli.obtenerUno("client_50@ok.com"));
        assertNull(servCli.obtenerUno("client_55@ok.com"));    
    }
    
    @Test
    public void clienteModificacion_OK(){
        assertNotNull(
            servCli.insertar("luismi", "email1@ok.com", "", "36", "on"));
        Cliente cliente = servCli.obtenerUno("email1@ok.com");                 
        servCli.modificar(cliente.getId(), "Cli", "email1@ok.com", "NuevaPSWD", "30", "on");
        cliente = servCli.obtenerUno("email1@ok.com");
        assertEquals(cliente.getPassword(), "nuevaPSWD");
        servCli.eliminar("email1@ok.com");
        assertNull(servCli.obtenerUno("email1@ok.com"));
    }  
    
    @Test
    public void clienteModificacion_Mal(){
        assertNotNull(
            servCli.insertar("luismi", "email1@ok.com", "ok12", "30", "on"));
        Cliente cliente = servCli.obtenerUno("email1@ok.com");  
        assertNull(
            servCli.modificar(cliente.getId(), "Cli", "mmm@ok.com", "NuevaPSWD", "hh", "on"));
        cliente = servCli.obtenerUno("email1@ok.com");
        assertEquals(cliente.getEdad(), 30);
        servCli.eliminar("email1@ok.com");
        assertNull(servCli.obtenerUno("email1@ok.com"));
    }  
    
    @Test
    public void eliminarClientePorID(){
        assertNotNull(
            servCli.insertar("luismi", "email1@ok.com", "ok12", "30", "on"));
        Cliente cliente = servCli.obtenerUno("email1@ok.com");
        servCli.eliminar(cliente.getId());
        assertNull(servCli.obtenerUno(cliente.getId()));
    }
    
    @Test
    public void eliminarClientePorEmail(){
        
    }
    
}
