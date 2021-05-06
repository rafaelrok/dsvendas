package com.devsuperior.dsvendas.controllers;

import java.util.List;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.services.SaleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/sales")
public class SaleController {
	
	@Autowired
	private SaleService serviceSale;

	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
		Page<SaleDTO> list = serviceSale.findAll(pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value="/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {
		List<SaleSumDTO> list = serviceSale.amountGroupedBySeller();
		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/success-by-seller")
	public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySeller() {
		List<SaleSuccessDTO> list = serviceSale.successGroupedBySeller();
		return ResponseEntity.ok(list);
	}

}
