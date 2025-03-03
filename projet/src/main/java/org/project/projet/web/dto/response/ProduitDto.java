package org.project.projet.web.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProduitDto {
    private Long id;
    private String nom;
    private Integer quantiteStock;
    private Float prix;
    private CategorieSampleDto categorie;
}
