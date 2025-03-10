package org.project.projet.data.mock;

import lombok.RequiredArgsConstructor;
import org.project.projet.data.models.Client;
import org.project.projet.data.models.Commande;
import org.project.projet.data.models.Detail;
import org.project.projet.data.models.Produit;
import org.project.projet.data.repository.ClientRepository;
import org.project.projet.data.repository.ProduitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Component
@Order(3)
public class ClientMock implements CommandLineRunner {
    private final ClientRepository clientRepository;
    private final ProduitRepository produitRepository;

    @Override
    public void run(String... args){
        List<Client> clients = clientRepository.findAll();
        if (clients.isEmpty()) {
            for (int i = 0; i < 10; i++) {
                Client client = new Client();
                client.setFirstName(String.format("John_%s", i+1));
                client.setLastName(String.format("Doe_%s", i+1));
                client.setPhone(String.format("78965432%s", i));
                client.setEmail(String.format("john.doe%s@gmail.com", i+1));
                client.setCommandes(getCommandes(client));
                clients.add(client);
            }
            clientRepository.saveAll(clients);
        }
    }

    public List<Commande> getCommandes(Client client) {
        List<Commande> commandes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Commande commande = new Commande();
            commande.setDate(new Date());
            commande.setDetails(getDetails(commande));
            commande.setClient(client);
            commande.setMontant((float)commande.getDetails().stream().mapToDouble(Detail::getPrix).sum());
            commandes.add(commande);
        }
        return commandes;
    }

    public List<Detail> getDetails(Commande commande) {
        List<Detail> details = new ArrayList<>();
        List<Produit> produits = produitRepository.findAll();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            var prod = produits.get(random.nextInt(produits.size()));
            Detail detail = new Detail();
            detail.setQte(random.nextInt(prod.getQuantiteStock()));
            detail.setPrix(prod.getOldPrice());
            detail.setProduit(prod);
            detail.setCommande(commande);
            details.add(detail);
        }
        return details;
    }
}
