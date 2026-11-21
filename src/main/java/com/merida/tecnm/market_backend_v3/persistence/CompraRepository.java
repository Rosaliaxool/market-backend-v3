package com.merida.tecnm.market_backend_v3.persistence;

import com.merida.tecnm.market_backend_v3.domain.Purchase;
import com.merida.tecnm.market_backend_v3.domain.repository.PurchaseRepository;
import com.merida.tecnm.market_backend_v3.persistence.crud.CompraCrudRepository;
import com.merida.tecnm.market_backend_v3.persistence.entity.Compra;
import com.merida.tecnm.market_backend_v3.persistence.entity.mapper.PurchaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    private final CompraCrudRepository compraCrudRepository;
    private final PurchaseMapper mapper;

    public CompraRepository(CompraCrudRepository compraCrudRepository, PurchaseMapper mapper) {
        this.compraCrudRepository = compraCrudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases(
                (List<Compra>) compraCrudRepository.findAll()
        );
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(mapper::toPurchases);
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);

        // La base de datos espera tipo char(1) para medio_pago ('E', 'T', etc.) y estado ('P', 'A', etc.)
        if (compra.getMedioPago() != null && compra.getMedioPago().length() > 1) {
            String mp = compra.getMedioPago().trim().toUpperCase();
            if (mp.startsWith("TARJETA")) {
                compra.setMedioPago("T");
            } else if (mp.startsWith("EFECTIVO")) {
                compra.setMedioPago("E");
            } else {
                compra.setMedioPago(mp.substring(0, 1));
            }
        }

        if (compra.getEstado() == null || compra.getEstado().isBlank()) {
            compra.setEstado("P"); // PENDIENTE por defecto
        } else if (compra.getEstado().length() > 1) {
            compra.setEstado(compra.getEstado().trim().substring(0, 1).toUpperCase());
        }

        if (compra.getFecha() == null) {
            compra.setFecha(java.time.LocalDateTime.now());
        }

        if (compra.getProductos() != null) {
            compra.getProductos().forEach(product -> {
                product.setCompra(compra);
                if (product.getId() == null) {
                    product.setId(new com.merida.tecnm.market_backend_v3.persistence.entity.CompraProductoPK());
                }
                if (product.getEstado() == null) {
                    product.setEstado(true);
                }
            });
        }

        return mapper.toPurchase(
                compraCrudRepository.save(compra)
        );
    }
}

