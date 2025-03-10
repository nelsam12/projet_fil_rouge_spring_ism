package org.project.projet.utils.mappers.impl;

import org.project.projet.data.models.Commande;
import org.project.projet.data.models.Detail;
import org.project.projet.data.models.Produit;
import org.project.projet.web.dto.request.DetailRequestDto;

public class DetailMapper {
    public static Detail toEntity(DetailRequestDto requestDto, Commande commande) {
        Detail detail = new Detail();
        Produit produit = new Produit();
        produit.setId(requestDto.getProduitId());
        detail.setQte(requestDto.getQte());
        detail.setPrix(requestDto.getPrix());
        detail.setProduit(produit);
        detail.setCommande(commande);
        return detail;
    }
}
