/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia;

/**
 *
 * @author Admin
 */
public class Producto {
    
    private long prod_id;
    private String nombre_prod;
    private double precio;
    private int stock;

    public Producto(long prod_id, String nombre_prod, double precio) {
        this.prod_id = prod_id;
        this.nombre_prod = nombre_prod;
        if(nombre_prod == null || nombre_prod == ""){
            //throw new Exception("Nombre de Cliente inválido");
            System.err.println("Nombre de cliente inválido");
        }
        this.precio = precio;
        this.stock = 0;
    }
    
    public Producto(long prod_id, String nombre_prod, double precio, int stock) {
        this.prod_id = prod_id;
        this.nombre_prod = nombre_prod;
        if(nombre_prod == null || nombre_prod == ""){
            //throw new Exception("Nombre de Cliente inválido");
            System.err.println("Nombre de cliente inválido");
        }
        this.precio = precio;
        this.stock = stock;
    }
    
    public long getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public String getNombre_prod() {
        return nombre_prod;
    }

    public void setNombre_prod(String nombre_prod) {
        this.nombre_prod = nombre_prod;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public void mostrar(){
        System.out.println("Producto: " + nombre_prod);
        System.out.println(" Id: " + this.prod_id);
        System.out.println(" Precio: " + this.getPrecio());
        System.out.println(" Stock: " + stock);
    }

    @Override
    public String toString() {
        //return super.toString(); //To change body of generated methods, choose Tools | Templates.
        return "Producto [" + prod_id + ", " + nombre_prod + ", " + precio + ", " + stock + "]";
    }     
}
