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
public class ProbandoAnimales {
    
    public static void probarClasesAbstractas(){
        Tucan unTucan = new Tucan("Turigualpa", 15.8f);
        unTucan.mover();
        unTucan.comer();
        unTucan.volar();
        System.out.println("------------------------------------------");
        
        Quebrantahuesos picachu = new Quebrantahuesos("Picachu", 253.8f);
        picachu.mover();
        picachu.comer();
        picachu.volar();
        System.out.println("------------------------------------------");
        
        TortugaNinja leonardo = new TortugaNinja("Leonardo", 175.5f);
        leonardo.mover();
        leonardo.comer();
        
        try{
            leonardo.volar();
        }catch (UnsupportedOperationException ex){
            System.err.println(ex.getMessage());
        }catch(StringIndexOutOfBoundsException ex){
            System.err.println("Error en el String: " + ex.getMessage());
        }catch(Exception ex){
            System.err.println("Error general: " + ex.getMessage());
            System.err.println("---------------");
            ex.printStackTrace();
        }finally{
            //Este código siempre se va a ejecutar
            //Se usa para cerrar recursos (BD, etc)
            System.out.println("Siempre me ejecuto. Cerremos recursos");
        }
        System.out.println("------------------------------------------");
        
        Gato micifuz = new Gato("Micifuz", 54.5f);
        micifuz.mover();
        micifuz.comer();
        System.out.println("------------------------------------------");
        
        Cliente yo = new Cliente(10, "Luismi", "aaa@nnn.com");
        Animal dragoncito = new Dragon("Drogo", 1000);
        dragoncito.comer();
        Mascota miMascota = (Mascota)dragoncito;
        miMascota.setPropietario(yo);
        ((Mascota)dragoncito).setPropietario(yo);
        ((Mascota)dragoncito).pedirComida();
        dragoncito.comer();
        dragoncito.volar();
        System.out.println("------------------------------------------");      
        
        Tigre sandokan = new Tigre("Sandokan", 150.5f);
        
        System.out.println("¿Que mama el gato? " + micifuz.mamar(sandokan));
        System.out.println("¿Que mama el tigre? " + sandokan.mamar(micifuz));
    }
    
}
