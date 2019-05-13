/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.dao;

import com.sinensia.Cliente;
import com.sinensia.Producto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class ProductoDAO implements InterfazDAO<Producto>{
    
    HashMap<Long, Producto> mapa;
    
    public ProductoDAO(){
        mapa = new HashMap<>();
    }    
    
    //Método que añade un producto al mapa
    @Override
    public void poner(Producto prod){
        if (prod == null){
            System.err.println("No se pueden añadir nulos");
        }else{
            mapa.put(prod.getId(), prod);
        }
    }
    
    //Método que devuelve un producto pasándole el id
    @Override
    public Producto leerUno(long id) {
        if(mapa.containsKey(id)){
            return mapa.get(id);
        }
        System.err.println("Clave/Id no encontrada");
        return null;
    }
    
    //Método que devuelve un arrayList de productos
    @Override
    public List leerTodos() {
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        for (Map.Entry<Long, Producto> entrada : mapa.entrySet()){        
            listaProductos.add(entrada.getValue());           
        }
        return listaProductos;
    }

    @Override
    public void eliminar(Producto prod) {
        mapa.remove(prod.getId());
    }

    @Override
    public void eliminar(long id) {
        mapa.remove(id);
    }
    
    @Override
    public void modificar(Producto valor) {
        for (Map.Entry<Long, Producto> entrada : mapa.entrySet()){        
            if(entrada.getKey() == valor.getId()){
                //entrada.setValue(valor);
                mapa.put(valor.getId(), valor);
            }            
        }
    }

    
}
