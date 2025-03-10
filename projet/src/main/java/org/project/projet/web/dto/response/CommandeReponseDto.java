package org.project.projet.web.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class CommandeReponseDto {
    private Long id;
    private Float montant;
    private Date date;
}
