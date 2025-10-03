package com.project.zara.rest;

import com.project.model.PriceDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestTest {

    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate restTemplate;

    private ResponseEntity<PriceDto> callPriceApi(LocalDateTime date, int productId, int brandId) {
        String formattedDate = date.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String url = String.format("http://localhost:%d/price?date=%s&productId=%d&brandId=%d",
                port, formattedDate, productId, brandId);
        return restTemplate.getForEntity(URI.create(url), PriceDto.class);
    }

    @Test
    void test14thJune10AM() {
        ResponseEntity<PriceDto> response = callPriceApi(
                LocalDateTime.of(2020, 6, 14, 10, 0),
                35455, 1);

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getProductId()).isEqualTo(35455);
        assertThat(response.getBody().getBrandId()).isEqualTo(1);
        assertThat(response.getBody().getPrice()).isEqualTo(35.5);
        assertThat(response.getBody().getStartDate()).isEqualTo("2020-06-14T00:00");
        assertThat(response.getBody().getEndDate()).isEqualTo("2020-12-31T23:59:59");
        assertThat(response.getBody().getPriceList()).isEqualTo(1);

    }

    @Test
    void test14thJune16PM() {
        ResponseEntity<PriceDto> response = callPriceApi(
                LocalDateTime.of(2020, 6, 14, 16, 0),
                35455, 1);

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getProductId()).isEqualTo(35455);
        assertThat(response.getBody().getBrandId()).isEqualTo(1);
        assertThat(response.getBody().getPrice()).isEqualTo(25.45);
        assertThat(response.getBody().getStartDate()).isEqualTo("2020-06-14T15:00");
        assertThat(response.getBody().getEndDate()).isEqualTo("2020-06-14T18:30");
        assertThat(response.getBody().getPriceList()).isEqualTo(2);
    }

    @Test
    void test14thJune21PM() {
        ResponseEntity<PriceDto> response = callPriceApi(
                LocalDateTime.of(2020, 6, 14, 21, 0),
                35455, 1);

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getProductId()).isEqualTo(35455);
        assertThat(response.getBody().getBrandId()).isEqualTo(1);
        assertThat(response.getBody().getPrice()).isEqualTo(35.5);
        assertThat(response.getBody().getStartDate()).isEqualTo("2020-06-14T00:00");
        assertThat(response.getBody().getEndDate()).isEqualTo("2020-12-31T23:59:59");
        assertThat(response.getBody().getPriceList()).isEqualTo(1);
    }

    @Test
    void test15thJune10AM() {
        ResponseEntity<PriceDto> response = callPriceApi(
                LocalDateTime.of(2020, 6, 15, 10, 0),
                35455, 1);

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getProductId()).isEqualTo(35455);
        assertThat(response.getBody().getBrandId()).isEqualTo(1);
        assertThat(response.getBody().getPrice()).isEqualTo(30.5);
        assertThat(response.getBody().getStartDate()).isEqualTo("2020-06-15T00:00");
        assertThat(response.getBody().getEndDate()).isEqualTo("2020-06-15T11:00");
        assertThat(response.getBody().getPriceList()).isEqualTo(3);
    }

    @Test
    void test16thJune21PM() {
        ResponseEntity<PriceDto> response = callPriceApi(
                LocalDateTime.of(2020, 6, 16, 21, 0),
                35455, 1);

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getProductId()).isEqualTo(35455);
        assertThat(response.getBody().getBrandId()).isEqualTo(1);
        assertThat(response.getBody().getPrice()).isEqualTo(38.95);
        assertThat(response.getBody().getStartDate()).isEqualTo("2020-06-15T16:00");
        assertThat(response.getBody().getEndDate()).isEqualTo("2020-12-31T23:59:59");
        assertThat(response.getBody().getPriceList()).isEqualTo(4);
    }
}


