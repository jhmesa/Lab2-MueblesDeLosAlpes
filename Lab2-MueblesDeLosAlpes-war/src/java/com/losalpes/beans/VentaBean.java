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

    /***
     * Método para el registro de los pagos
     * @param usuario usuario que hace la compra
     * @param items arreglo con los items vendidos en la transacción
     */
    public void pagar(String usuario, List<Item> items) {
        
        ServicioClienteMock servicio = new ServicioClienteMock();
        Cliente cliente = servicio.obtenerCliente(usuario);
        
        
        Double valorTotal = 0D;
        
        // se agregan todos los itemas vendidos
        for (Item im : items) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            im.setFechaVenta(sdf.format(new Date()));
            im.setCiudad(cliente.getCiudad());
            im.setCliente(cliente.getNombre());
            valorTotal += im.getPrecio();
            agregarItemAVendidos(im);
        }      

        // se agrega venta a arreglo de ventas
        Venta venta = new Venta(cliente, items, valorTotal, new Date());
        getVentas().add(venta);

        // Mensaje al usuario de la compra
        String mensaje = "Se ha realizado la compra exitosamente";
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Éxito", mensaje));
    }

    /***
     * Método para agregar las ventas al arreglo
     * @param im item a agregar a la lista
     */
    public void agregarItemAVendidos(Item im) {       

        // se valida si ya este item ha sido vendido con anterioridad
        if (getItemsVendidos().isEmpty()) {
            // se inserta uno si no se ha vendido alguno en algún momento
            getItemsVendidos().add(im);
        } else {
            Agregar:
            // se suma al contado del item la nueva venta
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
    
    /***
     * Método para el borrado de los clientes
     * @param cliente cliente que va a ser borado
     */
     public void deleteClient(Cliente cliente){
        System.out.println("com.losalpes.beans.ClienteBean.delete()");
        
        // se verifica si el cliente a borrar ha tendio alguna compra
        Boolean borrar = true;
        for(Venta venta: this.ventas)
        {
            if(venta.getCliente().getNumDocumento() == cliente.getNumDocumento() && venta.getCliente().getTipoDocumento()== cliente.getTipoDocumento() ){
                borrar = false;
            }
        }
        
        // de no tener compras se procede con el borrado a través del servicio de clientes
        if(borrar)
        {
            ServicioClienteMock servicio = new ServicioClienteMock();
            servicio.eliminarCliente(cliente);
            
            FacesMessage msg = new FacesMessage("Cliente borrado", "El cliente " + cliente.getNombre() + " ha sido borrado.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        
        
    }
    
}
