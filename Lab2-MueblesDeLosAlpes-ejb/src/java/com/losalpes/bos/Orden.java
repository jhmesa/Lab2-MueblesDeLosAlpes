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
public class Orden
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
    private ArrayList<Item> items;
    
    /**
     * Numero de orden asociada al carrito actual.
     */
    private String idOrden;

    /**
     * Crea una orden con todas sus caracteristicas; esta orden no se podra modificar luego; una orden se podra crear o 
     * cancelar, pero no modificar.
     */
    public Orden(String nombreUsuario, String idOrden, ArrayList<Item> items) {
        this.nombreUsuario = nombreUsuario;
        this.idOrden = idOrden;
        this.items = setItems(items);
    }

    

    //-----------------------------------------------------------
    // Constructor por defecto es suficiente para este tipo de objeto.
    //-----------------------------------------------------------
 
    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    /**
     * @return  nombreUsuario al que pertenece la orden creada
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }   

    /**
     * @return items la lista de item que se asignaron en la creacion de la orden
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * @param items llena la orden con los item que se compraron en la orden; solo se puede invocar desde el constructor.
     */
    private ArrayList<Item> setItems(ArrayList<Item> items) {
        this.items = items;
        return this.items;
    }

}
