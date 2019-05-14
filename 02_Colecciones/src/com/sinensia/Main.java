/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia;

import com.sinensia.dao.ProbandoDAO;
import com.sinensia.genericos.ProbandoGenericos;
import com.sinensia.pruebas.Colecciones;
import com.sinensia.pruebas.Fechas;
import static com.sinensia.pruebas.Herencia.probandoHerencia;
import com.sinensia.pruebas.Polimorfismo;
import com.sinensia.poo_avanzado.ProbandoAnimales;
import com.sinensia.pruebas.Ficheros;
import static com.sinensia.pruebas.TratamientoCadenas.pruebasString;

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Colecciones.ejemploHashMap();
        //Colecciones.ejemploListas();
        //Fechas.probar();
        //Herencia.probandoHerencia();
        //Polimorfismo.polimorfeando();
        //Polimorfismo.polimorfeandoConListas();
        //Polimorfismo.polimorfeandoConArrays();
        //Polimorfismo.polimorfeandoConHashMap();
        //Colecciones.ejemploSet();
        //Polimorfismo.polimorfeandoConTreeMap();
        //ProbandoAnimales.probarClasesAbstractas();
        //ProbandoGenericos.probarMetodo();
        //ProbandoDAO.probarCliente();
        //ProbandoDAO.probarProducto();
        try{
            //Ficheros.probarEscritura();
        }catch(Exception ex){
            System.err.println("");
        }
         //Ficheros.escrituraStream();
         //Ficheros.lecturaFich();
         //Colecciones.comparaciones();
         //pruebasString();
    }  
    
}