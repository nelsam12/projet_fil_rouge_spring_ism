package org.project.projet.web.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetailRequestDto {
    @NotNull
    private int qte;
    @NotNull
    private Float prix;
    @NotNull
    private Long produitId;
}
