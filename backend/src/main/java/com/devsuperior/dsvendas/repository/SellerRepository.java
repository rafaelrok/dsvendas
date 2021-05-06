package com.devsuperior.dsvendas.repository;

import com.devsuperior.dsvendas.entities.Seller;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long>{
    
}
