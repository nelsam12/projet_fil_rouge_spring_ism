package org.project.projet.services;


import org.project.projet.data.models.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProduitService {
    Page<Produit> findAllPaginate(Pageable pageable);
    List<Produit> findAll();
    Produit findById(Long id);
    Produit save(Produit produit);
    Page<Produit> findByCategorieId(Long categorieId, Pageable pageable);
    List<Produit> findByCategorieId(Long categorieId);
}
