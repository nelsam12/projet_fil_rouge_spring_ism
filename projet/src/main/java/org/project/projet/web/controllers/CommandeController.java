package org.project.projet.web.controllers;

import jakarta.validation.Valid;
import org.project.projet.web.dto.request.CommandeRequestDto;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequestMapping("/api/commandes")
public interface CommandeController {
    @PostMapping("")
    ResponseEntity<?> create(@Valid @RequestBody CommandeRequestDto commandeRequestDto, BindingResult bindingResult);

    @GetMapping("/client/{id}")
    ResponseEntity<?> getByClientId(@PathVariable Long id,
                                    @RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "3") int size);

    @GetMapping("")
    ResponseEntity<?> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5")  int size
    );

    @GetMapping("/{id}")
    ResponseEntity<?> getById(@PathVariable Long id,
                              @RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "3") int size);

    @GetMapping("/by-date")
    ResponseEntity<?> getByDate(@RequestParam() String date,
                                @RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "3") int size);
}
