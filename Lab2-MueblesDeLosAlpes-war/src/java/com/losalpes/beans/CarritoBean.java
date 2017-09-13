/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Kurush
 */
@ManagedBean(name = "carritoBean")
@SessionScoped
public class CarritoBean implements Serializable {

    /**
     * Creates a new instance of CarritoBean
     */
    public CarritoBean() {
        
    }
    
}
