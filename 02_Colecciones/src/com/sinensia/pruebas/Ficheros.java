/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.pruebas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Ficheros {
    
    public static void probarEscritura() throws IOException{
        String[] lineasTexto = {
        "Linea primera",
        "Linea segunda",
        "Linea tercera"
        };
        
        FileWriter fichero = null;
        try{
            //inicializamos el fichero
            //Si no ponemos nada o false, machacamos el fichero
            //Si ponemos true, se va a añadir al final del fichero
            fichero = new FileWriter("fichero_texto.txt", false);
            //lo recorremos y vamos añadiendo saltos de linea en cada linea
            for(int i = 0; i <10; i++){   
                for(String linea : lineasTexto){
                        fichero.write(linea + "\n");
                }
            }
            fichero.write("FIN DEL FICHERO" + "\r\n");
            //fichero.close();
            System.out.println("Fichero " + fichero.getClass().getName());
        }catch(Exception ex){
            System.err.println("Mensaje error: " + ex.getMessage());
        }finally{
            try{
                fichero.close();
                System.out.println("Fichero cerrado");
            }catch(IOException ex){
                Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void escrituraStream(){
        String[] lineasTexto = {
        "Linea primera",
        "Linea segunda",
        "Linea tercera"
        };
        
        Writer out = null;
        
        try{
            FileOutputStream streamFich = new FileOutputStream("fich_2.txt");
            OutputStreamWriter streamWriter = new OutputStreamWriter(streamFich, "UTF-8");
            //Lo mismo en una sola línea
            //OutputStreamWriter streamWriter = new OutputStreamWriter(new FileOutputStream("fich_2.txt"),"UTF-8");
            out = new BufferedWriter(streamWriter);
            
            for (String linea : lineasTexto) {
                try{
                    out.write(linea + "\r\n");
                }catch(IOException ex){
                    System.err.println("Error al escribir fich: " + ex.getMessage());
                }
            }
        }catch(UnsupportedEncodingException | FileNotFoundException ex2){
            System.out.println("Error 2. " + ex2.getMessage());
        }finally{
            try{
                out.close();
            }catch(IOException ex3){
                System.err.println("Error en cierre fich: " + ex3.getMessage());
            }
        }
    }
    
    public static void lecturaFich(){
        //File fichFormWin = new File("C:\\Users\\Admin\\desktop\\curso_java_spring.git\\02_Colecciones");
        //File fichero = new File("C:/Users/Admin/desktop/curso_java_spring.git/02_Colecciones");
        File fichRutaRelativa = new File("fichero_texto.txt");
        //Un scanner es capaz de leer datos y formatearlos de alguna manera
        Scanner s = null;
        try{
            System.out.println("leyendo fich");
            s = new Scanner(fichRutaRelativa);
            while(s.hasNext()){//Hasta el siguiente \n
                String linea = s.nextLine();
                System.out.println(">>>>>>> \"" + linea + "\"");
                if(linea.compareTo("Linea segunda") < 0){
                    System.out.println("     es menor");
                }else if(linea.compareTo("Linea segunda") > 0){
                    System.out.println("      es mayor");
                }else{
                    System.out.println("     son iguales");
                }
            }
        }catch(Exception ex){
            System.err.println("Mnesaje: " + ex.getMessage());
        }finally{
            try{
                if(s != null){
                    s.close();
                }
            }catch(Exception ex2){
                System.err.println("Mensaje al cerrar: " + ex2.getMessage());
            }
        }
        
    }
    
}
