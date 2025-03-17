package org.project.projet.web.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class CommandeReponseWithDetailDto {
    private CommandeReponseDto commande;
    private List<DetailCommandeResponse> details;
}
