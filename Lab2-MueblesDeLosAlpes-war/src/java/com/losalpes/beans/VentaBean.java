/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ ClienteBean.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.losalpes.beans;

import com.losalpes.bos.Cliente;
import com.losalpes.bos.Item;
import com.losalpes.bos.Venta;
import com.losalpes.servicios.ServicioClienteMock;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 * Managed bean encargado del catálogo de clientes en el sistema
 *
 */
@ManagedBean
@ApplicationScoped
public class VentaBean {

    Venta venta;

    List<Venta> ventas;

    List<Item> itemsVendidos;

    /**
     * Creates a new instance of VentaBean
     */
    public VentaBean() {
        ventas = new ArrayList<>();
        itemsVendidos = new ArrayList<>();
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public List<Item> getItemsVendidos() {
        return itemsVendidos;
    }

    public void pagar(String usuario, List<Item> items) {
        
        ServicioClienteMock servicio = new ServicioClienteMock();
        Cliente cliente = servicio.obtenerCliente(usuario);
        
        
        Double valorTotal = 0D;
        for (Item im : items) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            im.setFechaVenta(sdf.format(new Date()));
            im.setCiudad(cliente.getCiudad());
            im.setCliente(cliente.getNombre());
            valorTotal += im.getPrecio();
            agregarItemAVendidos(im);
        }
      
        Venta venta = new Venta(cliente, items, valorTotal, new Date());
        getVentas().add(venta);

        // Mensaje al usuario de la compra
        String mensaje = "Se ha realizado la compra exitosamente";
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Éxito", mensaje));
    }

    
    public void agregarItemAVendidos(Item im) {
        
        if (getItemsVendidos().isEmpty()) {
            getItemsVendidos().add(im);
        } else {
            Agregar:
            for (Item item : getItemsVendidos()) {
                if (item.getMueble().getReferencia().equalsIgnoreCase(im.getMueble().getReferencia())) {
                    // Aumentamos la cantidad del item
                    item.setCantidad(item.getCantidad() + 1);
                    item.setPrecio(item.getMueble().getPrecio() * item.getCantidad());

                    break Agregar;
                }

            }
            getItemsVendidos().add(im);

        }

    }
    
}
