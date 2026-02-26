package com.bootcamp.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Product {

    private Long id;
    private Long categoryId;
    private Long brandId;

    private BigDecimal price;
    private List<String> features;
    private String name;
    private String urlImage;
    private String description;
    private int stock;

    public Product() {
    }

    public Product(Long id, Long categoryId, Long brandId, BigDecimal price, List<String> features,
                   String name, String urlImage, String description, int stock) {
        this.id = id;
        this.categoryId = categoryId;
        this.brandId = brandId;
        this.price = price;
        this.features = features;
        this.name = name;
        this.urlImage = urlImage;
        this.description = description;
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

    public List<String> getFeatures() {
        return new ArrayList<>(features);
    }

    public void setFeatures(List<String> features) {
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
}
