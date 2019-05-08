/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg02_colecciones;

/**
 *
 * @author Admin
 */
public class PruebasHerencia {
    
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
