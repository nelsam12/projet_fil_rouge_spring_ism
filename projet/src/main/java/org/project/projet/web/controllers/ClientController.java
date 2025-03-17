package org.project.projet.web.controllers;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@RequestMapping("/api/clients")
public interface ClientController {
    @GetMapping("/v1")
    public ResponseEntity<?> getAll();
    @GetMapping("")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "5")  int size);

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id);



}
