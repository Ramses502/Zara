package com.project.ports.driving;

import com.project.model.Price;

import java.time.LocalDateTime;

public interface PricePort {
    Price getPrice(LocalDateTime date, Integer productId, Integer brandId);
}
