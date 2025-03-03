package org.project.projet.web.dto.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Builder
public class CategorieWithProduitsDto {
    private Long id;
    private String nom;
    private List<ProduitDto> produits;
    private HttpStatus status;
    private Integer currentPage;
    private Integer totalPages;
    private Boolean isFirst;
    private Boolean isLast;
}
