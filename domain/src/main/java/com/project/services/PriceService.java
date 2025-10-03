package com.project.services;

import com.project.model.Price;
import com.project.ports.driven.PriceDbPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PriceService {

    private final PriceDbPort priceDbPort;

    public List<Price> getPrice(LocalDateTime date, Integer productId, Integer brandId) {
        return priceDbPort.getPrice(date, productId, brandId);
    }
}
