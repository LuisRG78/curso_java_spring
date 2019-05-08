/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg02_colecciones;

import java.util.GregorianCalendar;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class ProbandoFechas {
    
    public static void probar(){
        FechaDayMonthYear fecha = new FechaDayMonthYear(2019, 4, 8);
        //;
        System.out.println("Fecha: " + fecha.getTime());
        Date fechaDate = fecha.getTime();
        System.out.println("Fecha: " + fechaDate.toString());
        
        FechaDayMonthYear miCumple = new FechaDayMonthYear(2019, 4, 8);
       
        if(miCumple.getTimeWithoutSeconds().after(fecha.getTimeWithoutSeconds())){
            System.out.println("Aun no es tu cumple");
        }else if (miCumple.getTimeWithoutSeconds().before(fecha.getTimeWithoutSeconds())){
            System.out.println("Ya cumpliste");
        }else if (miCumple.compareTo(fechaDate)){
            System.out.println("Felicidades!!");
        }
    }
    
}
