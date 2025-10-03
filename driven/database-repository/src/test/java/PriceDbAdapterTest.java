import com.project.adapters.PriceDbAdapter;
import com.project.mappers.PriceDbMapperImpl;
import com.project.model.Price;
import com.project.model.PriceMO;
import com.project.repositories.PriceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceDbAdapterTest {

    @InjectMocks
    PriceDbAdapter priceDbAdapter;

    @Mock
    PriceRepository priceRepository;

    @Spy
    PriceDbMapperImpl  priceDbMapperImpl;

    @Test
    void getPriceTest() {
        PriceMO priceMO = new PriceMO();
        priceMO.setPriceList(1);
        priceMO.setPrice(1.0);
        priceMO.setCurrency("EUR");
        priceMO.setPriority(1);
        priceMO.setEndDate(LocalDateTime.MAX);
        priceMO.setStartDate(LocalDateTime.MIN);
        priceMO.setBrandId(1);
        priceMO.setProductId(1);

        when(priceRepository.getPrice(LocalDateTime.MIN, 1, 1)).thenReturn(List.of(priceMO));

        List<Price> prices = priceDbAdapter.getPrice(LocalDateTime.MIN, 1, 1);

        assertEquals(prices.get(0).getPrice(), priceMO.getPrice());
        assertEquals(prices.get(0).getPriceList(), priceMO.getPriceList());
        assertEquals(prices.get(0).getCurrency(), priceMO.getCurrency());
        assertEquals(prices.get(0).getPriority(), priceMO.getPriority());
        assertEquals(prices.get(0).getEndDate(), priceMO.getEndDate());
        assertEquals(prices.get(0).getStartDate(), priceMO.getStartDate());
        assertEquals(prices.get(0).getBrandId(), priceMO.getBrandId());
        assertEquals(prices.get(0).getProductId(), priceMO.getProductId());
    }
}
