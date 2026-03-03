package com.bootcamp.model;

/**
 * Modelo marca
 */
public class Brand {
    private Long id;
    private String name;

    /**
     * Constructor sin parámetros
     */
    public Brand() {
    }

    /**
     * Constructor parametrizado
     * @param id ID de la marca
     * @param name Nombre
     */
    public Brand(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Obtiene la ID
     * @return ID de la marca
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece la ID
     * @param id ID de la marca
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
}
