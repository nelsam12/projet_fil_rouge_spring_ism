package org.project.projet.web.controllers;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@RequestMapping("/api/categories")
public interface CategorieController {
    @GetMapping("")
    public ResponseEntity<Map<String, Object>> findAllPaginate(Pageable pageable,
                                                               @RequestParam(defaultValue = "0") int page,
                                                               @RequestParam(defaultValue = "5")  int size);

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id);

    @GetMapping("/{id}/products")
    public ResponseEntity<Map<String, Object>> findCategorieWithProducts(@PathVariable Long id, Pageable pageable,
                                                                         @RequestParam(defaultValue = "0") int page,
                                                                         @RequestParam(defaultValue = "5")  int size);

}
