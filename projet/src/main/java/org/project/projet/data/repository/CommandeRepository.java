package org.project.projet.data.repository;

import org.project.projet.data.models.Commande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDate;
import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    List<Commande> findByClientId(Long id);
    Page<Commande> findByClientId(Long id, Pageable pageable);
    Page<Commande> findAll(Pageable pageable);
    Page<Commande> findByDate(LocalDate date, Pageable pageable);
}
