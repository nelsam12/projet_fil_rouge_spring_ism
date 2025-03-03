package org.project.projet.web.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProduitCatalogueDto {
    private Long id;
    private String name;
    private String  image;
    private Float oldPrice;
    private Float newPrice;
    private boolean sold;
    private int notation ;
}
