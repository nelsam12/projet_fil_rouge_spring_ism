package org.project.projet.services;

import org.project.projet.data.models.Categorie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategorieService {
    Page<Categorie> findAllPaginate(Pageable pageable);
    List<Categorie> findAll();
    Categorie findById(Long id);
}
