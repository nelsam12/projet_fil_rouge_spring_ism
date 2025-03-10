package org.project.projet.data.repository;

import org.project.projet.data.models.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Override
    Page<Client> findAll(Pageable pageable);
}
