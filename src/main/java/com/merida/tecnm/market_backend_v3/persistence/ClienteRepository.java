package com.merida.tecnm.market_backend_v3.persistence;

import com.merida.tecnm.market_backend_v3.domain.Client;
import com.merida.tecnm.market_backend_v3.domain.repository.ClientRepository;
import com.merida.tecnm.market_backend_v3.persistence.crud.ClienteCrudRepository;
import com.merida.tecnm.market_backend_v3.persistence.entity.Cliente;
import com.merida.tecnm.market_backend_v3.persistence.entity.mapper.ClientMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository implements ClientRepository {

    private final ClienteCrudRepository clienteCrudRepository;
    private final ClientMapper mapper;

    public ClienteRepository(ClienteCrudRepository clienteCrudRepository, ClientMapper mapper) {
        this.clienteCrudRepository = clienteCrudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Client> getAll() {
        return mapper.toClients((List<Cliente>) clienteCrudRepository.findAll());
    }

    @Override
    public Optional<Client> getClient(String clientId) {
        return clienteCrudRepository.findById(clientId).map(mapper::toClient);
    }

    @Override
    public Client save(Client client) {
        Cliente cliente = clienteCrudRepository.findById(client.getClientId())
                .orElseGet(() -> mapper.toCliente(client));

        cliente.setId(client.getClientId());
        cliente.setNombre(client.getName());
        cliente.setApellidos(client.getLastName());
        if (client.getCellPhone() != null && !client.getCellPhone().isBlank()) {
            try {
                cliente.setCelular(Long.parseLong(client.getCellPhone().trim()));
            } catch (NumberFormatException e) {
                // Si no se puede parsear a número, se mantiene el actual
            }
        }
        cliente.setDireccion(client.getAddress());
        cliente.setCorreoElectronico(client.getEmail());

        return mapper.toClient(clienteCrudRepository.save(cliente));
    }

    @Override
    public void delete(String clientId) {
        clienteCrudRepository.deleteById(clientId);
    }
}
