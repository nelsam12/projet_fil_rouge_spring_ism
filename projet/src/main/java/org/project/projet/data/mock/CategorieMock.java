package org.project.projet.data.mock;

import lombok.RequiredArgsConstructor;
import org.project.projet.data.models.Categorie;

import org.project.projet.data.repository.CategorieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Order(1)
@RequiredArgsConstructor
@Component
public class CategorieMock implements CommandLineRunner {
    private final CategorieRepository categorieRepository;

    @Override
    public void run(String... args){
        List<Categorie> categories = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Categorie categorie = new Categorie();
            categorie.setName(String.format("Categorie_%s", i));
            categories.add(categorie);
        }
        categorieRepository.saveAllAndFlush(categories);
    }
}
