/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia;

/**
 *
 * @author Admin
 */
public class ClienteVip extends Cliente{
    
    private String beneficios;

    public ClienteVip(long cliente_id, String nombre, String email) {
        super(cliente_id, nombre, email);
    }
    
     public ClienteVip(long cliente_id, String nombre, String email, String beneficios) {
        super(cliente_id, nombre, email);
        this.beneficios = beneficios;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }
    
    @Override
    public void mostrar(){
        System.out.print("VIP - ");
        super.mostrar();
        System.out.println(" Beneficios: " + beneficios);
    }  
    
    
}
