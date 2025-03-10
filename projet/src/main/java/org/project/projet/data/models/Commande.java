package org.project.projet.data.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float montant;
    private Date date;
    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "commande", cascade = CascadeType.PERSIST)
    private List<Detail> details;
}
