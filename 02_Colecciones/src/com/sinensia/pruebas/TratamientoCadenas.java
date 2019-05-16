/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.pruebas;

/**
 *
 * @author Admin
 */
public class TratamientoCadenas {
    public static void pruebasString(){
        String quijote = "En un lugar de la Mancha...";
        if(quijote.contains("Mancha")){
            System.out.println("Contiene Mancha");
        }
        if(quijote.contains("manCHa")){
            System.out.println("Contiene manCHa");
        }else{
            System.out.println("No contiene manCHA");
        }
        
        if(quijote.toLowerCase().contains("manCHa".toLowerCase())){
            System.out.println("Contiene manCHa - versión minúsculas");
        }else{
            System.out.println("No contiene manCHA");
        }
        
        if(quijote.startsWith("En un lugar")){
            System.out.println("Comienza con 'En un lugar'");
        }
        
        if(quijote.endsWith("la Mancha...")){
            System.out.println("Termina con 'la Mancha...'");
        }
        System.out.println("charAt(6) = " + quijote.charAt(6) );
        //String.f
        System.out.println(String.format("El texo '%s' tiene '%d' caracteres", quijote, quijote.length()));
        
        System.out.println(String.format("%f, %.2f €, %.3f, %.0f", 1.1f, 2.2f, 3.3f, 4.4f));
        
        System.out.println("Mancha está en la posición " + quijote.indexOf("Mancha"));
        
        if (!quijote.isEmpty()) {
            System.out.println("quijote NO está vacía"); 
        }
        
        System.out.println("La última 'a' está en la posición " + quijote.lastIndexOf('a'));
        
        System.out.println("Trozo cadena: " + quijote.substring(15, 22));
        
        String[] palabras = quijote.split(" ");
        for (String palabra: palabras) {
            System.out.println("Palabra: " + palabra);
        }
        
        String strCsv = "Luismi, 66655544, Calle Rue del Percebe, Alumno";
        for (String dato: strCsv.split(",")) {
            System.out.println("Dato: " + dato.trim());
        }
    }
    
}
