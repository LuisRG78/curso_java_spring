/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg02_colecciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ejemploHashMap();
        ejemploListas();
        ProbandoFechas.probar();
        probandoHerencia();
    }
    
    static void ejemploHashMap(){
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
        
    }
    
    static void ejemploListas(){
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
            System.out.println("Cliente " + cliente.getCliente_id() + 
                    "--> Nombre: " + cliente.getNombre() + 
                     ", Email: " + cliente.getEmail());
        }
        
        for (Cliente cliente : listaClientes) {
            System.out.println("Cliente: " + cliente.getNombre());
        }
    }
    
    public static void probandoHerencia(){
        ClienteInvitado cliInv = new ClienteInvitado(0, "Messi", null);
        cliInv.setDuracionMax(10);
        System.out.println("Cliente Invitado: " + cliInv.getNombre() +
                " Duración: " + cliInv.getDuracionMax());
        
        ClienteVip vip = new ClienteVip(1, "Cristiano Ronaldo", "estoyForrao@gmail.com");
        vip.setBeneficios("Te cerramos la tienda para tí solo");
        
        System.out.println("Cliente VIP: " + vip.getNombre() + ", Beneficio: " +
                vip.getBeneficios());
    }
    
}
