package org.project.projet.services;

import org.project.projet.data.models.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClientService {
    Client findById(Long id);
    Page<Client> findAll(Pageable pageable);
    List<Client> findAll();
}
