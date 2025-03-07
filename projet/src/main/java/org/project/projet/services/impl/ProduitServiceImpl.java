package org.project.projet.services.impl;

import lombok.RequiredArgsConstructor;
import org.project.projet.data.models.Categorie;
import org.project.projet.data.models.Produit;
import org.project.projet.data.repository.ProduitRepository;
import org.project.projet.exceptions.EntityNotFoundExceptions;
import org.project.projet.services.ProduitService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProduitServiceImpl implements ProduitService {
    private final ProduitRepository produitRepository;
    @Override
    public Page<Produit> findAllPaginate(Pageable pageable) {
        return produitRepository.findAll(pageable);
    }

    @Override
    public List<Produit> findAll() {
        return produitRepository.findAll();
    }

    @Override
    public Produit findById(Long id) {
        return produitRepository.findById(id).orElseThrow(() -> new EntityNotFoundExceptions("Produit with id " + id + " not found"));
    }

    @Override
    public Produit save(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public Page<Produit> findByCategorieId(Long categorieId, Pageable pageable) {
        return produitRepository.findByCategorieId(categorieId, pageable);
    }

    @Override
    public List<Produit> findByCategorieId(Long categorieId) {
        return produitRepository.findByCategorieId(categorieId);
    }
}
