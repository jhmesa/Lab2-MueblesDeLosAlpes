/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ Cliente.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.losalpes.bos;

/**
 * Clase que representa la información de un cliente en el sistema
 */
public class Cliente {
    
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Referencia que identifica el tipo de documento del cliente.
     */
    private String tipoDocumento;
    
    /**
     * Referencia que identifica el número de documento del cliente.
     */
    private long numDocumento;
    
    /*
     * Identifica el nombre del cliente en el sistema 
    */
    private String nombre;
    
    /*
     * Identifica el número de telefono de la residencia del cliente en el sistema 
    */
    private long telResidencia;
    
    /*
     * Identifica el número de telefono del celular del cliente 
    */
    private long telCelular;
    
    /*
     * Identifica la dirección del cliente 
    */
    private String direccion;
    
    /*
     * Identifica la ciudad de residencia del cliente 
    */
    private String ciudad;  
    
    /*
     * Identifica el departamento de residencia del cliente 
    */
    private String departamento;    
    
    /*
     * Identifica el pais de residencia del cliente 
    */
    private String pais;
    
    /*
     * Identifica la profesión del cliente 
    */
    private String profesion;
    
    /*
     * Identifica el email del cliente 
    */
    private String email;
    
    
    /**
     * Constructor sin argumentos de la clase
     */
    public Cliente() 
    {

    }
    
    /**
     * Constructor de la clase. Inicializa los atributos con los valores que ingresan por parametro.
     * @param tipoDocumento
     * @param numDocumento
     * @param nombre
     * @param telResidencia
     * @param telCelular
     * @param direccion
     * @param ciudad
     * @param departamento
     * @param pais
     * @param profesion
     * @param email 
     */
    public Cliente(String tipoDocumento, long numDocumento, String nombre, long telResidencia,
                    long telCelular, String direccion, String ciudad, String departamento,
                    String pais, String profesion, String email)
    {
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.nombre = nombre;
        this.telResidencia = telResidencia;
        this.telCelular = telCelular;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.pais = pais;
        this.profesion =profesion;
        this.email = email;
        
    }
    
    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    /**
     * Devuelve el tipo de documento del cliente
     * @return tipoDocumento el tipo de documento del cliente
     */
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * Modifica el tipo de documento del cliente
     * @param tipoDocumento el nuevo tipo de documento del cliente
     */
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * Devuelve el número de documento del cliente
     * @return numDocumento el número de documento del cliente
     */
    public long getNumDocumento() {
        return numDocumento;
    }

    /**
     * Modifica el tipo de documento del cliente
     * @param numDocumento el nuevo número de documento del cliente
     */
    public void setNumDocumento(long numDocumento) {
        this.numDocumento = numDocumento;
    }

    /**
     * Devuelve el nombre del cliente cliente
     * @return nombre el nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el número de telefono de la residencia del cliente
     * @return telResidencia el número de telefono de la residencia del cliente
     */
    public long getTelResidencia() {
        return telResidencia;
    }

    public void setTelResidencia(long telResidencia) {
        this.telResidencia = telResidencia;
    }

    /**
     * Devuelve el número del celular del cliente
     * @return telCelular el número del celular del cliente
     */
    public long getTelCelular() {
        return telCelular;
    }

    public void setTelCelular(long telCelular) {
        this.telCelular = telCelular;
    }

    /**
     * Devuelve la dirección del cliente
     * @return direccion la dirección del cliente
     */
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Devuelve la ciudad de residencia del cliente
     * @return ciudad la ciudad de residencia del cliente
     */
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    /**
     * Devuelve el departamento de residencia del cliente
     * @return departamento el departamento de residencia del cliente
     */
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * Devuelve el país de residencia del cliente
     * @return pais el país de residencia del cliente
     */
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Devuelve la profesión del cliente
     * @return profesion la profesión del cliente
     */
    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    /**
     * Devuelve el correo electronico del cliente
     * @return email el correo electronico del cliente
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }    
}