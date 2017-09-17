/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.bos.Venta;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author jaher
 */
@Named(value = "ventaBean")
@ApplicationScoped
public class VentaBean {

    
    Venta venta;
    
    List<Venta> ventas;
    
    /**
     * Creates a new instance of VentaBean
     */
    public VentaBean() {
        
        ventas = new ArrayList<>();
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }
    
    
    
    
}
