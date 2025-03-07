package org.project.projet.data.repository;

import org.project.projet.data.models.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    @NonNull
    Page<Produit> findAll(@NonNull Pageable pageable);
    Page<Produit> findByCategorieId(@NonNull Long categorieId, @NonNull Pageable pageable);
    List<Produit> findByCategorieId(@NonNull Long categorieId);
}
