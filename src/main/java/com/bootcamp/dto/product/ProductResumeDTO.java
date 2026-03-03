package com.bootcamp.dto.product;

import java.math.BigDecimal;

/**
 * DTO con información simplificada de un producto
 */
public class ProductResumeDTO {
    private Long id;
    private String name;
    private String shortDescription;
    private String urlImage;
    private BigDecimal price;

    /**
     * Constructor sin parámetros
     */
    public ProductResumeDTO() {
    }

    /**
     * Constructor parametrizado
     * @param id ID del producto
     * @param name Nombre
     * @param shortDescription Descripción corta
     * @param urlImage URL de la imagen
     * @param price Precio
     */
    public ProductResumeDTO(Long id, String name, String shortDescription, String urlImage, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.shortDescription = shortDescription;
        this.urlImage = urlImage;
        this.price = price;
    }

    /**
     * Obtiene el precio
     * @return Precio
     */
    public Long getId() {
        return id;
    }

    /**
     * Obtiene el nombre
     * @return Nombre
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene la descripción corta
     * @return Descripción corta
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * Obtiene la URL de la imagen
     * @return URL de la imagen
     */
    public String getUrlImage() {
        return urlImage;
    }

    /**
     * Obtiene el precio
     * @return Precio
     */
    public BigDecimal getPrice() {
        return price;
    }
}