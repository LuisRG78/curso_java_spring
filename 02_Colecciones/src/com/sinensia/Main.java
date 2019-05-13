/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia;

import static com.sinensia.dao.probandoDAO.probarCliente;
import static com.sinensia.dao.probandoDAO.probarProducto;
import com.sinensia.genericos.ProbandoGenericos;
import com.sinensia.pruebas.Colecciones;
import com.sinensia.pruebas.Fechas;
import static com.sinensia.pruebas.Herencia.probandoHerencia;
import com.sinensia.pruebas.Polimorfismo;
import com.sinensia.poo_avanzado.ProbandoAnimales;

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
        probarCliente();
        //probarProducto();
    }   
}