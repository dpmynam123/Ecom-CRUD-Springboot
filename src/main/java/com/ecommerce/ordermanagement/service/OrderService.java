package com.ecommerce.ordermanagement.service;

import com.ecommerce.ordermanagement.model.Order;
import com.ecommerce.ordermanagement.model.OrderStatus;
import com.ecommerce.ordermanagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getOrdersByStatus(OrderStatus status) {
        return orderRepository.findByStatus(status);
    }

    public List<Order> searchOrdersByItem(String query) {
        return orderRepository.findByOrderItemContainingIgnoreCase(query);
    }

    public List<Order> searchOrdersByCustomer(String query) {
        return orderRepository.findByCustomerNameContainingIgnoreCase(query);
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> createOrders(List<Order> orders) {
        return orderRepository.saveAll(orders);
    }

    public Order updateOrder(Long id, Order updatedOrder) {
        return orderRepository.findById(id).map(order -> {
            order.setOrderId(updatedOrder.getOrderId());
            order.setCustomerName(updatedOrder.getCustomerName());
            order.setOrderItem(updatedOrder.getOrderItem());
            order.setDeliveryDate(updatedOrder.getDeliveryDate());
            order.setDeliveryPrice(updatedOrder.getDeliveryPrice());
            order.setStatus(updatedOrder.getStatus());
            return orderRepository.save(order);
        }).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
