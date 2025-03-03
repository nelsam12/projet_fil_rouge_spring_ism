package org.project.projet.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Categorie extends AbstractEntity {
    @OneToMany(mappedBy = "categorie")
    private List<Produit> produits = new ArrayList<>();
}
