package org.project.projet.data.repository;

import org.project.projet.data.models.Categorie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    @NonNull
    Page<Categorie> findAll(@NonNull  Pageable pageable);
}
