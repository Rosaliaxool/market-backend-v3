package com.merida.tecnm.market_backend_v3.persistence.crud;

import com.merida.tecnm.market_backend_v3.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteCrudRepository extends CrudRepository<Cliente, String> {
}
