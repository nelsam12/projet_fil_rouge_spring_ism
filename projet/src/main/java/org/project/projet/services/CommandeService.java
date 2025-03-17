package org.project.projet.services;

import org.project.projet.data.models.Client;
import org.project.projet.data.models.Commande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface CommandeService {
    Commande create(Commande commande);
    Page<Commande> findByClientPaginate(Long clientId, Pageable pageable);
    Page<Commande> findAll(Pageable pageable);
    Commande getById(Long id);
    Page<Commande> getByDate(Date date, Pageable pageable);
}
