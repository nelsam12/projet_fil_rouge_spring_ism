package org.project.projet.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

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
    @OneToMany(mappedBy = "produit")
    private List<Detail> details;
    @ManyToOne
    private Categorie categorie;
}
