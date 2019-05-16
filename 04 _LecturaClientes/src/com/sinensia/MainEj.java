/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class MainEj {

    /**
     * @param args the command line arguments
     */
    
    static Cliente parsearCliente(String linea){
        String[] campos = linea.split(",");
        Cliente cliente = null;
        if(campos.length == 4 || campos.length == 5){
            long id = Integer.parseInt(campos[0]);
            String nombre = campos[1];
            String email = campos[2];
            boolean activo = campos[3].equals("true");
            int duracionMax = 0;
            if(campos.length == 5){
                duracionMax = Integer.parseInt(campos[4]);
                cliente = new ClienteInvitado(id, nombre, email);
                ((ClienteInvitado) cliente).setDuracionMax(duracionMax);
            }else{
                cliente = new Cliente(id, nombre, email);
            }
            cliente.setActivo(activo);
        }
        return cliente;
    }
    
    
    public static void main(String[] args) {
               
        HashMap<Long, Cliente> mapaDat = new HashMap();
        
        File fichRutaRelativa = new File("../Ejercicio_ficheros.txt");
        //Un scanner es capaz de leer datos y formatearlos de alguna manera
        Scanner s = null;
        
        try{
            System.out.println("leyendo fichero");
            s = new Scanner(fichRutaRelativa);                          
            while(s.hasNextLine()){//Hasta el siguiente \n
                String linea = s.nextLine();
                System.out.println(">>>>>>> \"" + linea + "\"");
                try{
                    Cliente cliente = parsearCliente(linea);
                    mapaDat.put(cliente.getId(), cliente);               
                }catch(Exception ex){
                    System.err.println("Error en parseo: " + ex.getMessage());
                }
            }
            for (Map.Entry<Long, Cliente> ent : mapaDat.entrySet()) {
                System.out.println("Cli: " + ent.getValue().toString());
            }               
        } catch (Exception ex) {
            System.err.println("Mensaje: " + ex.getMessage());
        } finally {
            try {
                if (s != null) {
                    s.close();
                }
            } catch (Exception ex2) {
                System.err.println("Mensaje al cerrar: " + ex2.getMessage());
            }
        }
    }
    
}
