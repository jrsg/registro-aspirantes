/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    private final String DB_URL = "jdbc:mysql://localhost:3306/registro_aspirantes";
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
    
    public ArrayList leerEscuelas() throws SQLException{
        connect();
        
        String selectSQL = "select * from escuelas";
        PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Escuela> lista = new ArrayList<Escuela>();
        
        while(resultSet.next()){
            lista.add(new Escuela(
                    resultSet.getInt(1),
                    resultSet.getString(2)
            ));
        }
        
        disconnect();
        
        return lista;
    }
    
    public String leearNombreEscuela(int id_escuela) throws SQLException{
        connect();
        String selectSQL = "select nombre from escuelas where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
        preparedStatement.setInt(1, id_escuela);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        String escuela = resultSet.getString("nombre");
        disconnect();
        
        return escuela;
        
    }
    
    public ArrayList seleccionarAspirantes() throws SQLException{
        connect();
        
        String selectSQL = "select * from aspirantes";
        PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Aspirante> lista = new ArrayList<Aspirante>();
        
        while(resultSet.next()){
            lista.add(new Aspirante(
                    resultSet.getInt("id"),                    
                    resultSet.getString("nombre"),
                    resultSet.getString("telefono"),
                    resultSet.getString("email"),
                    resultSet.getString("facebook"),
                    resultSet.getInt("id_escuela")
            ));
        }
        
        disconnect();
        
        return lista;
        
    }
    
    public void guardarAspirante(Aspirante aspirante) throws SQLException{
        connect();
        
        PreparedStatement statement = null;
        String sql;
        
        if(aspirante.getId() == -1)
            sql = "insert into aspirantes (id, nombre, id_escuela, telefono, email, facebook, creacion, actualizacion) values (null, ?, ?, ?, ?, ?, NOW(), null)";
        else
            sql = "update empleados set nombre = ?, paterno = ?, materno = ?, telefono = ?, email = ?, actualizacion = NOW() where idempleados = ?";
        
        try {
            statement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        statement.setString(1, aspirante.getNombre());
        statement.setInt(2, aspirante.getId_escuela());
        statement.setString(3, aspirante.getTelefono());
        statement.setString(4, aspirante.getEmail());
        statement.setString(5, aspirante.getFacebook());
        
        /*if(empleado.getId() != -1)
            statement.setInt(6, empleado.getId());*/

        
        statement.executeUpdate();
    }
}