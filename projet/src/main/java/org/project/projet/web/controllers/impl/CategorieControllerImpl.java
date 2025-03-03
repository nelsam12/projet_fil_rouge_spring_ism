package org.project.projet.web.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.project.projet.data.models.Categorie;
import org.project.projet.data.models.Produit;
import org.project.projet.services.CategorieService;
import org.project.projet.services.ProduitService;
import org.project.projet.utils.mappers.CategorieMapper;
import org.project.projet.utils.mappers.ProduitMapper;
import org.project.projet.web.controllers.CategorieController;
import org.project.projet.web.dto.RestResponse;
import org.project.projet.web.dto.response.CategorieDto;
import org.project.projet.web.dto.response.CategorieWithProduitsDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CategorieControllerImpl implements CategorieController {
    private final CategorieService categorieService;
    private final ProduitService produitService;
    @Override
    public ResponseEntity<Map<String, Object>> findAllPaginate(Pageable pageable, int page, int size) {
        Page<Categorie> result = categorieService.findAllPaginate(PageRequest.of(page, size));
        var categorieDtos = result.getContent().stream().map(CategorieMapper.INSTANCE::toDto);
        Map<String, Object> model = RestResponse.responsePaginate(
                HttpStatus.OK,
                categorieDtos,
                result.getNumber(),
                result.getTotalPages(),
                result.isFirst(),
                result.isLast(),
                "CategoriePaginateDto"
        );

        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> findById(Long id) {
        Categorie categorie = categorieService.findById(id);
        if (categorie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        var categorieDto = CategorieMapper.INSTANCE.toDto(categorie);

        Map<String, Object> model = RestResponse.response(
                HttpStatus.OK,
                categorieDto,
                "CategorieDto"
        );
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> findCategorieWithProducts(Long id, Pageable pageable, int page, int size) {
        Categorie categorie = categorieService.findById(id);
        Page<Produit> result = produitService.findByCategorieId(id, PageRequest.of(page, size));
        var produitsDto = result.getContent().stream().map(ProduitMapper.INSTANCE::toDto).toList() ;
        if (categorie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        var categorieWithProduitsDto = CategorieWithProduitsDto
                .builder()
                .produits(produitsDto)
                .nom(categorie.getName())
                .currentPage(result.getNumber())
                .totalPages(result.getTotalPages())
                .id(categorie.getId())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .status(HttpStatus.OK)
                .build();

        System.out.println(categorieWithProduitsDto);

        Map<String, Object> model = RestResponse.response(
                HttpStatus.OK,
                categorieWithProduitsDto,
                "categorieWithProduitsDto"
        );

        return new ResponseEntity<>(model, HttpStatus.OK);
    }
}
