package com.sinensia.modelo.logica;

import com.sinensia.modelo.Cliente;
import com.sinensia.modelo.dao.MySQLClienteDAO;

/**
 *
 * @author Admin
 */
public class ServicioClientes {
    
    private MySQLClienteDAO dao;
    
    public ServicioClientes(){
        dao = new MySQLClienteDAO();
    }
    
    public Cliente insertar(String nombre, String email, String passwd, String edad, String activo){
        if (validar(nombre, email, passwd, edad, activo)){
            short iEdad = Short.parseShort(edad);
            //Activo puede ser null, poer eso mejor que activo.equals("on") se hace:
            short iActivo = (short)("on".equals(activo)?1:0);

            Cliente nuevoCli = new Cliente(null, nombre, email, iEdad, iActivo, passwd);
            nuevoCli = dao.insertar(nuevoCli);
            return nuevoCli;
        }else{
            return null;
        }
    }
    
    public Cliente obtenerUno(int id){           
        return dao.obtenerUno(id);
    }
    
    public Cliente obtenerUno(String email){           
        for(Cliente c : dao.obtenerTodos()){
            if (c.getEmail().equals(email)) {
                return c;
            }
        }
        return null;
    }
    
    public void eliminar (int id){
        dao.eliminar(id);
    }
    
    public void eliminar(String email){
        eliminar(obtenerUno(email).getId());
    }
    
    public Cliente modificar(int id, String nombre, String email, String passwd, String edad, String activo){
        Cliente cli = null;
        if (validar(nombre, email, passwd, edad, activo)){
            cli = new Cliente(id, nombre, email, Short.parseShort(edad), (short)("on".equals(activo)?1:0), passwd);
            cli = dao.modificar(cli);
        }
        return cli;
    }
    
    public boolean validar(String nombre, String email, String passwd, String edad, String activo){
        //validamos el nombre
        if(nombre ==null || nombre.equals("")){
            return false;
        }
        //validamos el email
        if(email ==null || email.equals("") || passwd == null || passwd.equals("")) {
            return false;
        } 
        //validamos la edad
        short iEdad = 0;        
        try{ 
            iEdad = Short.parseShort(edad);
        }catch(Exception e){
            return false;
        }
        
        if(iEdad <= 0){
            return false;
        }
        //Validamos activo
        //Activo puede ser null, por eso mejor que activo.equals("on") se hace:
        short iActivo = (short)("on".equals(activo)?1:0);
        //TODO: Faltan ciertas validaciones
        return true;
    }
}
