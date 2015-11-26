/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gui.MainFrame;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import model.Aspirante;
import model.AspiranteModel;
import model.Database;
import model.Escuela;

/**
 *
 * @author ruben
 */
public class Controller {
    private Database db = new Database();
    private MainFrame mainFrame;
    
    public void Controller(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }
    
    public void llenarComboEscuelas(JComboBox escuelaAspirante){
        ArrayList<Escuela> lista = null;
        try {    
            lista = db.leerEscuelas();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        for (int i = 0; i < lista.size(); i++) {
            escuelaAspirante.addItem(lista.get(i));
        }
    }
    
    public void guardarAspirante(String nombre, String telefono, String email, int id_escuela){
        //int id_escuela = escuela.getId();
        
        Aspirante aspirante = new Aspirante(-1, nombre, telefono, email, "face", id_escuela);
        
        try {
            db.guardarAspirante(aspirante);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void cargarTablaAspirantes(JTable tabla){
        AspiranteModel model = null;
        ArrayList<Aspirante> listaEscuelas = null;
        
        try {
            listaEscuelas = db.seleccionarAspirantes();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        model = new AspiranteModel(listaEscuelas);
        
        
        tabla.setModel(model);
    }
}
