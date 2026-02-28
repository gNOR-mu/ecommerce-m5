package com.bootcamp.model;

import java.math.BigDecimal;
import java.util.Map;

public class Product {

    private Long id;
    private Long categoryId;
    private Long brandId;

    private BigDecimal price;
    private Map<String, Object> features;
    private String name;
    private String urlImage;
    private String description;
    private String shortDescription;
    private int stock;

    public Product() {
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Map<String, Object> getFeatures() {
        return features;
    }

    public void setFeatures(Map<String, Object> features) {
        this.features = features;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
