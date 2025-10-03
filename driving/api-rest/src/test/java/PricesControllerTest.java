import com.project.controllers.PricesController;
import com.project.mappers.PriceMapperImpl;
import com.project.model.Price;
import com.project.model.PriceDto;
import com.project.ports.driving.PricePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PricesControllerTest {

    @InjectMocks
    PricesController pricesController;

    @Mock
    PricePort pricePort;

    @Spy
    PriceMapperImpl  priceMapperImpl;

    @Test
    void getPriceTest() {
        Price price = new Price();
        price.setPriceList(1);
        price.setPrice(1.0);
        price.setCurrency("EUR");
        price.setPriority(1);
        price.setEndDate(LocalDateTime.MAX);
        price.setStartDate(LocalDateTime.MIN);
        price.setBrandId(1);
        price.setProductId(1);

        when(pricePort.getPrice(LocalDateTime.MAX, 1, 1)).thenReturn(price);

        PriceDto priceDto = pricesController.getPrice(LocalDateTime.MAX, 1, 1);

        assertEquals(price.getPriceList(), priceDto.getPriceList());
        assertEquals(price.getPrice(), priceDto.getPrice());
        assertEquals(price.getBrandId(), priceDto.getBrandId());
        assertEquals(price.getProductId(), priceDto.getProductId());
        assertEquals(price.getStartDate(), priceDto.getStartDate());
        assertEquals(price.getEndDate(), priceDto.getEndDate());
    }
}
