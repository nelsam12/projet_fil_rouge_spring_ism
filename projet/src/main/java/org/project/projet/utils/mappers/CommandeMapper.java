package org.project.projet.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.project.projet.data.models.Client;
import org.project.projet.data.models.Commande;
import org.project.projet.web.dto.request.CommandeRequestDto;
import org.project.projet.web.dto.response.ClientWithCommandePaginateDto;
import org.project.projet.web.dto.response.CommandeReponseDto;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper
public interface CommandeMapper {
    CommandeMapper INSTANCE = Mappers.getMapper(CommandeMapper.class);

    CommandeReponseDto toDto(Commande commande);

    Commande toEntity(CommandeRequestDto requestDto);
}
