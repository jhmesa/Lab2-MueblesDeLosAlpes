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

/**
 * Clase que representa la información de un item de carrito de compras en el sistema
 */
public class Item
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Referencia que identifica el modelo del mueble en el sistema.
     */
    private String referencia;

    /**
     * Cantidad para la referencia del item de carrito.
     */
    private int cantidad;

    /**
     * Precio unitario del producto.
     */
    private Float precio;

    

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

    /**
     * Constructor sin argumentos de la clase
     */
    public Item() 
    {

    }

    /**
     * Constructor de la clase. Inicializa los atributos con los valores que ingresan por parametro.
     * @param referencia Referencia del mueble
     * @param cantidad Cantidad del producto que se compra.
     * @param precio precio de cada item del producto. 
     */
    public Item(String referencia, int cantidad, Float precio)
    {
        this.referencia = referencia;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

   

    /**
     * Devuelve la referencia del mueble
     * @return referencia Referencia del mueble
     */
    public String getReferencia()
    {
        return referencia;
    }

    /**
     * Modifica la referencia del mueble
     * @param referencia Nueva referencia del mueble
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
   
    /**
     * @return cantidad del item a comprar
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad que se comprara
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return precio unitario del item 
     */
    public Float getPrecio() {
        return precio;
    }

    /**
     * @param precio precio unitario del item
     */
    public void setPrecio(Float precio) {
        this.precio = precio;
    }


}
