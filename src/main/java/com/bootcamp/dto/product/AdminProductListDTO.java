package com.bootcamp.dto.product;

import java.math.BigDecimal;

/**
 * DTO para el listado de productos en el panel de administración
 */
public class AdminProductListDTO {
    private Long id;
    private BigDecimal price;
    private String name;
    private String categoryName;
    private String brandName;
    private int stock;

    /**
     * Constructor sin parámetros
     */
    public AdminProductListDTO() {
    }

    /**
     * Constructor parametrizado
     * @param id ID del producto
     * @param price Precio
     * @param name Nombre
     * @param categoryName Nombre de la categoría
     * @param brandName Nombre de la marca
     * @param stock Stock
     */
    public AdminProductListDTO(Long id, BigDecimal price, String name, String categoryName, String brandName, int stock) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.categoryName = categoryName;
        this.brandName = brandName;
        this.stock = stock;
    }

    /**
     * Obtiene la ID
     * @return ID del producto
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece la ID
     * @param id ID del producto
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el precio
     * @return Precio
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Establece el precio
     * @param price Precio
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
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
     * Obtiene el nombre de la categoría
     * @return Nombre de la categoría
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Establece el nombre de la categoría
     * @param categoryName Nombre de la categoría
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Obtiene el nombre de la marca
     * @return Nombre de la marca
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * Establece el nombre de la marca
     * @param brandName Nombre de la marca
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * Obtiene el stock
     * @return Stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * Establece el stock
     * @param stock Stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
}
