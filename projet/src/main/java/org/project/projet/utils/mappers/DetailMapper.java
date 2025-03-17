package org.project.projet.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.project.projet.data.models.Detail;
import org.project.projet.web.dto.response.DetailCommandeResponse;

@Mapper
public interface DetailMapper {
    DetailMapper INSTANCE = Mappers.getMapper(DetailMapper.class);
    DetailCommandeResponse toDto(Detail detail);
    Detail toEntity(Detail detailDto);
}
