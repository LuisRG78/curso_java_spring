/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01_ejemplojava;

/**
 *
 * @author Admin
 */
public class Tucan {
    String[] colores;
    int edad;
    float longitud;
    
    public Tucan(){
        this.edad = 0;
        this.longitud = 5f;
        String colores[] = {"blanco", "marron"};
    }
    
    public void piar(){
        System.out.println("pio pio " + edad+ " años");
    }
}
