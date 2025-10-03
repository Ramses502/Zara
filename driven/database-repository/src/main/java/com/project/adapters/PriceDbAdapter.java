package com.project.adapters;

import com.project.mappers.PriceDbMapper;
import com.project.model.Price;
import com.project.ports.driven.PriceDbPort;
import com.project.repositories.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PriceDbAdapter implements PriceDbPort {

    private final PriceRepository priceRepository;
    private final PriceDbMapper mapper;

    @Override
    public List<Price> getPrice(LocalDateTime date, Integer productId, Integer brandId) {
        return priceRepository.getPrice(date, productId, brandId)
                .stream().map(mapper::toDomain).toList();
    }
}
