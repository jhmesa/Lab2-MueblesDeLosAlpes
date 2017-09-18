/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.bos;

import java.util.Date;
import java.util.List;

/**
 * Clase que representa la venta que se realiza en el sistema
 */
public class Venta {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    
    /**
     * Cliente de la venta
     */
    Cliente cliente;

    /**
     * Lista de items vendidos
     */
    List<Item> itemsMuebles;

    /**
     * Precio de venta de todos los items
     */
    Double precioVenta;

    /**
     * Fecha de la realización de la venta
     */
    Date fechaVenta;

    /**
     * Contructor de la clase
     *
     * @param cliente cliente que compra
     * @param itemsMuebles items relacionados con la venta
     * @param precioVenta precio de la venta
     * @param fechaVenta fecha de la venta
     */
    public Venta(Cliente cliente, List<Item> itemsMuebles, Double precioVenta, Date fechaVenta) {
        this.cliente = cliente;
        this.itemsMuebles = itemsMuebles;
        this.precioVenta = precioVenta;
        this.fechaVenta = fechaVenta;
    }

    /**
     * Retorna el valor el cliente relacionado con la venta
     *
     * @return valor retornado
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Da valor al cliente
     *
     * @param cliente a parametrizar
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene los muebles asociados a la venta
     */
    public List<Item> getItemsMuebles() {
        return itemsMuebles;
    }

    /**
     * COnfigura los muebles relacionados con la venta
     *
     * @param itemsMuebles muebles relacionados en la venta
     */
    public void setItemsMuebles(List<Item> itemsMuebles) {
        this.itemsMuebles = itemsMuebles;
    }

    /**
     * Retorna el valor de venta
     *
     * @return precio de la venta
     */
    public Double getPrecioVenta() {
        return precioVenta;
    }

    /**
     * Pone el valor de venta
     *
     * @param precioVenta
     */
    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    /**
     * Obtiene la fecha de la venta
     *
     * @return
     */
    public Date getFechaVenta() {
        return fechaVenta;
    }

    /**
     * Configura la fecha de la venta
     *
     * @param fechaVenta
     */
    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
}
