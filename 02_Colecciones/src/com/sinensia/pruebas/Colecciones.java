/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.pruebas;

import com.sinensia.Cliente;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Date;
import java.util.TreeMap;

/**
 *
 * @author Admin
 */
public class Colecciones {
    
    public static void ejemploHashMap(){
        HashMap<String, Cliente> diccClientes;
        diccClientes = new HashMap<String, Cliente>();
        Cliente ana = new Cliente(1, "Ana", null);
        Cliente luis = new Cliente(2, "Luis", null);
        Cliente bea = new Cliente(3, "Bea", null);
        
        diccClientes.put("b2", luis);
        diccClientes.put("a1", ana);
        diccClientes.put("c3", bea);
        
        System.out.println("Bea? " + diccClientes.get("c3").getNombre());
        
        if(diccClientes.containsKey("c3")){
            diccClientes.put("c3", new Cliente(4, "Pedro", null));
        }
        
        System.out.println("Bea? " + diccClientes.get("c3").getNombre());
        
        for (Map.Entry<String, Cliente> parClaveValor : diccClientes.entrySet()){
            System.out.println("Cliente " + parClaveValor.getKey());
            Cliente cliente = parClaveValor.getValue();
            System.out.println(" Nombre " + cliente.getNombre());
        }
        
        diccClientes.put("d4", new Cliente(7,"Fulano", "fff@fff.com"));
        Map<Date, Cliente> mapClientesFecha = new TreeMap<Date, Cliente>();
        mapClientesFecha.put(new Date(1982, 4, 9), luis);
        mapClientesFecha.put(new Date(1981, 4, 9), new Cliente(7,"Fulano", "fff@fff.com"));
        mapClientesFecha.put(new Date(1982, 9, 19), new Cliente(8,"Mengano", "mengano@fff.com"));
        mapClientesFecha.put(new Date(1980, 7, 10), diccClientes.get("c3"));
        System.out.println("\n\n************** Mapa ordenado por fecha ****************\n");
        
        for(Map.Entry<Date, Cliente> entrada : mapClientesFecha.entrySet()){
            System.out.println("\nCliente\n- Clave: " + entrada.getKey());
            Cliente cli = entrada.getValue();
            System.out.println("- Valor: " + cli.toString());
        }
        
    }
    
    public static void ejemploSet(){
        HashSet<Cliente> conjuntoClientes;
        conjuntoClientes = new HashSet<Cliente>();
        Cliente ana = new Cliente(1, "Ana", null);
        Cliente luis = new Cliente(2, "Luis", null);
        Cliente bea = new Cliente(3, "Bea", null);
        conjuntoClientes.add(ana);
        conjuntoClientes.add(ana);
        conjuntoClientes.add(luis);
        conjuntoClientes.add(bea);
        
        System.out.println("\nMostrar clientes con HashSet - bucle foreach:");
        for(Cliente cli : conjuntoClientes){
            cli.mostrar();
        }
        
        System.out.println("\nMostrar clientes con HashSet - Iterator:");
        Iterator<Cliente> it = conjuntoClientes.iterator();
        while(it.hasNext()){
            Cliente cli = it.next();
            cli.mostrar();            
        }
    }
    
    public static void ejemploListas(){
        ArrayList<Cliente> listaClientes = new ArrayList();
    
        listaClientes.add(new Cliente(1, "Juan", "juan@gmail.com"));
        listaClientes.add(new Cliente(2, "Jose", "jose@gmail.com"));
        listaClientes.add(new Cliente(3, "María", "maria@gmail.com"));
        listaClientes.add(new Cliente(3, "Bea", null));
        
        listaClientes.remove(2);
        Cliente maria = listaClientes.get(2);
        maria.setEmail("bea@gmail.com");
        
        for (int i=0; i < listaClientes.size(); i++){
            Cliente cliente = listaClientes.get(i);
            System.out.println("Cliente " + cliente.getId() + 
                    "--> Nombre: " + cliente.getNombre() + 
                     ", Email: " + cliente.getEmail());
        }
        
        for (Cliente cliente : listaClientes) {
            System.out.println("Cliente: " + cliente.getNombre());
        }
    }
    
    public static void comparaciones(){
        Cliente luis = new Cliente(2, "Luis", null);
        Cliente bea = new Cliente(3, "Bea", null);
        if(bea.compareTo(luis) < 0){
            System.out.println("Bea es menor que Luis");
        }else if(bea.compareTo(luis) == 0){
            System.out.println("Bea es igual que Luis");
        }else if(bea.compareTo(luis) > 0){
            System.out.println("Bea es mayor que Luis");
        }
    }
    
}
