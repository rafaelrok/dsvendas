package com.devsuperior.dsvendas.services;

import java.util.List;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repository.SaleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepo;

    @Transactional(readOnly=true) // Não efeturar o look de escrita no banco
    public Page<SaleDTO> findAll(Pageable pageable) {
        Page<Sale> result = saleRepo.findAll(pageable);
        return result.map(x -> new SaleDTO(x));
    }
    
    @Transactional(readOnly = true)
    public List<SaleSumDTO> amountGroupedBySeller() {
        return saleRepo.amountGroupedBySeller();
    }
    
    @Transactional(readOnly = true)
    public List<SaleSuccessDTO> successGroupedBySeller() {
        return saleRepo.successGroupedBySeller();
    }
}
