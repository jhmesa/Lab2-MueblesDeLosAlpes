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
import com.losalpes.bos.TipoUsuario;
import com.losalpes.bos.Usuario;
import com.losalpes.servicios.IServicioCliente;
import com.losalpes.servicios.IServicioSeguridad;
import com.losalpes.servicios.ServicioClienteMock;
import com.losalpes.servicios.ServicioSeguridadMock;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;


/**
 * Managed bean encargado del catálogo de clientes en el sistema
 * 
 */
@ManagedBean
@ApplicationScoped
public class ClienteBean
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Representa un nuevo cliente a ingresar
     */
    private Cliente cliente;

    /**
     * Relación con la interfaz que provee los servicios necesarios del catálogo de clientes.
     */
    private IServicioCliente catalogoCliente;
    
     /**
     * Relación con la interfaz adecuada para la autenticación de usuarios
     */
    private IServicioSeguridad servicioSeguridad;    
    
    
    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor de la clase principal
     */
    public ClienteBean()
    {
        cliente=new Cliente();
        catalogoCliente=new ServicioClienteMock();
        servicioSeguridad = new ServicioSeguridadMock();
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    /**
     * Devuelve el objeto cliente
     * @return mueble Objeto cliente
     */
    public Cliente getCliente()
    {
        return cliente;
    }

    /**
     * Modifica el objeto cliente
     * @param cliente Nuevo cliente
     */
    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }

    /**
     * Devuelve una lista con todos los clientes del sistema
     * @return clientes Clientes del sistema
     */
    public List<Cliente> getClientes()
    {
        return catalogoCliente.darClientes();
    }
    
    
    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------

    /**
     * Agrega un nuevo cliente al sistema
     */
    public void agregarCliente()
    {
        cliente.setTipo(TipoUsuario.CLIENTE);
        catalogoCliente.agregarCliente(cliente); 
        
        // se crea el nuevo usuario y se agrega al arreglo de usuarios
        Usuario usuario = new Usuario(cliente.getUsuario(), cliente.getContraseña(), TipoUsuario.CLIENTE);
        servicioSeguridad.addUser(usuario);
        cliente=new Cliente();
    }

    /**
     * Elimina la información del cliente
     */
    public void limpiar()
    {        cliente=new Cliente();
    }   
    
    /***
     * Evento que se ejecuta al aceptar la modificación de la fila
     * @param event valores modificados
     */
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Cliente editado", String.valueOf(((Cliente) event.getObject()).getNombre()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    /***
     * Evento que se ejecuta al cancelar la modificación de la fila
     * @param event valores modificados
     */
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edición cancelada", String.valueOf(((Cliente) event.getObject()).getNombre()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /**
     * Evento que se ejecuta luego de aceptar el cambio en la fula
     * @param event valores modificados
     */
    public void onCellEdit(CellEditEvent event) {
        
        System.out.println("El man está entrando");
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        // se hace el replazo del registro viejo por el registro modificado
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
