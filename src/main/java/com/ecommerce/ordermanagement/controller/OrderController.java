package com.ecommerce.ordermanagement.controller;

import com.ecommerce.ordermanagement.model.Order;
import com.ecommerce.ordermanagement.model.OrderStatus;
import com.ecommerce.ordermanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/status/{status}")
    public List<Order> getOrdersByStatus(@PathVariable OrderStatus status) {
        return orderService.getOrdersByStatus(status);
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @PostMapping("/bulk")
    public List<Order> createOrders(@RequestBody List<Order> orders) {
        return orderService.createOrders(orders);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

    @GetMapping("/items")
    public List<Order> searchOrdersByItem(@RequestParam String query) {
        return orderService.searchOrdersByItem(query);
    }

    @GetMapping("/customers")
    public List<Order> searchOrdersByCustomer(@RequestParam String query) {
        return orderService.searchOrdersByCustomer(query);
    }
}
