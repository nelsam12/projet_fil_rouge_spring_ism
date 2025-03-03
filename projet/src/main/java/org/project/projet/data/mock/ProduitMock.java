package org.project.projet.data.mock;

import lombok.RequiredArgsConstructor;
import org.project.projet.data.models.Categorie;
import org.project.projet.data.models.Produit;
import org.project.projet.data.repository.CategorieRepository;
import org.project.projet.data.repository.ProduitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Order(2)
@RequiredArgsConstructor
@Component
public class ProduitMock implements CommandLineRunner {

    private final ProduitRepository produitRepository;
    private final CategorieRepository categorieRepository;
    @Override
    public void run(String... args){
        List<Categorie> categories = categorieRepository.findAll();
        List<Produit> produits = new ArrayList<>();
        for (Categorie c : categories) {
            for (int i = 1; i <= 10; i++) {
                Produit p = getProduit(c, i);
                produits.add(p);
            }
        }
        produitRepository.saveAll(produits);
//        categorieRepository.saveAll(categories);
    }

    private static Produit getProduit(Categorie c, int i) {
        Produit p = new Produit();
        p.setName(String.format("Produit_%s", i));
        p.setImage("https://img.freepik.com/photos-gratuite/chaussures_1203-8149.jpg");
        p.setOldPrice(3500.02f);
        p.setNewPrice(p.getOldPrice());
        p.setSold(false);
        p.setNotation(Math.min(i, 4));
        if (i % 2 == 0) {
            p.setSold(true);
            p.setNewPrice(3300.02f);
        }
        p.setQuantiteStock(40);
//                Relation Produit Categorie
        p.setCategorie(c);
        return p;
    }
}
