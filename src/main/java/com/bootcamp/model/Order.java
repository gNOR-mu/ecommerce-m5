package com.bootcamp.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Modelo orden
 */
public class Order {

    private Long id;
    private Long customerId;

    private LocalDateTime creationDate;
    private BigDecimal total;

    /**
     * Constructor sin parámetros
     */
    public Order() {
    }

    /**
     * Constructor parametrizado
     * @param id ID de la orden
     * @param customerId ID del cliente
     * @param creationDate Fecha de creación
     * @param total Total
     */
    public Order(Long id, Long customerId, LocalDateTime creationDate, BigDecimal total) {
        this.id = id;
        this.customerId = customerId;
        this.creationDate = creationDate;
        this.total = total;
    }

    /**
     * Obtiene la ID
     * @return ID de la orden
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece la ID
     * @param id ID de la orden
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la ID del cliente
     * @return ID del cliente
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * Establece la ID del cliente
     * @param customerId ID del cliente
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * Obtiene la fecha de creación
     * @return Fecha de creación
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Establece la fecha de creación
     * @param creationDate Fecha de creación
     */
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Obtiene el total
     * @return Total
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * Establece el total
     * @param total Total
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
