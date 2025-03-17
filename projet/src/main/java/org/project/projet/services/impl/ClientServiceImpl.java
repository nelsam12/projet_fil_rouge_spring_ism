package org.project.projet.services.impl;

import lombok.RequiredArgsConstructor;
import org.project.projet.data.models.Client;
import org.project.projet.data.repository.ClientRepository;
import org.project.projet.exceptions.EntityNotFoundExceptions;
import org.project.projet.services.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundExceptions("Client with id " + id + " not found"));
    }

    @Override
    public Page<Client> findAll(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}
