package com.project.repositories;

import com.project.model.PriceMO;
import com.project.model.pks.PricePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository extends JpaRepository<PriceMO, PricePK> {

    @Query("SELECT p FROM PriceMO p " +
            "WHERE p.brandId = :brandId " +
            "AND p.productId = :productId " +
            "AND :date BETWEEN p.startDate AND p.endDate " +
            "ORDER BY p.priority DESC")
    List<PriceMO> getPrice(@Param("date") LocalDateTime date,
                           @Param("productId") Integer productId,
                           @Param("brandId") Integer brandId);
}
