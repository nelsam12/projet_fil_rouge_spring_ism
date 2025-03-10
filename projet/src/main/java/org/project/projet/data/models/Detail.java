package org.project.projet.data.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int qte;
    private Float prix;
    @ManyToOne
    private Produit produit;
    @ManyToOne
    private Commande commande;
}
