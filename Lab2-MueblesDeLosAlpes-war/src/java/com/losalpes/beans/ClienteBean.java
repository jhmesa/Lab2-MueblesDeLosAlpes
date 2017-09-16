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
import com.losalpes.servicios.IServicioCliente;
import com.losalpes.servicios.ServicioClienteMock;
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
        catalogoCliente.agregarCliente(cliente);
        cliente=new Cliente();
    }

    /**
     * Elimina la información del cliente
     */
    public void limpiar()
    {
        cliente=new Cliente();
    }
   

}
