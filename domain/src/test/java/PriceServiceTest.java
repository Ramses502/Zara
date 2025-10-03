import com.project.model.Price;
import com.project.ports.driven.PriceDbPort;
import com.project.services.PriceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceServiceTest {

    @InjectMocks
    PriceService priceService;

    @Mock
    PriceDbPort priceDbPort;

    @Test
    void getPriceTest() {
        List<Price> prices = List.of(new Price());

        when(priceDbPort.getPrice(LocalDateTime.MAX, 1, 1)).thenReturn(prices);

        priceService.getPrice(LocalDateTime.MAX, 1, 1);

        verify(priceDbPort).getPrice(LocalDateTime.MAX, 1, 1);
    }
}
