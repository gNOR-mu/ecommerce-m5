package com.bootcamp.dto.product;

import java.math.BigDecimal;
import java.util.Map;

public class ProductInfoDTO {
    private Long id;
    private BigDecimal price;
    private Map<String, Object> features;
    private String name;
    private String urlImage;
    private String description;
    private String shortDescription;

    public ProductInfoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Map<String, Object>  getFeatures() {
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

    public String getShortDescription() {
        return shortDescription;
    }

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
