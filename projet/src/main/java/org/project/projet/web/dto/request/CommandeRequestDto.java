package org.project.projet.web.dto.request;

import org.project.projet.data.models.Client;
import org.project.projet.data.models.Detail;

import java.util.Date;
import java.util.List;

public class CommandeRequestDto {
    private Long id;
    private Float montant;
    private Date date;
    private Client client;
    private List<Detail> details;
}
