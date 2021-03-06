/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sinensia;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Admin - German
 */
//para ser un Bean debe implementar Serializable
@Entity
public class Producto implements Serializable{   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //Para indicar que es autoincrementable
	private Integer id;
    private String nombre;
    private double precio;
    private int cantidad;
    
    
    
    public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto(String nombre, double precio, int cantidad) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public Producto(Integer id, String nombre, double precio, int cantidad) {
        this.id = id;
    	this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
	public Integer getId() {
		return id;
	}

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
  
}
