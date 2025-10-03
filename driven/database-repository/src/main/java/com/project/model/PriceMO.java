package com.project.model;

import com.project.model.pks.PricePK;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "PRICES")
@IdClass(PricePK.class)
public class PriceMO {

    @Id
    @Column(name = "PRICE_LIST")
    private Integer priceList;

    @Id
    @Column(name = "PRODUCT_ID")
    private Integer productId;

    @Column(name = "BRAND_ID")
    private Integer brandId;

    @Column(name = "START_DATE")
    private LocalDateTime  startDate;

    @Column(name = "END_DATE")
    private LocalDateTime  endDate;

    @Column(name = "PRIORITY")
    private Integer priority;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "CURR")
    private String currency;
}
