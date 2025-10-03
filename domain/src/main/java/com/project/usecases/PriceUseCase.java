package com.project.usecases;

import com.project.exceptions.ErrorCode;
import com.project.exceptions.ZaraException;
import com.project.model.Price;
import com.project.ports.driving.PricePort;
import com.project.services.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PriceUseCase implements PricePort {

    private final PriceService priceService;

    @Override
    public Price getPrice(LocalDateTime date, Integer productId, Integer brandId) {
        List<Price> prices = priceService.getPrice(date, productId, brandId);
        return prices.stream().findFirst()
                .orElseThrow(() -> new ZaraException(ErrorCode.PRICE_NOT_FOUND, "Price is not in database"));
    }
}
