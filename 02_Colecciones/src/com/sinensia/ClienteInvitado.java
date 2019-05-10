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
public class ClienteInvitado extends Cliente{

    private int duracionMax;
    
    public ClienteInvitado(long cliente_id, String nombre, String email) {
        super(cliente_id, nombre, email);
    }

    /**
     * Get the value of duracionMax
     *
     * @return the value of duracionMax
     */
    public int getDuracionMax() {
        return duracionMax;
    }

    /**
     * Set the value of duracionMax
     *
     * @param duracionMax new value of duracionMax
     */
    public void setDuracionMax(int duracionMax) {
        this.duracionMax = duracionMax;
    }
    
    @Override
    public void mostrar(){
        System.out.print("Invitado - ");
        super.mostrar();
        System.out.println(" Duración máxima: " + duracionMax);
    }  
    
}
