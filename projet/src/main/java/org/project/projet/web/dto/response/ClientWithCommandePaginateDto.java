package org.project.projet.web.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClientWithCommandePaginateDto {
    private ClientSampleDto client;
    List<CommandeReponseDto> commandes;
}
