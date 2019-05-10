/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.pruebas;

import com.sinensia.FechaDayMonthYear;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Fechas {
    
    public static void probar(){
        FechaDayMonthYear fecha = new FechaDayMonthYear();
        fecha.set(2019, 4, 9);
        System.out.println("Fecha: " + fecha.getTime());
        Date fechaDate = fecha.getTime();
        System.out.println("Fecha: " + fechaDate.toString());
        
        FechaDayMonthYear miCumple = new FechaDayMonthYear(2019, 4, 8);
        
        if(miCumple.equals(fecha)){
            System.out.println("Felicidades!!");
        }
        else if (miCumple.before(fecha)){
            System.out.println("Ya cumpliste");
        }
        else if (miCumple.after(fecha)){
            System.out.println("Aún no es tu cumple");
        }
    }
}
