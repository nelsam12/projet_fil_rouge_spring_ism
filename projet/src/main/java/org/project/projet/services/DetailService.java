package org.project.projet.services;

import org.project.projet.data.models.Commande;
import org.project.projet.data.models.Detail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DetailService {
    Page<Detail> findByCommandeId(Long commandeId, Pageable pageable);
    List<Detail> findByCommandeId(Long commandeId);
}
