package org.project.projet.web.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.project.projet.data.models.Client;
import org.project.projet.data.models.Produit;
import org.project.projet.exceptions.EntityNotFoundExceptions;
import org.project.projet.services.ClientService;
import org.project.projet.services.ProduitService;
import org.project.projet.utils.mappers.ClientMapper;
import org.project.projet.utils.mappers.ProduitMapper;
import org.project.projet.web.controllers.ClientController;
import org.project.projet.web.controllers.ProduitController;
import org.project.projet.web.dto.RestResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class ClientControllerImpl implements ClientController {
    private final ClientService clientService;


    @Override
    public ResponseEntity<?> getAll() {

        return new ResponseEntity<>(
                RestResponse.response(
                        HttpStatus.OK,
                        clientService.findAll().stream().map(ClientMapper.INSTANCE::toDto).toList(),
                        "ClientNotPaginateResponse"
                ),
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<?> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Client> clients = clientService.findAll(pageable);
        var data = clients.getContent().stream().map(ClientMapper.INSTANCE::toDto);
        var currentPage = clients.getNumber();
        var isFirstPage = clients.isFirst();
        var isLastPage = clients.isLast();
        var totalPages = clients.getTotalPages();
        return new ResponseEntity<>(
                RestResponse.responsePaginate(
                        HttpStatus.OK,
                        data,
                        currentPage,
                        totalPages,
                        isFirstPage,
                        isLastPage,
                        "ClientPaginateResponse"
                        ),
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<Map<String, Object>> getById(Long id) {
        return null;
    }
}
