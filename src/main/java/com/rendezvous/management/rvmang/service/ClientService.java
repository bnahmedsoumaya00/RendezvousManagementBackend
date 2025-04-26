// ClientService.java
package com.rendezvous.management.rvmang.service;

import com.rendezvous.management.rvmang.dto.ClientDTO;
import com.rendezvous.management.rvmang.mapper.ClientMapper;
import com.rendezvous.management.rvmang.model.Client;
import com.rendezvous.management.rvmang.reporsitory.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(ClientMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ClientDTO> getClientById(Long id) {
        return clientRepository.findById(id)
                .map(ClientMapper::toDTO);
    }

    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client client = ClientMapper.toEntity(clientDTO);
        return ClientMapper.toDTO(clientRepository.save(client));
    }

    public ClientDTO updateClient(Long id, ClientDTO updatedClientDTO) {
        return clientRepository.findById(id)
                .map(client -> {
                    client.setName(updatedClientDTO.getName());
                    client.setEmail(updatedClientDTO.getEmail());
                    client.setPhone(updatedClientDTO.getPhone());
                    return ClientMapper.toDTO(clientRepository.save(client));
                })
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
