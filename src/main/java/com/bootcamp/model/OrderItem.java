package com.bootcamp.model;

import java.math.BigDecimal;

/**
 * Modelo item de orden
 */
public class OrderItem {

    private Long id;
    private Long orderId;
    private Long productId;

    private BigDecimal unitPrice;
    private BigDecimal subTotal;
    private int quantity;

    /**
     * Constructor sin parámetros
     */
    public OrderItem() {
    }

    /**
     * Constructor parametrizado
     * @param id ID del item
     * @param orderId ID de la orden
     * @param productId ID del producto
     * @param unitPrice Precio unitario
     * @param subTotal Subtotal
     * @param quantity Cantidad
     */
    public OrderItem(Long id, Long orderId, Long productId, BigDecimal unitPrice, BigDecimal subTotal, int quantity) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.unitPrice = unitPrice;
        this.subTotal = subTotal;
        this.quantity = quantity;
    }

    /**
     * Obtiene la ID
     * @return ID del item
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece la ID
     * @param id ID del item
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la ID de la orden
     * @return ID de la orden
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * Establece la ID de la orden
     * @param orderId ID de la orden
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * Obtiene la ID del producto
     * @return ID del producto
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * Establece la ID del producto
     * @param productId ID del producto
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * Obtiene el precio unitario
     * @return Precio unitario
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * Establece el precio unitario
     * @param unitPrice Precio unitario
     */
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Obtiene el subtotal
     * @return Subtotal
     */
    public BigDecimal getSubTotal() {
        return subTotal;
    }

    /**
     * Establece el subtotal
     * @param subTotal Subtotal
     */
    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * Obtiene la cantidad
     * @return Cantidad
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Establece la cantidad
     * @param quantity Cantidad
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
