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

    public ProductResumeDTO() {
    }

    public ProductResumeDTO(Long id, String name, String shortDescription, String urlImage, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.shortDescription = shortDescription;
        this.urlImage = urlImage;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public BigDecimal getPrice() {
        return price;
    }
}