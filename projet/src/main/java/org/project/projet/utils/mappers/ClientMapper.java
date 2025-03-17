package org.project.projet.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.project.projet.data.models.Categorie;
import org.project.projet.data.models.Client;
import org.project.projet.web.dto.response.CategorieDto;
import org.project.projet.web.dto.response.CategorieWithProduitsDto;
import org.project.projet.web.dto.response.ClientSampleDto;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

//    Conversion Client > ClientSampleDto
    ClientSampleDto toDto(Client client);

//    Conversion ClientSampleDto > ClientSampleDto
    Client toEntity(ClientSampleDto clientDto);


}
