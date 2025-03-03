package org.project.projet.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.project.projet.data.models.Categorie;
import org.project.projet.web.dto.response.CategorieDto;
import org.project.projet.web.dto.response.CategorieWithProduitsDto;

@Mapper
public interface CategorieMapper {
    CategorieMapper INSTANCE = Mappers.getMapper(CategorieMapper.class);

//    Conversion Categorie > CategorieDto
    CategorieDto toDto(Categorie categorie);

//    Conversion CategorieDto > Categorie
    Categorie toEntity(CategorieDto categorieDto);

    //    Conversion to CategorieWithProduitsPaginateDto
//    Conversion to CategorieWithProduitsDto
    CategorieWithProduitsDto toWithProduitsDto(Categorie categorie);



}
