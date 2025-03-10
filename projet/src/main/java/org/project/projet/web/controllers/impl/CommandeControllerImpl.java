package org.project.projet.web.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.project.projet.services.CommandeService;
import org.project.projet.utils.mappers.impl.CommandeMapper;
import org.project.projet.web.controllers.CommandeController;
import org.project.projet.web.dto.request.CommandeRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class CommandeControllerImpl implements CommandeController {
    private final CommandeService commandeService;
    @Override
    public ResponseEntity<?> create(CommandeRequestDto commandeRequestDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
        var commande = CommandeMapper.toEntity(commandeRequestDto);
        commande = commandeService.create(commande);
        if (commande == null) {
            return ResponseEntity.badRequest().body("Le client n'existe pas");
        }
        return new ResponseEntity<>(org.project.projet.utils.mappers.CommandeMapper.INSTANCE.toDto(commande), HttpStatus.CREATED);
    }
}
