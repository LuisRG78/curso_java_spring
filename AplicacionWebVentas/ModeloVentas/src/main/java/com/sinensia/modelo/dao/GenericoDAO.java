/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.modelo.dao;


import com.sinensia.modelo.Entidad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 * @param <T>
 */
public class GenericoDAO<T extends Entidad> implements InterfazDAO<T>{
    
    HashMap<Long, T> mapa;
    
    public GenericoDAO(){
        mapa = new HashMap<>();
    }
    
    //Método que añade un genérico al mapa
    
    public void poner(T gen){
        if (gen == null){
            System.err.println("No se pueden añadir nulos");
        }else{
            mapa.put(gen.getId(), gen);
        }
    }
    
    //método que devuelve un genérico pasándole el id
    public T leerUno(long id){
        if(mapa.containsKey(id)){
            return mapa.get(id);
        }
        System.err.println("Clave/Id no encontrada");
        return null;
    }
     @Override
    public List<T> leerTodos() {
        ArrayList<T> listaGenericos = new ArrayList<T>();
        for (Map.Entry<Long, T> entrada : mapa.entrySet()){        
            listaGenericos.add(entrada.getValue());           
        }
        return listaGenericos;
    }
    
    @Override
    public void eliminar(T gen){
        mapa.remove(gen.getId());
    }
    
    @Override
    public void eliminar(long id){
        mapa.remove(id);
    }

    @Override
    public void modificar(T nuevoValor) {
        mapa.replace(nuevoValor.getId(), nuevoValor);
        
    }
}
