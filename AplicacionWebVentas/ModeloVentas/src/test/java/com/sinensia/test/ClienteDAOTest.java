/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.test;

import com.sinensia.modelo.Cliente;
import com.sinensia.modelo.dao.ClienteDAO;
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
public class ClienteDAOTest {
    
    private static ClienteDAO daoCli;
    
    
    @BeforeClass
    public static void setUpClass() {
        daoCli = new ClienteDAO();
        assertNotNull("Error inicialización DAO", daoCli);
    }
    
    @Test
    public void clienteBien_1(){
        
        daoCli.insertar(new Cliente(null,"Pru1", "pru@email.com", (short) 20, (short) 3, "Pru203"));
        assertEquals("pru@email.com", daoCli.obtenerUno(3).getEmail());
        daoCli.eliminar(1);
        assertNull(daoCli.obtenerUno(1));
    }
    @Test
    public void clienteMal_1(){
        daoCli.insertar(new Cliente(null, "Pru", "pru2@email.com", (short) 23, (short) 4, "Pru234"));
        assertEquals("pru2@email.com", daoCli.obtenerUno(1).getEmail());
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
