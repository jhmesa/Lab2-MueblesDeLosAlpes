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
     * Cantidad para la referencia del item de carrito.
     */
    private int cantidad;

    /**
     * Precio unitario del producto.
     */
    private Double precio;
    
    /**
     * Marca para la vista del carrito de compras para sumarizar el precio la selección de los items seleccionados.
     */
    private  final String carro = "A";
    
    /**
     * Referencia del objeto mueble
     */
    private Mueble mueble;

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
     * @param mueble Referencia del mueble
     * @param cantidad Cantidad de muebles de la misma referencia
     * @param precio Valor del precio
     */
     public Item(Mueble mueble, int cantidad, Double precio)
    {
        this.mueble = mueble;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    
    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------
   
   
    /**
     * Devuelve la cantidad del mueble
     * @return cantidad Cantidad de la referencia del mueble
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Modifica la cantidad del mueble
     * @param cantidad Nuevo cantidad de la referencia del mueble
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Devuelve el precio del mueble
     * @return precio Precios de los muebles de la misma referencia
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * Modifica el precio de la referencia del mueble
     * @param precio Nuevo precio ee la referencia del mueble
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * Devuelve el objeto mueble
     * @return mueble Objeto tipo Mueble
     */
    public Mueble getMueble() {
        return mueble;
    }

    /**
     * Modifica la referencia del mueble
     * @param mueble Nueva referencia del mueble
     */
    public void setMueble(Mueble mueble) {
        this.mueble = mueble;
    } 

    /**
     * Devuelve la marca de la fila de suma de los precios de los items del carrito de compras
     * @return carro
     */
    public String getCarro() {
        return carro;
    }
    
    
}
