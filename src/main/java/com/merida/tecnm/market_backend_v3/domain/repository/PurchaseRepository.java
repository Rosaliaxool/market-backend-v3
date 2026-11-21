package com.merida.tecnm.market_backend_v3.domain.repository;

import com.merida.tecnm.market_backend_v3.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clientId);
    Purchase save(Purchase purchase);
}
