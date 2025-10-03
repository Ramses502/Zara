package com.project.apis;

import com.project.model.PriceDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@RequestMapping("/price")
public interface PricesApi {

    @GetMapping
    PriceDto getPrice(@RequestParam LocalDateTime date,
                      @RequestParam Integer productId,
                      @RequestParam Integer brandId);
}
