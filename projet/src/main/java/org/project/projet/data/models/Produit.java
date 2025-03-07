package org.project.projet.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Produit extends AbstractEntity {
    private Float oldPrice;
    private Float newPrice;
    private Integer quantiteStock;
    private String image;
    private String description;
    private int notation;
    private boolean sold;

    @ManyToOne
    private Categorie categorie;
}
