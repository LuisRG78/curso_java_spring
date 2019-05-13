/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia;

import com.sinensia.dao.GenericoDAO;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Cliente extends Entidad{
    
    protected String nombre;
    private Date fecha_nac;
    private char genero;
    private boolean activo;
    private String email;

    public Cliente(long id, String nombre, String email){
        super(id);
        //this.cliente_id = cliente_id;
        
        if(nombre == null || nombre == ""){
            //throw new Exception("Nombre de Cliente inválido");
            System.err.println("Nombre de cliente inválido");
        }
        this.nombre = nombre;
        this.email = email;
        this.activo = true;
    }
    
    public void setNombre(String nombre){
        if(nombre == null || nombre == ""){
            //throw new Exception("Nombre de Cliente inválido");
            System.err.println("Nombre de cliente inválido");
        }
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
    
    public void mostrar(){
        System.out.println("Cliente: " + nombre);
        System.out.println(" Id: " + this.id);
        System.out.println(" Email: " + this.getEmail());
    }

    @Override
    public String toString() {
        //return super.toString(); //To change body of generated methods, choose Tools | Templates.
        return "Cliente [" + id + ", " + nombre + ", " + email + "]";
    }     
}
