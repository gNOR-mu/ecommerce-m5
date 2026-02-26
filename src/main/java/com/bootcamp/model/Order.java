package com.bootcamp.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {

    private Long id;
    private Long customerId;

    private LocalDateTime creationDate;
    private BigDecimal total;

    public Order() {
    }

    public Order(Long id, Long customerId, LocalDateTime creationDate, BigDecimal total) {
        this.id = id;
        this.customerId = customerId;
        this.creationDate = creationDate;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
