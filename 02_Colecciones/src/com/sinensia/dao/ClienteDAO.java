/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.dao;

import com.sinensia.Cliente;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class ClienteDAO implements InterfazDAO<Cliente>{
    
    HashMap<Long, Cliente> mapa;
    
    public ClienteDAO(){
        mapa = new HashMap<>();
    }
    
    //Método que añade un cliente al mapa
    @Override
    public void poner(Cliente cli){
        if (cli == null){
            System.err.println("No se pueden añadir nulos");
        }else{
            mapa.put(cli.getCliente_id(), cli);
        }
    }
    
    //método que devuelve un cliente pasándole el id
    public Cliente leerUno(long id){
        if(mapa.containsKey(id)){
            return mapa.get(id);
        }
        System.err.println("Clave/Id no encontrada");
        return null;
    }
     @Override
    public List<Cliente> leerTodos() {
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        for (Map.Entry<Long, Cliente> entrada : mapa.entrySet()){        
            listaClientes.add(entrada.getValue());           
        }
        return listaClientes;
    }
    
    @Override
    public void eliminar(Cliente cli){
        mapa.remove(cli.getCliente_id());
    }
    
    @Override
    public void eliminar(long id){
        mapa.remove(id);
    }

    @Override
    public void modificar(Cliente valor) {
        Cliente cli = mapa.get(valor.getCliente_id());
        cli.setActivo(valor.isActivo());
        cli.setEmail(valor.getEmail());
        cli.setNombre(valor.getNombre());
        
     /*   for (Map.Entry<Long, Cliente> entrada : mapa.entrySet()){        
            if(entrada.getKey() == valor.getCliente_id()){
                //entrada.setValue(valor);
                mapa.put(valor.getCliente_id(), valor);
            }            
        }*/
    }
    
}
