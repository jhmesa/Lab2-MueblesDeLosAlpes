/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.bos;

import java.util.Date;
import java.util.List;

/**
 *
 * @author jaher
 */
public class Venta {
    
    Cliente cliente;
    
    List<Item> itemsMuebles;
    
    Double precioVenta;
    
    Date fechaVenta;
    
    public Venta(Cliente cliente, List<Item>itemsMuebles, Double precioVenta, Date fechaVenta ){
        this.cliente = cliente;
        this.itemsMuebles = itemsMuebles;
        this.precioVenta = precioVenta;
        this.fechaVenta = fechaVenta;    
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItemsMuebles() {
        return itemsMuebles;
    }

    public void setItemsMuebles(List<Item> itemsMuebles) {
        this.itemsMuebles = itemsMuebles;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
    
    
}
