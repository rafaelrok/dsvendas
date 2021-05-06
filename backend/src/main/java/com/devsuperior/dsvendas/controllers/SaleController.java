package com.devsuperior.dsvendas.controllers;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.repository.SellerRepository;
import com.devsuperior.dsvendas.services.SaleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/sales")
public class SaleController {
	
	@Autowired
	private SaleService serviceSale;
	
	@Autowired
	private SellerRepository sellerRepo;

	@Transactional(readOnly = true) //Não efeturar o look de escrita no banco
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
		sellerRepo.findAll();
		Page<SaleDTO> list =  serviceSale.findAll(pageable);
		return ResponseEntity.ok(list);
	}

}
