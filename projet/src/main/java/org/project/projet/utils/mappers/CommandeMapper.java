package org.project.projet.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.project.projet.data.models.Commande;
import org.project.projet.web.dto.response.CommandeReponseDto;

@Mapper
public interface CommandeMapper {
    CommandeMapper INSTANCE = Mappers.getMapper(CommandeMapper.class);

    CommandeReponseDto toDto(Commande commande);
}
