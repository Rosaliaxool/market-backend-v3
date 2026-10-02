package com.merida.tecnm.market_backend_v3.persistence.crud;

import com.merida.tecnm.market_backend_v3.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
}
