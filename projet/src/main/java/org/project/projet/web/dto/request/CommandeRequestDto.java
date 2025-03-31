package org.project.projet.web.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class CommandeRequestDto {
    @NotNull(message = "Le montant est obligatoire")
    private Float montant;
    @NotNull(message = "La date est obligatoire")
    private LocalDate date;
    @NotNull(message = "L'id du client est obligatoire")
    private Long clientId;
    @NotNull(message = "La liste des détails est obligatoire")
    private List<DetailRequestDto> details;
}
