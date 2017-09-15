/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ Mueble.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package com.losalpes.bos;

import java.util.ArrayList;

/**
 * Clase que representa la información de un carrito de compras en el sistema
 */
public class Carrito
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Referencia que identifica el modelo del mueble en el sistema.
     */
    private String nombreUsuario;

    /**
     * Los items que se encuentran en el carrito
     */
    private ArrayList<Item> items = new ArrayList<Item>();  

    //-----------------------------------------------------------
    // Constructor por defecto es suficiente para este tipo de objeto.
    //-----------------------------------------------------------
 
    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    /**
     * @return nombreUsuario al que pertenece el carrito
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario asigna el carrito a un usuario
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return la lista de items actual
     */
    public ArrayList<Item> getItems() {
        return items;
    }
    
    /**
     * @param i el item del carrito que se quiere consultar
     * @return un item especifico
     */
    public Item getSpecificItem(int i) {
        return items.get(i);
    }

    /**
     * @param item anade el item al carrito 
     */
    public void addItem(Item item) {
        this.items.add(item);
    }
    
        /**
     * @param i remueve el item del indice especificado 
     */
    public void removeItem(int i) {
        
        this.items.remove(i);
    }

}
