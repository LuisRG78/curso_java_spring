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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean condicion = 5 == 5 && true;
        if(3 < 5) {
            System.out.println("Se muestra si la condición es verdadera");
        } else if(5 > 7) {
            System.out.println("No se ejecuta");
        } else if(8 > 9) {
            System.out.println("No se ejecuta tampoco");
        } else {
            System.out.println("Cualquier otro caso");
        }
        
        char letra = 'B';
        switch(letra){
            case 'A':
                System.out.println("Aaaa");
                break;
            case 'B':
                System.out.println("Bbbbb");
                break;
            case 'C':
                System.out.println("Ccccc");
                break;
        }
        String nombreCompleto = nombreApellidos("Luis Miguel", "Ramos García");
        System.out.println(nombreCompleto);
        
        Tucan miPajaro = new Tucan();
        miPajaro.longitud = 20.5F;
        miPajaro.edad = 3;
        System.out.println("Long Tucan: " + miPajaro.longitud);
        
        Tucan otroPajaro = null;
        otroPajaro.longitud = 30.9F;
        System.out.println("Mi Tucan: " + miPajaro.longitud);
        System.out.println("Otro Tucan: " + otroPajaro.longitud);
        System.out.println("Otro Tucan: " + otroPajaro);
        
        otroPajaro = miPajaro;
        
        System.out.println("Otro Tucan: " + otroPajaro.longitud);
        
        miPajaro.longitud = 67.6F;
        System.out.println("Otro Tucan: " + otroPajaro.longitud);
        
        otroPajaro.piar();
        miPajaro.piar();
        
    }
    static String nombreApellidos(String nombre, String apellido){
            return nombre + " " + apellido;
    }
    
    
    
}
