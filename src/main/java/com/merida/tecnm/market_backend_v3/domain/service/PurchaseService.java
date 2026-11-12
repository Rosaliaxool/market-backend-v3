package com.merida.tecnm.market_backend_v3.domain.service;


import com.merida.tecnm.market_backend_v3.domain.Purchase;
import com.merida.tecnm.market_backend_v3.persistence.entity.PurchaseRepository;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PurchaseService {

    private PurchaseRepository purchaseRepository;
    public List<Purchase> getALL(){
        return purchaseRepository.getAll();

    }
    public Optional<List<Purchase>> getByClient(String clientId){
        return purchaseRepository.getByClient(clientId);
    }
    public Purchase save (Purchase purchase){
        return purchaseRepository.save(purchase);
    }
}

