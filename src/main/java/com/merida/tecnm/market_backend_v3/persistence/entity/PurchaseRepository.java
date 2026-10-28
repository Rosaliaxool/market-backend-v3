package com.merida.tecnm.market_backend_v3.persistence.entity;

import com.merida.tecnm.market_backend_v3.domain.Purchase;
import com.merida.tecnm.market_backend_v3.persistence.entity.Compra;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getall();

    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clientId);

    Optional<List<Purchase>> getByIdClient(String clienteId);

    Purchase save(Purchase purchase);
}
