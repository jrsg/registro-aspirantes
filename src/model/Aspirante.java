/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Usuario
 */
public class Aspirante {
    private int id, id_escuela;
    private String nombre, telefono, email, facebook;
    
    public Aspirante(int id, String nombre, String telefono, String email, String facebook, int id_escuela){
        setId(id);
        setNombre(nombre);
        setTelefono(telefono);
        setEmail(email);
        setFacebook(facebook);
        setId_escuela(id_escuela);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getTelefono() {
        return this.telefono;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the facebook
     */
    public String getFacebook() {
        return facebook;
    }

    /**
     * @param facebook the facebook to set
     */
    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    /**
     * @return the id_escuela
     */
    public int getId_escuela() {
        return id_escuela;
    }

    /**
     * @param id_escuela the id_escuela to set
     */
    public void setId_escuela(int id_escuela) {
        this.id_escuela = id_escuela;
    }
    
}
