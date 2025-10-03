package com.project.controllers;

import com.project.apis.PricesApi;
import com.project.mappers.PriceMapper;
import com.project.model.PriceDto;
import com.project.ports.driving.PricePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class PricesController implements PricesApi {

    private final PricePort pricePort;
    private final PriceMapper mapper;

    @Override
    public PriceDto getPrice(LocalDateTime date, Integer productId, Integer brandId) {
        return mapper.toDto(pricePort.getPrice(date, productId, brandId));
    }
}
