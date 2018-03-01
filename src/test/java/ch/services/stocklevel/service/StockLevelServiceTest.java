package ch.services.stocklevel.service;

import ch.services.stocklevel.data.StockLevelRepository;
import ch.services.stocklevel.data.entity.StockLevel;
import ch.services.stocklevel.services.StockLevelService;
import org.junit.Before;
import org.mockito.InjectMocks;

import static ch.services.stocklevel.TestConstants.STOCK_LEVEL;
import static ch.services.stocklevel.TestConstants.TEST_PRODUCT_ID;
import static ch.services.stocklevel.TestConstants.TEST_WAREHOUSE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

//@RunWith(MockitoJUnitRunner.class)
public class StockLevelServiceTest {

    @InjectMocks
    private StockLevelRepository stockLevelRepository;

    @InjectMocks
    private StockLevelService stockLevelService;

    @Before
    public void before() {
        when(stockLevelRepository.save(any())).thenReturn(STOCK_LEVEL);
        when(stockLevelService.getStockLevelByProduct(TEST_PRODUCT_ID)).thenReturn(STOCK_LEVEL);
    }

   // @Test
    public void updateStockLevel_successful() {

        //Arrange

        //Act
        final StockLevel stockLevel = stockLevelService.updateStockLevel(TEST_PRODUCT_ID, TEST_WAREHOUSE, 42);

        //Assert
        assertThat(stockLevel.getWarehouses().get(TEST_WAREHOUSE)).isEqualTo(42);
    }
}
