package com.bootcamp.model;

/**
 * Modelo cliente
 */
public class Customer {

    private Long id;

    private String name;
    private String rut;
    private String cellphone;
    private String email;
    private String passHash;

    /**
     * Constructor sin parámetros
     */
    public Customer() {
    }

    /**
     * Constructor parametrizado
     * @param id ID del cliente
     * @param name Nombre
     * @param rut RUT
     * @param cellphone Celular
     * @param email Email
     * @param passHash Hash de contraseña
     */
    public Customer(Long id, String name, String rut, String cellphone, String email, String passHash) {
        this.id = id;
        this.name = name;
        this.rut = rut;
        this.cellphone = cellphone;
        this.email = email;
        this.passHash = passHash;
    }

    /**
     * Obtiene la ID
     * @return ID del cliente
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece la ID
     * @param id ID del cliente
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre
     * @return Nombre
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre
     * @param name Nombre
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el RUT
     * @return RUT
     */
    public String getRut() {
        return rut;
    }

    /**
     * Establece el RUT
     * @param rut RUT
     */
    public void setRut(String rut) {
        this.rut = rut;
    }

    /**
     * Obtiene el celular
     * @return Celular
     */
    public String getCellphone() {
        return cellphone;
    }

    /**
     * Establece el celular
     * @param cellphone Celular
     */
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    /**
     * Obtiene el email
     * @return Email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el email
     * @param email Email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene el hash de la contraseña
     * @return Hash de la contraseña
     */
    public String getPassHash() {
        return passHash;
    }

    /**
     * Establece el hash de la contraseña
     * @param passHash Hash de la contraseña
     */
    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }
}
