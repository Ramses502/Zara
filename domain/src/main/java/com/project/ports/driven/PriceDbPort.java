package com.project.ports.driven;

import com.project.model.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceDbPort {
    List<Price> getPrice(LocalDateTime date, Integer productId, Integer brandId);
}
