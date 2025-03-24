package org.project.projet.services.impl;

import lombok.RequiredArgsConstructor;
import org.project.projet.data.models.Commande;
import org.project.projet.data.repository.ClientRepository;
import org.project.projet.data.repository.CommandeRepository;
import org.project.projet.data.repository.ProduitRepository;
import org.project.projet.services.CommandeService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommandeServiceImpl implements CommandeService {
    private final CommandeRepository commandeRepository;
    private final ClientRepository clientRepository;
    private final ProduitRepository produitRepository;
    @Override
    public Commande create(Commande commande) {
        var client = clientRepository.findById(commande.getClient().getId()).orElse(null);
        if (client == null) {
            return null;
        }
        commande = commandeRepository.save(commande);
        for (var d: commande.getDetails()){
            var prod = produitRepository.findById(d.getProduit().getId()).orElse(null);
            if (prod != null) {
                prod.setQuantiteStock(prod.getQuantiteStock() - d.getQte());
                produitRepository.save(prod);
            }
        }
        return commande;
    }
}
