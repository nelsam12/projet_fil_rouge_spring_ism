package org.project.projet.services.impl;

import lombok.RequiredArgsConstructor;
import org.project.projet.data.models.Categorie;
import org.project.projet.data.models.Produit;
import org.project.projet.data.repository.CategorieRepository;
import org.project.projet.exceptions.EntityNotFoundExceptions;
import org.project.projet.services.CategorieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategorieServiceImpl implements CategorieService {
    private final CategorieRepository categorieRepository;
    @Override
    public Page<Categorie> findAllPaginate(Pageable pageable) {
        return categorieRepository.findAll(pageable);
    }

    @Override
    public List<Categorie> findAll() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie findById(Long id) {
        return categorieRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundExceptions("Categorie with id " + id + " not found")
        );
    }
}
