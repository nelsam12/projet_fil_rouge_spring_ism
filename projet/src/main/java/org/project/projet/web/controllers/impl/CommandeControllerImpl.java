package org.project.projet.web.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.project.projet.data.models.Client;
import org.project.projet.data.models.Commande;
import org.project.projet.data.models.Detail;
import org.project.projet.data.models.Produit;
import org.project.projet.services.ClientService;
import org.project.projet.services.CommandeService;
import org.project.projet.services.DetailService;
import org.project.projet.utils.mappers.ClientMapper;
import org.project.projet.utils.mappers.CommandeMapper;
import org.project.projet.utils.mappers.DetailMapper;
import org.project.projet.utils.mappers.ProduitMapper;
import org.project.projet.utils.mappers.impl.MyCommandeMapper;
import org.project.projet.web.controllers.CommandeController;
import org.project.projet.web.dto.RestResponse;
import org.project.projet.web.dto.request.CommandeRequestDto;
import org.project.projet.web.dto.response.ClientSampleDto;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        System.out.println(commandeRequestDto);
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
        Commande commande = MyCommandeMapper.toEntity(commandeRequestDto);

        commande = commandeService.create(commande);
        if (commande == null) {
            return ResponseEntity.badRequest().body("Le client n'existe pas");
        }
        var commandeDto = org.project.projet.utils.mappers.CommandeMapper.INSTANCE.toDto(commande);
        var result = RestResponse.response(
                HttpStatus.CREATED,
                commandeDto,
                "CommandeResponse"
        );
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getByClientId(Long id, int page, int size) {
        Client client = clientService.findById(id);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }

        Page<Commande> commandePage = commandeService.findByClientPaginate(client.getId(), PageRequest.of(page, size));
//        ClientWithCommandePaginateDto response = ClientWithCommandePaginateDto.builder()
//                .commandes(commandePage.getContent().stream().map(CommandeMapper.INSTANCE::toDto).toList())
//                .client(ClientMapper.INSTANCE.toDto(client))
//                .build();
        ClientSampleDto clientSampleDto = ClientMapper.INSTANCE.toDto(client);
        var response = getMapResponseEntity(commandePage, clientSampleDto, "ClientWithCommandePaginate");

//        var result = RestResponse.responsePaginate(
//                HttpStatus.OK,
//                response,
//                commandePage.getNumber(),
//                commandePage.getTotalPages(),
//                commandePage.isFirst(),
//                commandePage.isLast(),
//                "ClientWithCommandePaginate"
//        ) ;
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @Override
//    public ResponseEntity<?> getAll(int page, int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        Page<Commande> commandePage = commandeService.findAll(pageable);
//        var data = commandePage.getContent().stream().map(CommandeMapper.INSTANCE::toDto).toList();
//        var currentPage = commandePage.getNumber();
//        var totalPages = commandePage.getTotalPages();
//        var isFirst = commandePage.isFirst();
//        var isLast = commandePage.isLast();
//        return new ResponseEntity<>(
//                RestResponse.responsePaginate(
//                        HttpStatus.OK,
//                        data,
//                        currentPage,
//                        totalPages,
//                        isFirst,
//                        isLast,
//                        "CommandeResponseDtoPaginate"
//                ),
//                HttpStatus.OK
//        );
//    }

    @Override
    public ResponseEntity<?> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Commande> commandePage = commandeService.findAll(pageable);
        var data = commandePage.getContent().stream().map(CommandeMapper.INSTANCE::toDto).toList();
        System.out.println(data);
//        var currentPage = commandePage.getNumber();
//        var totalPages = commandePage.getTotalPages();
//        var isFirst = commandePage.isFirst();
//        var isLast = commandePage.isLast();
        var response = getMapResponseEntity(commandePage, null, "UserWithCommandePaginate");
//        ClientWithCommandePaginateDto
        return new ResponseEntity<>(
//                RestResponse.responsePaginate(
//                        HttpStatus.OK,
//                        data,
//                        currentPage,
//                        totalPages,
//                        isFirst,
//                        isLast,
//                        "CommandeResponseDtoPaginate"
//                ),
                response,
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

        var result = CommandeReponseWithDetailDto.builder()
                .commande(commande)
                .details(detailCommandeResponses)
                .build();
        var currentPage = detailPage.getNumber();
        var totalItems = detailPage.getTotalPages();
        var isFirst = detailPage.isFirst();
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
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Format de date invalide. Utilise yyyy/MM/dd.");
        }
        Page<Commande> commandePage = commandeService.getByDate(localDate, pageable);
        var content = commandePage.getContent().stream().map(CommandeMapper.INSTANCE::toDto).toList();
        return new ResponseEntity<>(
                RestResponse.responsePaginate(
                        HttpStatus.OK,
                        content,
                        commandePage.getNumber(),
                        commandePage.getTotalPages(),
                        commandePage.isFirst(),
                        commandePage.isLast(),
                        "CommandeResponseDtoWithDetailFilteredByDate"
                ),
                HttpStatus.OK

        );
    }

    //    Simplification du code
//    private ResponseEntity<Map<String, Object>> getMapResponseEntity(Page<Commande> result) {
//        var commandeDto = result.getContent().stream().map(CommandeMapper.INSTANCE::toDto).toList();
//        var response = RestResponse.responsePaginate(
//                HttpStatus.OK,
//                commandeDto,
//                result.getNumber(),
//                result.getTotalPages(),
//                result.isFirst(),
//                result.isLast(),
//                "CommandePaginateDto"
//        );
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }

    private Map<String, Object> getMapResponseEntity(Page<Commande> result, ClientSampleDto client, String type) {
        ClientWithCommandePaginateDto response = ClientWithCommandePaginateDto.builder()
                .commandes(result.getContent().stream().map(CommandeMapper.INSTANCE::toDto).toList())
                .client(client)
                .build();
        return RestResponse.responsePaginate(
                HttpStatus.OK,
                response,
                result.getNumber(),
                result.getTotalPages(),
                result.isFirst(),
                result.isLast(),
                type
        );
    }

    /*
     * */
}
