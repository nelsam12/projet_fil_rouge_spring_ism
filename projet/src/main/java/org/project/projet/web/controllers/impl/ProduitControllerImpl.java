package org.project.projet.web.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.project.projet.data.models.Produit;
import org.project.projet.services.ProduitService;
import org.project.projet.utils.mappers.ProduitMapper;
import org.project.projet.web.controllers.ProduitController;
import org.project.projet.web.dto.RestResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
public class ProduitControllerImpl implements ProduitController {
    private final ProduitService produitService;

    @Override
    public ResponseEntity<?> getAll() {
        var produitsDto = produitService.findAll().stream().map(ProduitMapper.INSTANCE::toDtoCatalogue);

//        Map<String, Object> response = RestResponse.response(
//                HttpStatus.OK,
//                produitsDto,
//                "ProduitCatalogueDto"
//        );

        return new ResponseEntity<>(produitsDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getAll(Pageable pageable, int page, int size) {
        Page<Produit> result = produitService.findAllPaginate(PageRequest.of(page, size));
        return getMapResponseEntity(result);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getById(Long id) {
        Produit produit = produitService.findById(id);
        if (produit == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        var produitDto = ProduitMapper.INSTANCE.toDto(produit);
        Map<String, Object> response = RestResponse.response(
                HttpStatus.OK,
                produitDto,
                "ProduitDto"
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getByCategorieId(Long categorieId, Pageable pageable, int page, int size) {
        Page<Produit> result = produitService.findByCategorieId(categorieId, PageRequest.of(page, size));
        return getMapResponseEntity(result);
    }

//    Simplification du code
    private ResponseEntity<Map<String, Object>> getMapResponseEntity(Page<Produit> result) {
        var produitsDto = result.getContent().stream().map(ProduitMapper.INSTANCE::toDto);
        Map<String, Object> response = RestResponse.responsePaginate(
                HttpStatus.OK,
                produitsDto,
                result.getNumber(),
                result.getTotalPages(),
                result.isFirst(),
                result.isLast(),
                "ProduitDtoPaginate"
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
