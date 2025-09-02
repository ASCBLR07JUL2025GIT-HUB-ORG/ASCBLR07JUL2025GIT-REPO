package com.ezyshop.repository;

import com.ezyshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
List<Product> findByIsDeletedFalse();
    // Compose next id like P0001, P0002 ... using DB sequence
    @Query(value = "SELECT 'P' + RIGHT('0000' + CONVERT(VARCHAR(4), NEXT VALUE FOR dbo.Seq_ProductNumber), 4)", nativeQuery = true)
    String nextProductId();
}