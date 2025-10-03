package com.project.mappers;

import com.project.model.Price;
import com.project.model.PriceDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    PriceDto toDto(Price price);
}
