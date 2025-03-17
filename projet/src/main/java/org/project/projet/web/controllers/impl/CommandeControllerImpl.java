package org.project.projet.web.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.project.projet.data.models.Client;
import org.project.projet.data.models.Commande;
import org.project.projet.data.models.Detail;
import org.project.projet.services.ClientService;
import org.project.projet.services.CommandeService;
import org.project.projet.services.DetailService;
import org.project.projet.utils.mappers.ClientMapper;
import org.project.projet.utils.mappers.CommandeMapper;
import org.project.projet.utils.mappers.DetailMapper;
import org.project.projet.web.controllers.CommandeController;
import org.project.projet.web.dto.RestResponse;
import org.project.projet.web.dto.request.CommandeRequestDto;
import org.project.projet.web.dto.response.ClientWithCommandePaginateDto;
import org.project.projet.web.dto.response.CommandeReponseWithDetailDto;
import org.project.projet.web.dto.response.DetailCommandeResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@RestController
public class CommandeControllerImpl implements CommandeController {
    private final CommandeService commandeService;
    private final DetailService detailService;
    private final ClientService clientService;
    @Override
    public ResponseEntity<?> create(CommandeRequestDto commandeRequestDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
        var commande = CommandeMapper.INSTANCE.toEntity(commandeRequestDto);
        commande = commandeService.create(commande);
        if (commande == null) {
            return ResponseEntity.badRequest().body("Le client n'existe pas");
        }
        return new ResponseEntity<>(org.project.projet.utils.mappers.CommandeMapper.INSTANCE.toDto(commande), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getByClientId(Long id, int page, int size) {
        Client client = clientService.findById(id);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        Page<Commande> commandePage = commandeService.findByClientPaginate(client.getId(), PageRequest.of(page, size));
        ClientWithCommandePaginateDto response = ClientWithCommandePaginateDto.builder()
                .commandes(commandePage.getContent().stream().map(CommandeMapper.INSTANCE::toDto).toList())
                .client(ClientMapper.INSTANCE.toDto(client))
                .build()
                ;

        var result = RestResponse.responsePaginate(
                HttpStatus.OK,
                response,
                commandePage.getNumber(),
                commandePage.getTotalPages(),
                commandePage.isFirst(),
                commandePage.isLast(),
                "ClientWithCommandePaginate"
        ) ;
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Commande> commandePage = commandeService.findAll(pageable);
        var data = commandePage.getContent().stream().map(CommandeMapper.INSTANCE::toDto).toList();
        var currentPage = commandePage.getNumber();
        var totalPages = commandePage.getTotalPages();
        var isFirst = commandePage.isFirst();
        var isLast = commandePage.isLast();
        return new ResponseEntity<>(
                RestResponse.responsePaginate(
                        HttpStatus.OK,
                        data,
                        currentPage,
                        totalPages,
                        isFirst,
                        isLast,
                        "CommandeResponseDtoPaginate"
                ),
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<?> getById(Long id, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        var commande = CommandeMapper.INSTANCE.toDto(commandeService.getById(id));
        Page<Detail> detailPage = detailService.findByCommandeId(id, pageable);
        List<DetailCommandeResponse> detailCommandeResponses = detailPage.stream().map(detail -> {
            return DetailCommandeResponse.builder()
                    .qte(detail.getQte())
                    .montant(detail.getPrix())
                    .id(detail.getId())
                    .build();
        }).toList();
        System.out.println(detailCommandeResponses);
        var result = CommandeReponseWithDetailDto.builder()
                .commande(commande)
                .details(detailCommandeResponses)
                .build();
        var currentPage = detailPage.getNumber();
        var totalItems = detailPage.getTotalPages();
        var isFirst=        detailPage.isFirst();
        var isLast = detailPage.isLast();
        return new ResponseEntity<>(
                RestResponse.responsePaginate(
                        HttpStatus.OK,
                        result,
                        currentPage,
                        totalItems,
                        isFirst,
                        isLast,
                        "CommandeResponseDtoWithDetail"
                ),
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<?> getByDate(String date, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Date dateObjet= null;
        try {
            dateObjet = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println(dateObjet.getDate());
        Page<Commande> commandePage = commandeService.getByDate(dateObjet, pageable);

        return new ResponseEntity<>(
                RestResponse.responsePaginate(
                        HttpStatus.OK,
                        commandePage.getContent(),
                        commandePage.getNumber(),
                        commandePage.getTotalPages(),
                        commandePage.isFirst(),
                        commandePage.isLast(),
                        "CommandeResponseDtoWithDetailFilteredByDate"
                ),
                HttpStatus.OK

        );

    }
}
