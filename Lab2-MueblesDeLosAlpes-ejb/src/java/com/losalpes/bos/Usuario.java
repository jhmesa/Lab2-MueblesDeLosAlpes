/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ Usuario.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.losalpes.bos;

/**
 * Clase que representa un usuario del sistema
 */
public class Usuario {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    /**
     * Nombre del usuario
     */
    private String usuario;

    /**
     * Contraseña del usuario
     */
    private String contraseña;

    /**
     * Tipo de usuario
     */
    private TipoUsuario tipo;

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------
    /**
     * Constructor de la clase sin argumentos
     */
    public Usuario() {

    }

    /**
     * Constructor de la clase con argumentos
     *
     * @param usuario Nombre del usuario
     * @param contraseña Constraseña del usuario
     * @param tipo Tipo de usuario
     */
    public Usuario(String usuario, String contraseña, TipoUsuario tipo) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.tipo = tipo;
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------
    /**
     * Devuelve la contraseña del usuario
     *
     * @return contraseña Contraseña del usuario
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Modifica la contraseña del usuario
     *
     * @param contraseña Nueva contraseña
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Devuelve el nombre de usuario
     *
     * @return usuario Nombre del usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Modifica el usuario
     *
     * @param usuario Nuevo nombre de usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Devuelve el tipo de usuario
     *
     * @return tipo Tipo de usuario
     */
    public TipoUsuario getTipo() {
        return tipo;
    }

    /**
     * Modifica el tipo de usuario
     *
     * @param tipo Nuevo tipo de usuario
     */
    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

}
