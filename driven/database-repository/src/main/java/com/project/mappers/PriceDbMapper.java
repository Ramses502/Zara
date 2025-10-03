package com.project.mappers;

import com.project.model.Price;
import com.project.model.PriceMO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceDbMapper {

    Price toDomain(PriceMO priceMo);
}
