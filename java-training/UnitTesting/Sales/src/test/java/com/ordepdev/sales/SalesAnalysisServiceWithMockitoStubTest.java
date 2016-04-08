package com.ordepdev.sales;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SalesAnalysisServiceWithMockitoStubTest {
    private static final List<Sale> exampleSales = Arrays.asList(
            new Sale("Apple", "London", 2, 30),
            new Sale("Banana", "London", 1, 15),
            new Sale("Orange", "London", 4, 40),
            new Sale("Apple", "Cardiff", 10, 25)
    );

    private static final Map<String, Integer> expectedStoreSales = new HashMap<>();
    static {
        expectedStoreSales.put("Cardiff", 25);
        expectedStoreSales.put("London", 85);
    }

    @Test
    public void shouldAggregateStoreSales() {
        SalesRepository repository = mock(SalesRepository.class);
        when(repository.loadSales()).thenReturn(exampleSales);

        SalesAnalysisService service = new SalesAnalysisService(repository);
        Map<String, Integer> storeSales = service.tallyStoreSales();

        assertEquals(expectedStoreSales, storeSales);
    }
}
