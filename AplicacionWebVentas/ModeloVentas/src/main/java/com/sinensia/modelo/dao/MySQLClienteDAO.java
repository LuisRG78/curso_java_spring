package com.sinensia.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.sinensia.modelo.Cliente;
import java.sql.PreparedStatement;

/**
 *
 * @author Admin
 */
public class MySQLClienteDAO {
    public MySQLClienteDAO(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        }catch(SQLException ex){
            Logger.getLogger(MySQLClienteDAO.class.getName()).log(Level.SEVERE, "Error SQL", ex);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(MySQLClienteDAO.class.getName()).log(Level.SEVERE, "Error en la clase", ex);
        }catch(Exception ex){
            Logger.getLogger(MySQLClienteDAO.class.getName()).log(Level.SEVERE, "Otro error", ex);
        }
    }
    
    public boolean crear(String nombre, String email, String passwd, int edad, boolean activo){
        try (Connection conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_ventas?user=Admin1234&password=Admin1234&useSSL=false&serverTimezone=UTC",
                "Admin1234", "Admin1234")){
            String sqlQuery =
                    "INSERT INTO cliente (nombre, email, password, edad, activo)" 
                    + " VALUES ('" + nombre + "' , '" + email + "' , '" + passwd 
                    + "' , " + edad + " , " + (activo ? "1" : "0") + ")";
            Statement sentencia = conex.createStatement();
            sentencia.executeUpdate(sqlQuery);
            return true;
        } catch (SQLException ex){
          Logger.getLogger(MySQLClienteDAO.class.getName())
                  .log(Level.SEVERE, "Error SQL", ex);
          return false;
        }  
    }
    
    public Cliente insertar(Cliente cliente){
        try(Connection conex = DriverManager.getConnection(Constantes.CONEXION, Constantes.USUARIO, Constantes.PASSWORD)){
            String sqlQuery =
                    "INSERT INTO cliente (nombre, email, password, edad, activo)" 
                    + " VALUES (?, ?, ?, ?, ?)";
            PreparedStatement sentencia = conex.prepareStatement(sqlQuery);
            sentencia.setString(1, cliente.getNombre());
            sentencia.setString(2, cliente.getEmail());
            sentencia.setString(3, cliente.getPassword());
            sentencia.setShort(4, cliente.getEdad());
            sentencia.setShort(5, cliente.getActivo());
            sentencia.executeUpdate();
            return cliente;
        } catch (SQLException ex){
          Logger.getLogger(MySQLClienteDAO.class.getName())
                  .log(Level.SEVERE, "Error SQL", ex);
          return null;
        }  
    
    }
}
