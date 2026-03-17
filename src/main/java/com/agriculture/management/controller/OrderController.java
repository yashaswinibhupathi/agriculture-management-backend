package com.agriculture.management.controller;

import com.agriculture.management.model.Order;
import com.agriculture.management.service.OrderService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order create(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping
    public List<Order> getAll() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/farmer/{farmerId}")
    public List<Order> getByFarmer(@PathVariable Long farmerId) {
        return orderService.getByFarmer(farmerId);
    }

    @GetMapping("/supplier/{supplierId}")
    public List<Order> getBySupplier(@PathVariable Long supplierId) {
        return orderService.getBySupplier(supplierId);
    }

    // Supplier accepts an order
    @PutMapping("/{id}/accept")
    public Order accept(@PathVariable Long id) {
        return orderService.updateStatus(id, Order.OrderStatus.APPROVED);
    }

    // Supplier rejects/cancels an order
    @PutMapping("/{id}/reject")
    public Order reject(@PathVariable Long id) {
        return orderService.updateStatus(id, Order.OrderStatus.CANCELLED);
    }

    // Generic status update
    @PutMapping("/{id}/status")
    public Order updateStatus(@PathVariable Long id, @RequestBody Map<String, String> body) {
        Order.OrderStatus status = Order.OrderStatus.valueOf(body.get("status").toUpperCase());
        return orderService.updateStatus(id, status);
    }

    @PutMapping("/{id}")
    public Order update(@PathVariable Long id, @RequestBody Order order) {
        order.setId(id);
        return orderService.createOrder(order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
