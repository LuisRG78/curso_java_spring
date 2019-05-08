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
public class ClienteVip extends Cliente{
    
    private String beneficios;

    public ClienteVip(long cliente_id, String nombre, String email) {
        super(cliente_id, nombre, email);
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }
    
    
    
}
