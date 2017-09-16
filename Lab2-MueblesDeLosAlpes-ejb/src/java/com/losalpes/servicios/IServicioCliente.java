/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ IServicioCliente.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package com.losalpes.servicios;

import com.losalpes.bos.Cliente;
import java.util.List;


/**
 * Contrato funcional de los servicios que se le prestan al catálogo
 */
public interface IServicioCliente
{

    /**
     * Agrega un cliente al sistema
     * @param cliente Nuevo clientemueble
     */
    public void agregarCliente(Cliente cliente);

    /**
     * Elimina un cliente al sistema
     * @param cliente cliente a eliminar
     */
    public void eliminarCliente(Cliente cliente);
    
    /**
     * Devuelve todos los clientes del sistema
     * @return clientes Lista de clientes
     */
    public List<Cliente> darClientes();
    
}
