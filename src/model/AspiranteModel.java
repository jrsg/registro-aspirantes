/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ruben
 */
public class AspiranteModel extends AbstractTableModel{
    private Database db = new Database();
    private ArrayList<Aspirante> data;
    private String[] columns = {
      "Nombre",
      "Escuela",
      "Telefono",
      "E-mail",
      "Facebook"
    };
    
    public AspiranteModel(ArrayList<Aspirante> data){
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aspirante aspirante = data.get(rowIndex);
        switch(columnIndex){
            case 0:
                return aspirante.getNombre();
            case 1:
                int id_escuela = aspirante.getId_escuela();
                String escuela = "";
                
                try {
                    escuela = db.leearNombreEscuela(id_escuela);
                } catch (SQLException ex) {
                    Logger.getLogger(AspiranteModel.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                return escuela;
            case 2:
                return aspirante.getTelefono();
            case 3:
                return aspirante.getEmail();
            case 4:
                return aspirante.getFacebook();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    public Aspirante getAspirante(int row) {
        return data.get(row);
    }
    
    public void agregar(Aspirante aspirante){
        data.add(aspirante);
        fireTableDataChanged();
    }
    
    public int eliminar(int row){
        int id = data.get(row).getId();
        data.remove(row);
        fireTableDataChanged();
        
        return id;
    }
}