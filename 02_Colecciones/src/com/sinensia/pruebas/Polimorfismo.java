/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.pruebas;

import com.sinensia.ClienteInvitado;
import com.sinensia.ClienteVip;
import com.sinensia.Cliente;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Admin
 */
public class Polimorfismo {
    
    public static ArrayList<Cliente> clientes;
    
    public static void polimorfeando(){
        ClienteInvitado invitado = new ClienteInvitado(100, "Ronaldinho", null);
        invitado.setDuracionMax(25);
        invitado.mostrar();
        
        //Este es un obj de tipo clienteInvitado con la forma de Cliente
        Cliente clienteNormal = invitado; //Conversión implícita: se guarda un hijo en una referencia del padre
        clienteNormal.mostrar();
        //System.out.println("Cliente Normal: " + clienteNormal.getNombre());
      
        ClienteInvitado elMismoInv = (ClienteInvitado) clienteNormal; 
        //Volvemos a cambiar la referencia del objeto tipo clienteInvitado, que ahora estaba con una referencia tipo Cliente,
        //a una referencia tipo cliente invitado.Hay que forzar la conversión explícita con un CAST
        //Ahora podemos volver a acceder al metodo getDuracionMax(), ya que el objeto es de tipo clienteInvitado
        //System.out.println("Cliente Normal vuelve a invitado: " + elMismoInv.getNombre() + ", Duración max: " + elMismoInv.getDuracionMax());
        
        Cliente normal = new Cliente(5, "", null);
        //ClienteInvitado normalEnInvitado = (ClienteInvitado) normal; //Da error en el cast
        //No se puede guardar un objeto padre en una referencia de la clase hija
        //System.out.println("Cliente NormalEnInvitado: " + normalEnInvitado.getNombre());
        ClienteVip vip = new ClienteVip(3, "Messi", null);
        vip.setBeneficios("Todos los partidos del Madrid gratis");
        vip.mostrar();
    }
    
    public static void polimorfeandoConListas(){
        clientes = new ArrayList<Cliente>();
        clientes.add(new Cliente(0, "Pepe", null));
        clientes.add(new ClienteInvitado(1, "Juan", null));
        clientes.add(new ClienteVip(2, "Federico", null));
        clientes.add(new Cliente(3, "Witerico", null));
        clientes.add(new ClienteInvitado(4, "Leovigildo", null));
        clientes.add(new ClienteVip(5, "Clotilde", null));
        
        System.out.println("Mostrando con ArrayList");
        for (Cliente cliente : clientes){
            cliente.mostrar();
        }
    }

    public static void polimorfeandoConArrays(){
        Cliente[] arrayClientes = new Cliente[6];
        arrayClientes[0] = new Cliente(0, "Pepe", null);
        arrayClientes[1] = new ClienteInvitado(1, "Juan", null);
        arrayClientes[2] = new ClienteVip(2, "Federico", null);
        arrayClientes[3] = new Cliente(3, "Witerico", null);
        arrayClientes[4] = new ClienteInvitado(4, "Leovigildo", null);
        arrayClientes[5] = new ClienteVip(5, "Clotilde", null);
        
        System.out.println("\nMostrando con Array");
        for(int i = 0;i< arrayClientes.length;i++){
            arrayClientes[i].mostrar();
        }
    }

    public static void polimorfeandoConHashMap(){
        
        HashMap<String, Cliente> listadoClientes = new HashMap<String, Cliente>();
        /*
        listadoClientes.put("Primero", new Cliente(0, "pepe", null));
        listadoClientes.put("Segundo", new ClienteInvitado(1, "Juan", null));
        listadoClientes.put("Tercero", new ClienteVip(2, "federico", null));
        listadoClientes.put("Cuarto", new Cliente(3, "Witerico", null));
        listadoClientes.put("Quinto", new ClienteInvitado(4, "Leovigildo", null));
        listadoClientes.put("Sexto", new ClienteVip(5, "Clotilde", null));
        
        System.out.println("\nMostrasndo con HashMap");
        for(String i : listadoClientes.keySet()){
            System.out.println("Cliente " + i + ": " + listadoClientes.get(i).getNombre() +
                    " email: " + listadoClientes.get(i).getEmail());
        }
        */
        //añado clientes al HashMap
        for(Cliente cliente: clientes){
            listadoClientes.put(cliente.getNombre() + "-" + cliente.getCliente_id(), cliente);
        }
        
        //recorro el HashMap
        System.out.println("\nMostrasndo con HashMap");
        for(Map.Entry<String, Cliente> entradaCliente : listadoClientes.entrySet()){
            String clave = entradaCliente.getKey();
            System.out.println("Clave: " + clave);
            Cliente valor = entradaCliente.getValue();
            valor.mostrar();
        }
        
        listadoClientes.get("Leovigildo-4").setNombre("JanderClander");
        listadoClientes.get("Pepe-0").setEmail("pepote@gmail.com");
        listadoClientes.get("Juan-1").setActivo(true);
        listadoClientes.get("Witerico-3").setEmail("witerico@reyesgodos.com");
        
        Cliente cliInvi = listadoClientes.get("Leovigildo-4");
        if(cliInvi instanceof ClienteInvitado){
            ((ClienteInvitado) cliInvi).setDuracionMax(((ClienteInvitado) cliInvi).getDuracionMax() + 5);
        }
       
        
        System.out.println("\nMostrasndo con HashMap la lista modificada:");
        for(Map.Entry<String, Cliente> entradaCliente : listadoClientes.entrySet()){
            String clave = entradaCliente.getKey();
            System.out.println("Clave: " + clave);
            Cliente valor = entradaCliente.getValue();
            if (valor instanceof ClienteInvitado){
               ((ClienteInvitado) valor).setDuracionMax(((ClienteInvitado) valor).getDuracionMax() + 10);
            } else if(valor instanceof ClienteVip){
                ((ClienteVip) valor).setBeneficios("Envío gratuito a partir de 40 €");
            }
            valor.mostrar();
        }
        
    }
    
    public static void polimorfeandoConTreeMap(){
        TreeMap<String, Cliente> listadoClientes = new TreeMap<String, Cliente>();
      
        //añado clientes al TreeMap
        for(Cliente cliente: clientes){
            listadoClientes.put(cliente.getNombre() + "-" + cliente.getCliente_id(), cliente);
        }
        
        //recorro el TreeMap
        System.out.println("\nMostrando con TreeMap");
        for(Map.Entry<String, Cliente> entradaCliente : listadoClientes.entrySet()){
            String clave = entradaCliente.getKey();
            System.out.println("Clave: " + clave);
            Cliente valor = entradaCliente.getValue();
            valor.mostrar();
        }
        
        listadoClientes.get("Pepe-0").setEmail("pepote@gmail.com");
        listadoClientes.get("Juan-1").setActivo(true);
        listadoClientes.get("Witerico-3").setEmail("witerico@reyesgodos.com");
        
        Cliente cliInvi = listadoClientes.get("Leovigildo-4");
        if(cliInvi instanceof ClienteInvitado){
            ((ClienteInvitado) cliInvi).setDuracionMax(((ClienteInvitado) cliInvi).getDuracionMax() + 5);
        }
              
        System.out.println("\nMostrasndo con TreeMap la lista ordenada por Clave:");
        for(Map.Entry<String, Cliente> entradaCliente : listadoClientes.entrySet()){
            String clave = entradaCliente.getKey();
            System.out.println("Clave: " + clave);
            Cliente valor = entradaCliente.getValue();
            if (valor instanceof ClienteInvitado){
               ((ClienteInvitado) valor).setDuracionMax(((ClienteInvitado) valor).getDuracionMax() + 10);
            } else if(valor instanceof ClienteVip){
                ((ClienteVip) valor).setBeneficios("Envío gratuito a partir de 40 €");
            }
            valor.mostrar();
        }
    }    
}
