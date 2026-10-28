package com.merida.tecnm.market_backend_v3.persistence;

import com.merida.tecnm.market_backend_v3.domain.Purchase;
import com.merida.tecnm.market_backend_v3.persistence.crud.CompraCrudRepository;
import com.merida.tecnm.market_backend_v3.persistence.entity.Compra;
import com.merida.tecnm.market_backend_v3.persistence.entity.PurchaseRepository;
import com.merida.tecnm.market_backend_v3.persistence.entity.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class CompraRepository implements PurchaseRepository {

    @Autowired
    private CompraCrudRepository compraCrudRepository;

    private PurchaseMapper mapper;


    @Override
    public List<Purchase> getall() {
        return List.of();
    }

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases(
                (List<Compra>) compraCrudRepository.findAll()
        );
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Purchase>> getByIdClient(String clienteId) {
        return compraCrudRepository.findByIdCliente(clienteId)
                .map(mapper::toPurchases);
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);

        compra.getProductos().forEach(
                product -> product.setCompra(compra)
        );

        return mapper.toPurchase(
                compraCrudRepository.save(compra)
        );
    }
}
