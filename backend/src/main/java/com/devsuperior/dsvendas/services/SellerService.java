package com.devsuperior.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repository.SellerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepo;

    public List<SellerDTO> findAll() {
        List<Seller> result = sellerRepo.findAll();
    	return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
    }
}
