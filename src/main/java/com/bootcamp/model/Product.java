package com.bootcamp.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Modelo producto
 */
public class Product {

    private Long id;
    private Long categoryId;
    private Long brandId;

    private BigDecimal price;
    private Map<String, Object> features = new HashMap<>();
    private String name;
    private String urlImage;
    private String description;
    private String shortDescription;
    private int stock;

    /**
     * Constructor sin parámetros
     */
    public Product() {
    }

    /**
     * Constructor parametrizado
     * @param id ID del producto
     * @param categoryId ID de la categoría
     * @param brandId ID de la marca
     * @param price Precio
     * @param features Características
     * @param name Nombre
     * @param urlImage URL imagen
     * @param description Descripción
     * @param shortDescription Descripción corta
     * @param stock Stock
     */
    public Product(Long id,
                   Long categoryId,
                   Long brandId,
                   BigDecimal price,
                   Map<String, Object> features,
                   String name,
                   String urlImage,
                   String description,
                   String shortDescription,
                   int stock) {
        this.id = id;
        this.categoryId = categoryId;
        this.brandId = brandId;
        this.price = price;
        this.features = features;
        this.name = name;
        this.urlImage = urlImage;
        this.description = description;
        this.shortDescription = shortDescription;
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
     * Obtiene la ID de la categoría
     * @return
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * Establece la ID de la categoría
     * @param categoryId ID de la categoría
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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
     * Obtiene las características
     * @return Características
     */
    public Map<String, Object> getFeatures() {
        return features;
    }

    /**
     * Establece las características
     * @param features Características
     */
    public void setFeatures(Map<String, Object> features) {
        this.features = features;
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
     * Obtiene la URL de la imagen
     * @return URL de la imagen
     */
    public String getUrlImage() {
        return urlImage;
    }

    /**
     * Establece la URL de la imagen
     * @param urlImage URL de la imagen
     */
    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    /**
     * Obtiene la descripción
     * @return Descripción
     */
    public String getDescription() {
        return description;
    }

    /**
     * Establece la descripción
     * @param description Descripción
     */
    public void setDescription(String description) {
        this.description = description;
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

    /**
     * Obtiene la ID de la marca
     * @return ID de la marca
     */
    public Long getBrandId() {
        return brandId;
    }

    /**
     * Establece la ID de la marca
     * @param brandId ID de la marca
     */
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    /**
     * Obtiene la descripción corta
     * @return Descripción corta
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * Establece la descripción corta
     * @param shortDescription Descripción corta
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
