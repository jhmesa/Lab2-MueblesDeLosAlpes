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

import com.losalpes.bos.Item;
import com.losalpes.bos.Mueble;
import com.losalpes.servicios.IServicioCatalogo;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Managed bean encargado del gestionar el carrito de compras
 *
 */
@ManagedBean
@SessionScoped
public class CarroComprasBean {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    /**
     * Representa un nuevo mueble a ingresar
     */
    private Mueble mueble;

    /**
     * Representa el listado de los muebles a comprar
     */
    private List<Item> itemsMuebles;

    /**
     * Relación con la interfaz que provee los servicios necesarios del
     * catálogo.
     */
    private IServicioCatalogo catalogo;

    private Item item;

    //private VentaBean ventaBean;

    private Double valorTotal;

    @ManagedProperty(value = "#{loginBean}")
    LoginBean login;
        

    public LoginBean getLogin() {
        return login;
    }

    public void setLogin(LoginBean login) {
        this.login = login;
    }

    /**
     * Representa un nuevo cliente a ingresar
     */
    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    /**
     * Constructor de la clase principal
     */
    public CarroComprasBean() {
        itemsMuebles = new ArrayList();
        valorTotal = 0.0D;
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------
    /**
     * Devuelve la lista de muebles agregados al carrito
     *
     * @return itemsMuebles lista de muebles
     */
    public List<Item> getItemsMuebles() {
        return itemsMuebles;
    }

    /**
     * Modifica la lista de muebles del carrito
     *
     * @param itemsMuebles Nueva lista de muebles
     */
    public void setItmsMuebles(List<Item> itemsMuebles) {
        this.itemsMuebles = itemsMuebles;
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------
    /**
     * Agrega un nuevo mueble al carro de compras
     */
    public void agregarMuebleCarro(Mueble mueble) {

        boolean existeMueble = false;
        // Iteramos cada uno de los elementos para buscar si ya se han agregados muebles de la misma referencia
        for (Item im : getItemsMuebles()) {

            if (im.getMueble().getReferencia().
                    equalsIgnoreCase(mueble.getReferencia())) {
                // Aumentamos la cantidad del item
                im.setCantidad(im.getCantidad() + 1);
                im.setPrecio(im.getMueble().getPrecio() * im.getCantidad());
                existeMueble = true;
                break;
            }
        }

        if (!existeMueble) {
            // No existe el item, asi que lo agregamos a la lista
            Item item = new Item(mueble, 1, mueble.getPrecio());
            getItemsMuebles().add(item);
        }

        // Mensaje al usuario de la adición del mueble al carrito de compras
        String mensaje = "Se ha agregado al carrito de compras una unidad del mueble con referencia: " + mueble.getReferencia();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Éxito", mensaje));

    }

    /**
     * Elimina un item del carro de compras
     */
    public void eliminarMuebleCarro(Item item) {
        getItemsMuebles().remove(item);

        // Mensaje al usuario de la eliminación
        String mensaje = "Se ha eliminado el mueble con referencia: " + item.getMueble().getReferencia();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Éxito", mensaje));
    }

    public Double getValorTotal() {

        for (Item im : getItemsMuebles()) {
            valorTotal += im.getPrecio();
        }

        return valorTotal;
    }

  
    public void limpiar() {
        setItmsMuebles(new ArrayList<Item>());
        // Mensaje al usuario de limpieza del carrito de compras
        String mensaje = "Se ha limpiado la lista del carrito de compras exitosamente";
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Éxito", mensaje));
    }

}
