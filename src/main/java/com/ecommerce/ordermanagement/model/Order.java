package com.ecommerce.ordermanagement.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String orderId;

    @Column(nullable = false)
    private String customerName;

    private String orderItem;

    private LocalDate deliveryDate;

    private Double deliveryPrice;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;


    public Order() {}

    public Order(String orderId, String customerName, String orderItem, LocalDate deliveryDate, Double deliveryPrice, OrderStatus status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderItem = orderItem;
        this.deliveryDate = deliveryDate;
        this.deliveryPrice = deliveryPrice;
        this.status = status;
    }


    public Long getId() {
        return id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(String orderItem) {
        this.orderItem = orderItem;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Double getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(Double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
