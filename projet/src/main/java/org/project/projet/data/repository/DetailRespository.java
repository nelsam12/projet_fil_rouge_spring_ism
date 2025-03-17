package org.project.projet.data.repository;

import org.project.projet.data.models.Detail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailRespository extends JpaRepository<Detail, Long> {
    Page<Detail> findByCommandeId(Long commandeId, Pageable pageable);
    List<Detail> findByCommandeId(Long commandeId);

}
