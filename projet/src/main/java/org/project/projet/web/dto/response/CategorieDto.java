package org.project.projet.web.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategorieDto {
    private Long id;
    private String nom;
}
