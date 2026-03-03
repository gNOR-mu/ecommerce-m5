package com.bootcamp.dto.product;

import java.math.BigDecimal;
import java.util.Map;

/**
 * DTO con la información de un producto
 */
public class ProductInfoDTO {
    private Long id;
    private BigDecimal price;
    private Map<String, Object> features;
    private String name;
    private String urlImage;
    private String description;
    private String shortDescription;

    /**
     * Constructor sin parámetros
     */
    public ProductInfoDTO() {
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
     * Obtiene las características
     * @return Características
     */
    public Map<String, Object>  getFeatures() {
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

    @Override
    public String toString() {
        return "ProductInfoDTO{" +
                "id=" + id +
                ", price=" + price +
                ", features=" + features +
                ", name='" + name + '\'' +
                '}';
    }
}
