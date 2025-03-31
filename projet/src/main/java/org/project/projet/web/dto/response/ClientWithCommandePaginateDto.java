package org.project.projet.web.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClientWithCommandePaginateDto {
  private ClientSampleDto client;
  private List<CommandeReponseDto> commandes;
//  private Integer currentPage;
//  private Integer totalPages;
//  private Boolean isFirst;
//  private Boolean isLast;
//  private int[] pages;
}
