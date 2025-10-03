package com.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Price {

    private Integer priceList;
    private Integer productId;
    private Integer brandId;
    private LocalDateTime startDate;
    private LocalDateTime  endDate;
    private Integer priority;
    private Double price;
    private String currency;
}
