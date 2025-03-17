package org.project.projet.web.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DetailCommandeResponse {
    private Long id;
    private int qte;
    private Float montant;
}
