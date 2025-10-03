import com.project.model.Price;
import com.project.services.PriceService;
import com.project.usecases.PriceUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class PriceUseCaseTest {

    @InjectMocks
    PriceUseCase priceUseCase;

    @Mock
    PriceService service;

    @Test
    void getPriceTest() {
        List<Price> prices = List.of(new Price());

        when(service.getPrice(LocalDateTime.MAX, 1, 1)).thenReturn(prices);

        priceUseCase.getPrice(LocalDateTime.MAX, 1, 1);

        verify(service).getPrice(LocalDateTime.MAX, 1, 1);
    }
}
