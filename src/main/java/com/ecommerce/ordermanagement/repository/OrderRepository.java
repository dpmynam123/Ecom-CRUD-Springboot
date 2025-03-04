package com.ecommerce.ordermanagement.repository;

import com.ecommerce.ordermanagement.model.Order;
import com.ecommerce.ordermanagement.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByStatus(OrderStatus status);
    List<Order> findByCustomerNameContainingIgnoreCase(String query);
    List<Order> findByOrderItemContainingIgnoreCase(String query);
}
