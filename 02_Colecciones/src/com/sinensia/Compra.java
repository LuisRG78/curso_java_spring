/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Compra extends Entidad{
    
    private Date fecha;
    private int cantidad;

    public Compra(Date fecha, int cantidad, long id) {
        super(id);
        this.fecha = fecha;
        this.cantidad = cantidad;
    }
    
    
    
    
}
