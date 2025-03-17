package org.project.projet.web.controllers;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@RequestMapping("/api/produits")
public interface ProduitController {
    @GetMapping("")
    public ResponseEntity<?> getAll();
    @GetMapping("/v1")
    public ResponseEntity<Map<String, Object>> getAll(@PageableDefault Pageable pageable,
                                                      @RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "5")  int size);

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable Long id);

    @GetMapping("/categorie/v1/{categorieId}")
    public ResponseEntity<Map<String, Object>> getByCategorieIdV1(@PathVariable Long categorieId,
                                                                @PageableDefault Pageable pageable,
                                                                @RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "5")  int size);

    @GetMapping("/categorie/{categorieId}")
    public ResponseEntity<?> getByCategorieId(@PathVariable Long categorieId);

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getDetail(@PathVariable Long id);

}
