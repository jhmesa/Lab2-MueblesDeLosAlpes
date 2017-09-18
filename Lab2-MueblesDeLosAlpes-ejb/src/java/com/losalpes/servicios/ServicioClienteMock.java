/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ ServicioClienteMock.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package com.losalpes.servicios;

import com.losalpes.bos.Cliente;;
import java.util.ArrayList;
import java.util.List;


/**
 * Implementacion de los servicios del catalogo de clientes que se le prestan al sistema. [Mock Object]
 * 
 */

public class ServicioClienteMock implements IServicioCliente
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Arreglo con los clientes del sistema
     */
    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    
    static{
        
        
        //Agrega los muebles del sistema
        clientes.add(new Cliente("cedula", 1, "client", 1,
                    4, "Calle 100", "Bogotá D.C.", "Bogotá D.C.",
                    "Colombia", "Gerente", "client@gmail.com", "client"));    
        clientes.add(new Cliente("cedula", 1012, "Pepito Perez", 5388912,
                    318893566, "Calle 100", "Bogotá D.C.", "Bogotá D.C.",
                    "Colombia", "Ingeniero", "pepito@gmail.com", "pepito"));
        clientes.add(new Cliente("cedula", 1013, "Juanito Gomez", 5388913,
                    318893523, "Calle 200", "Bogotá D.C.", "Bogotá D.C.",
                    "Colombia", "Abogado", "juanito@gmail.com", "juanito"));
    }

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor sin argumentos de la clase
     */
    public ServicioClienteMock()
    {
     
       
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------

    /**
     * Agrega un cliente al sistema
     * @param cliente Nuevo cliente
     */
    @Override
    public void agregarCliente(Cliente cliente)
    {
        clientes.add(cliente);
    }

    /**
     * Elimina un cliente al sistema
     * @param cliente cliente a eliminar
     */
    public void eliminarCliente(Cliente cliente){
        clientes.remove(cliente);
    }
    
    /**
     * Devuelve los clientes del sistema
     * @return muebles Arreglo con todos los clientes del sistema
     */
    @Override
    public List<Cliente> darClientes()
    {
        return clientes;
    }

    /**
     * Devuelve el cliente identificado por el usuario
     * @return cliente Cliente identificado por el usuario ingresado
     */
    @Override
    public Cliente obtenerCliente(String usuario) {
        for (Cliente cliente : clientes) {
            if(cliente.getUsuario()!= null 
                    && cliente.getUsuario().equalsIgnoreCase(usuario)){
                return cliente;
            }
            
        }
        return null;
     }

}
