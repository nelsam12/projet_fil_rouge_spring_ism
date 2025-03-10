package org.project.projet.web.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ProduitCatalogueSelectedWithRelatedDto {
    private  ProduitCatalogueDto produit;
    private List<ProduitCatalogueDto> relatedProducts;
}
