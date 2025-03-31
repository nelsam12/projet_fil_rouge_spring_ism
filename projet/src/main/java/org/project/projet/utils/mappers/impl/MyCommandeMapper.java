package org.project.projet.utils.mappers.impl;

import org.project.projet.data.models.Client;
import org.project.projet.data.models.Commande;
import org.project.projet.web.dto.request.CommandeRequestDto;

import java.util.stream.Collectors;

public class MyCommandeMapper {
    public static Commande toEntity(CommandeRequestDto requestDto) {
        Client client = new Client();
        client.setId(requestDto.getClientId());
        Commande commande = new Commande();
        commande.setMontant(requestDto.getMontant());
        commande.setDate(requestDto.getDate());
        commande.setClient(client);
        commande.setDetails(requestDto.getDetails().stream().map(detail -> DetailMapper.toEntity(detail,commande)).toList());
        return commande;
    }
}
