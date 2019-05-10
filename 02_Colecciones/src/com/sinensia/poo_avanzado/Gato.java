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
public class Gato extends Mascota implements Depredador, Mamifero{

    public Gato(String nombre, float tamanho) {
        super(4, true, false, nombre, tamanho);
    }
    
    @Override
    public void mover() {
        System.out.print("- Soy " + nombre + "!! Marramiauuuuu!!.");
    }
    
    @Override
    public void comer(){
        System.out.println(" Me zampo sardinas a cascoporro!!.");
    }

    @Override
    public void volar() {
        throw new UnsupportedOperationException("No puede volar!!."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saludarAlPropietario() {
        System.out.println(propietario.getNombre() + " Miau, miau, te rozo con el lomo");
    }
    
    @Override
    public void cazar(String presa){
        System.out.println(nombre +" busca, persigue y caza a " + presa);
    }
    
    @Override
    public void pedirComida(){
        System.out.println(propietario.getNombre()
            + " ALIMENTAME!!!");
    }
    
    @Override
    public void mamar(){
        System.out.println("Tomo leche de gata");
    } 
    
    @Override
    public String mamar(Mamifero m){
        return "El Gato " + nombre + " mama de " + m.toString();
    }
    
    @Override
    public String nombrar() {
        return nombre;
    }
    
    @Override
    public String toString() {        
        return "Gato " +nombre;     
    }
    
    
    
}
