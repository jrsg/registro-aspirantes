/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Database {
    private Connection connection;
    private final String DB_NAME = "";
    private final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
    private final String BD_USER = "root";
    private final String DB_PASSWORD = "";
    
    public void connect() throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        connection = DriverManager.getConnection(DB_URL, BD_USER, DB_PASSWORD);
    }
    
    public void disconnect() throws SQLException{
        if(connection != null){
            connection.close();
        }
    }   
    
    //Retorna el listado de escuelas
    public ArrayList leerEscuelas() throws SQLException{
                
        return null;
    }
    
    //Retorna el nombre de la escuela por ID
    public String leerNombreEscuela(int id_escuela) throws SQLException{
        
        return "";        
    }
    
    //Guarda nueva escuela
    public void guardarEscuela(Escuela escuela) throws SQLException{
        
    }
    
    //Retorna el listado de aspirantes
    public ArrayList leerAspirantes() throws SQLException{
               
        return null;        
    }
    
    //Guarda los datos de un aspirante
    public void guardarAspirante(Aspirante aspirante) throws SQLException{
        
    }
    
    //Eliminar un aspirante por ID
    public void eliminaAspirante(int id_aspirante) throws SQLException{
        
    }    
}