package org.project.projet.data.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float montant;
    private LocalDate date;
    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "commande", cascade = CascadeType.PERSIST)
    private List<Detail> details;
}
