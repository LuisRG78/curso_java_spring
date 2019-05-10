/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.poo_avanzado;

/**
 *
 * @author Admin
 */
public class Quebrantahuesos extends AnimalSalvaje{

    public Quebrantahuesos(String nombre, float tamanho) {
        super(0, true, false, nombre, tamanho);
    }
    
    @Override
    public void mover() {
        System.out.print("- Soy " + nombre + "!! Puedo caminar pero lo mio es volar.");
    }  
    
    @Override
    public void comer(){
        System.out.print(" Me zampo los restos que dejan los buitres!!.");
    }
    
    @Override
    public void volar(){
        System.out.println(" Puedo divisar animales muertos a km de distancia.");       
    }    
}
