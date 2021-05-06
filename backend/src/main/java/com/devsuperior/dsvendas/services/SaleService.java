package com.devsuperior.dsvendas.services;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repository.SaleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepo;

    //Busca paginada onde apresenta por pagina
    public Page<SaleDTO> findAll(Pageable pageable ) {
        Page<Sale> result = saleRepo.findAll(pageable);
    	return result.map(x -> new SaleDTO(x));
    }
}
