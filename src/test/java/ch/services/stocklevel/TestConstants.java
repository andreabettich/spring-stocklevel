package ch.services.stocklevel;

import ch.services.stocklevel.data.entity.StockLevel;

public class TestConstants {

    public static final String TEST_ID = "0000666666-505";
    public static final String TEST_PRODUCT_ID = "0000666666";
    public static final String TEST_WAREHOUSE = "505";
    public static final StockLevel STOCK_LEVEL = new StockLevel(TEST_ID, TEST_PRODUCT_ID, TEST_WAREHOUSE, 42);
    public static final String CORRECT_STOCK_LEVEL_PAYLOAD = "{\"id\": \"" + TEST_ID + "\",\"warehouse\": \"" + TEST_WAREHOUSE + "\", \"stock\": 42}";

    private TestConstants() {

    }
}
