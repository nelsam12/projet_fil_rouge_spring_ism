package org.project.projet.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.project.projet.data.models.Produit;
import org.project.projet.web.dto.response.ProduitCatalogueDto;
import org.project.projet.web.dto.response.ProduitDto;

@Mapper
public interface ProduitMapper {
    ProduitMapper INSTANCE = Mappers.getMapper(ProduitMapper.class);
//    Conversion Produit > ProduitDto
    ProduitDto

    toDto(Produit produit);

//    Conversion ProduitDto > Produit
    Produit toEntity(ProduitDto produitDto);

    ProduitCatalogueDto toDtoCatalogue(Produit produit);

}
