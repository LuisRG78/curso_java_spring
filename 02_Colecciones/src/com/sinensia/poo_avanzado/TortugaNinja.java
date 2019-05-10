/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.poo_avanzado;

import com.sinensia.Cliente;

/**
 *
 * @author Admin
 */
public class TortugaNinja extends Mascota {

    public TortugaNinja(String nombre, float tamanho) {
        super(4, true, true, nombre, tamanho);
    }

    @Override
    public void mover() {
        System.out.print("- Soy " + nombre + "!! Reptando voy!!.");
    }
    
    @Override
    public void comer(){
        System.out.println(" Como pizza.");
    }

    @Override
    public void volar() {
        throw new UnsupportedOperationException("No puede volar!!"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saludarAlPropietario() {
        System.out.println(propietario.getNombre()
            + " te saluda con una mirada chunga "
                + propietario.getNombre() + "!!!");
    }    
}
