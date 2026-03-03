package com.bootcamp.model;

/**
 * Modelo categoría
 */
public class Category {

    private Long id;

    private String name;

    /**
     * Constructor sin parámetros
     */
    public Category() {
    }

    /**
     * Constructor parametrizado
     * @param id ID de la categoría
     * @param name Nombre
     */
    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Obtiene la ID
     * @return ID de la categoría
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece la ID
     * @param id ID de la categoría
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
