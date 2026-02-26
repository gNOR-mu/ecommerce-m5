package com.bootcamp.model;

public class Customer {

    private Long id;

    private String name;
    private String rut;
    private String cellphone;
    private String email;
    private String passHash;

    public Customer() {
    }

    public Customer(Long id, String name, String rut, String cellphone, String email, String passHash) {
        this.id = id;
        this.name = name;
        this.rut = rut;
        this.cellphone = cellphone;
        this.email = email;
        this.passHash = passHash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }
}
