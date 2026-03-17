package com.agriculture.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agriculture.management.model.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByFarmerId(Long farmerId);
    List<Order> findBySupplierId(Long supplierId);
    List<Order> findByStatus(Order.OrderStatus status);
}
