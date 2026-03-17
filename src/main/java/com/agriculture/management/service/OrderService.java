package com.agriculture.management.service;

import com.agriculture.management.model.Order;
import com.agriculture.management.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public List<Order> getByFarmer(Long farmerId) {
        return orderRepository.findByFarmerId(farmerId);
    }

    public List<Order> getBySupplier(Long supplierId) {
        return orderRepository.findBySupplierId(supplierId);
    }

    public List<Order> getByStatus(Order.OrderStatus status) {
        return orderRepository.findByStatus(status);
    }

    public Order updateStatus(Long id, Order.OrderStatus status) {

        Order order = getOrderById(id);
        order.setStatus(status);

        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}