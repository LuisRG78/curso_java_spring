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
public class Tigre extends AnimalSalvaje implements Depredador, Mamifero{

    public Tigre(String nombre, float tamanho) {
        super(nombre, tamanho);
    }

    @Override
    public void mover() {
         System.out.print("- Soy " + nombre + "!! Puedo correr a gran velocidad.");
    }

    @Override
    public void comer() {
        System.out.print(" Como las presas que cazo.");
    }
    @Override
    public void volar() {
        throw new UnsupportedOperationException("No puedo volar."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cazar(String presa){
        System.out.println(nombre +" persigue y caza a " + presa);
    }
    
    @Override
    public void mamar(){
        System.out.println("Tomo leche de tigresa");
    }
   
    @Override
    public String mamar(Mamifero m){
        return "El tigre " + nombre + " mama de " + m.toString();
    }
    
    @Override
    public String nombrar(){
        return nombre;
    }
    
    @Override
    public String toString(){
        return "Tigre " + nombre;
    }
    
}
