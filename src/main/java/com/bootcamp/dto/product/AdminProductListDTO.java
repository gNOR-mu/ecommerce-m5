package com.bootcamp.dto.product;

import java.math.BigDecimal;

public class AdminProductListDTO {
    private Long id;
    private BigDecimal price;
    private String name;
    private String categoryName;
    private String brandName;
    private int stock;

    public AdminProductListDTO() {
    }

    public AdminProductListDTO(Long id, BigDecimal price, String name, String categoryName, String brandName, int stock) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.categoryName = categoryName;
        this.brandName = brandName;
        this.stock = stock;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
