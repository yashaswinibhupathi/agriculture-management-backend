package com.agriculture.management.repository;

import com.agriculture.management.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    List<Sale> findByFarmerId(Long farmerId);

    List<Sale> findByPaymentStatus(Sale.PaymentStatus status);

    @Query("SELECT COALESCE(SUM(s.totalPrice),0) FROM Sale s WHERE s.farmer.id = :farmerId")
    Double getTotalRevenueByFarmer(Long farmerId);
}