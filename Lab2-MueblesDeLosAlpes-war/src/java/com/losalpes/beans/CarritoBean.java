/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import SessionBeans.CartBeanLocal;
import com.losalpes.bos.Carrito;
import com.losalpes.bos.Item;
import com.losalpes.bos.Mueble;
import com.losalpes.bos.Orden;
import com.losalpes.servicios.IServicioCatalogo;
import com.losalpes.servicios.ServicioCatalogoMock;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Kurush
 */
@ManagedBean(name = "carritoBean")
@SessionScoped
public class CarritoBean implements Serializable {

    /**
    * Representa un nuevo mueble a ingresar
    */
    private Mueble mueble;

    /**
    * Relación con la interfaz que provee los servicios necesarios del catálogo.
    */
    private IServicioCatalogo catalogo;
    /**
    * Valor que se guardara en el carrito para saber que producto se va a comprar
    */
    private String referenciaProducto;
    /**
    * Cantidad de unidades que se compraran del producto
    */
    private int cantidad = 1;
    
    /**
    * Instanciacion del carrito de compras
    */
    private Carrito carrito = new Carrito();
    private Item item= new Item();
    private static final String titulo = "Carrito de Compras";
    /**
    * Pienso que se puede instanciar un nuevo objeto orden cada vez que se vaya a generar una nueva "venta"
    */
    private Orden orden;




    
    @EJB
    CartBeanLocal cartBeanLocal;
    
    
    /**
     * Creates a new instance of CarritoBean
     */
    public CarritoBean() {
        mueble=new Mueble();
        catalogo=new ServicioCatalogoMock();
    }
    
    @PostConstruct
    public void init() {       
        
    /**
    * Operaciones de prueba, tomar como guia para implementar en otros ManagedBeans, y borrar cuando haya implementacion de otros detalles
    */
        carrito = setCarrito(cartBeanLocal.crearCarrito("prueba"));
        mueble = getMuebles().get(0);
        referenciaProducto = getMueble().getNombre();
        item.setReferencia(getReferenciaProducto());
        item.setCantidad(getCantidad());
        item.setPrecio(123.45f);
        carrito = anadirItemCarrito();        
        orden = new Orden("prueba", "1", carrito.getItems()); //A este objeto se le debe asignar un bean de aplicacion, para que este constantemente recibiendo estos objetos, y se puedan generar reportes.
        
    }
    /**
     *
     * @return Lista de muebles a agregar
     */
    public List<Mueble> getMuebles()
    {

        return getCatalogo().darMuebles();
    }
    
    
   public Carrito anadirItemCarrito() {
       
       Carrito carritoIn = cartBeanLocal.anadirItemCarrito(carrito, item);
       
       return carritoIn;
       
   }

    /**
     * @return the mueble
     */
    public Mueble getMueble() {
        return mueble;
    }

    /**
     * @return the catalogo
     */
    public IServicioCatalogo getCatalogo() {
        return catalogo;
    }

    /**
     * @return the referenciaProducto
     */
    public String getReferenciaProducto() {
        return referenciaProducto;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the carrito
     */
    public Carrito getCarrito() {
        return carrito;
    }

    /**
     * @param carrito the carrito to set
     */
    public Carrito setCarrito(Carrito carrito) {
        this.carrito = carrito;
        return this.carrito;
    }

    /**
     * @return the item
     */
    public Item getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Item item) {
        this.item = item;
    }
    public String getTitulo() {
        return titulo;
    }    
    
    public Orden getOrden() {
        return orden;
    }
}
