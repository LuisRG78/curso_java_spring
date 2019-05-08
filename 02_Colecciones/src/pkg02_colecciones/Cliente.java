/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg02_colecciones;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Cliente {
    private long cliente_id;
    private String nombre;
    private Date fecha_nac;
    private char genero;
    private boolean activo;
    private String email;

    public Cliente(long cliente_id, String nombre, String email) {
        this.cliente_id = cliente_id;
        this.nombre = nombre;
        this.email = email;
        this.activo = true;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
     public String getEmail() {
        return email;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean isActivo() {
        return activo;
    }
    
    public long getCliente_id() {
        return this.cliente_id;
    }
    
    
    
   
    
    
    
    
    
    
    
}
