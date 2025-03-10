package org.project.projet.web.controllers;

import jakarta.validation.Valid;
import org.project.projet.web.dto.request.CommandeRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/commandes")
public interface CommandeController {
    @PostMapping("")
    ResponseEntity<?> create(@Valid @RequestBody CommandeRequestDto commandeRequestDto, BindingResult bindingResult);
}
