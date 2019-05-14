/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.dao;

import com.sinensia.Cliente;
import com.sinensia.ClienteInvitado;
import com.sinensia.Producto;

/**
 *
 * @author Admin
 */
public class ProbandoDAO {
    
    public static void probarCliente(){
        GenericoDAO repoCli = new GenericoDAO();
        Cliente teVoyAcambiar = new Cliente(4, "Peter", "aaa@aaa.com");
        repoCli.poner(new Cliente(1, "Ana", "aaa@aaa.com"));
        repoCli.poner(new ClienteInvitado(2, "Juan", "juan@aaa.com"));
        repoCli.poner(new ClienteInvitado(3, "Bea", "bea@aaa.com"));
        
        System.out.println("Leo el cliente con el id 2 y muestro los 3 clientes");
        System.out.println("Juan: " + repoCli.leerUno(2));
        System.out.println("Todos " + repoCli.leerTodos());
        
        System.out.println("\nAñado el cliente 4 y muestro los 4 clientes");
        repoCli.poner(teVoyAcambiar);
        System.out.println("Todos " + repoCli.leerTodos());
        
        System.out.println("\nModifico el cliente con el id 2 y lo muestro");
        repoCli.modificar(new Cliente(2, "cambiado", "cambio@gmail.com"));
        System.out.println("Juan: " + repoCli.leerUno(2));
        System.out.println("Todos " + repoCli.leerTodos());
        
        System.out.println("\nElimino el cliente con el id 1 y muestro los clientes");
        repoCli.eliminar(1);
        System.out.println("Todos " + repoCli.leerTodos());
        
        System.out.println("\nElimino el cliente tevoyAcambiar");
        repoCli.eliminar(teVoyAcambiar);
        System.out.println("Todos " + repoCli.leerTodos());
    }
    
    public static void probarProducto(){
        System.out.println("\n----------PRODUCTOS --------------\n");
        
        ProductoDAO repoProd = new ProductoDAO();
        Producto teVoyAcambiar = new Producto(4, "Silla", 85.5, 6);
        repoProd.poner(new Producto(1, "Mesa blanca", 120.6, 8));
        repoProd.poner(new Producto(2, "Estantería billy", 65.7, 4));
        repoProd.poner(new Producto(3, "Lámpara de pie", 45.4));
        
        System.out.println("Leo el producto con el id 2 y muestro los 3 productos");
        System.out.println("Prodcuto: " + repoProd.leerUno(2));
        System.out.println("Todos los productos: " + repoProd.leerTodos());
        
        System.out.println("\nAñado el producto 4 y muestro los 4 productos");
        repoProd.poner(teVoyAcambiar);
        System.out.println("Todos los productos: " + repoProd.leerTodos());
        
        System.out.println("\nModifico el producto con el id 2 y lo muestro");
        repoProd.modificar(new Producto(2, "Estantería de 6 baldas", 48.6, 12));
        System.out.println("Producto: " + repoProd.leerUno(2));
        System.out.println("Todos los productos: " + repoProd.leerTodos());
        
        System.out.println("\nElimino el producto con el id 1 y muestro los productos");
        repoProd.eliminar(1);
        System.out.println("Todos los productos:" + repoProd.leerTodos());
        
        System.out.println("\nElimino el producto tevoyAcambiar");
        repoProd.eliminar(teVoyAcambiar);
        System.out.println("Todos los productos: " + repoProd.leerTodos());
    }
    
}
