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
public class Dragon extends Mascota implements Depredador{

    public Dragon(String nombre, float tamanho) {
        super(2, true, false, nombre, tamanho);
    }
    
     public Dragon(int patas, boolean aerobico, boolean acuatico, String nombre, float tamanho) {
        super(2, true, false, nombre, tamanho);
    }    
    
    @Override
    public void mover() {
        System.out.print("- Soy " + nombre + "!! Puedo correr a gran velocidad.");
    }

    @Override
    public void volar() {
        System.out.println(" Vuelo asustando a la peña.");
    }

    @Override
    public void comer() {
        System.out.print("Te churrasca y te come.");
    }  

    @Override
    public void saludarAlPropietario() {
        System.out.println(propietario.getNombre() + " Echo llamitas al aire");
    }
    
    public void cazar(String presa){
        System.out.println(nombre +" quema, vuela y caza a " + presa);
    }
            
}
