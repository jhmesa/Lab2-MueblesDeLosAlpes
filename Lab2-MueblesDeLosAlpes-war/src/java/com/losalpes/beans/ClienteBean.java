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
import javax.faces.bean.ManagedBean;


/**
 * Managed bean encargado del catálogo de clientes en el sistema
 * 
 */
@ManagedBean
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
    
    /**
     * Representa el usuario
     */
    private Usuario usuario;    

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
        usuario = new Usuario();
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
    
    /**
     * Modifica el objeto usuario
     * @param usuario Nuevo Usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Modifica el objeto usuario
     * @param usuario Nuevo Usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------

    /**
     * Agrega un nuevo cliente al sistema
     */
    public void agregarCliente()
    {
        catalogoCliente.agregarCliente(cliente);
        usuario.setTipo(TipoUsuario.CLIENTE);
        servicioSeguridad.addUser(usuario);
        cliente=new Cliente();
        usuario = new Usuario();
    }

    /**
     * Elimina la información del cliente
     */
    public void limpiar()
    {        cliente=new Cliente();
        usuario = new Usuario();
    }   

}
