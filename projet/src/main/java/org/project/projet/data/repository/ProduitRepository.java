package org.project.projet.data.repository;

import org.project.projet.data.models.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    @NonNull
    Page<Produit> findAll(@NonNull Pageable pageable);
    Page<Produit> findByCategorieId(@NonNull Long categorieId, @NonNull Pageable pageable);
}
