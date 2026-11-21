package com.merida.tecnm.market_backend_v3.domain.repository;

import com.merida.tecnm.market_backend_v3.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    List<Client> getAll();
    Optional<Client> getClient(String clientId);
    Client save(Client client);
    void delete(String clientId);
}
