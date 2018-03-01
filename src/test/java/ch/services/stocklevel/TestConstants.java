package ch.services.stocklevel;

import ch.services.stocklevel.data.entity.StockLevel;

import java.util.Map;

public class TestConstants {

    public static final String TEST_PRODUCT_ID = "0000666666";
    public static final String TEST_WAREHOUSE = "505";
    public static final Map<String, Integer> TEST_WAREHOUSE_MAP = Map.of("505", 1, "506", 2, "507", 3);
    public static final StockLevel STOCK_LEVEL = new StockLevel(TEST_PRODUCT_ID, TEST_WAREHOUSE_MAP);
    public static final String CORRECT_STOCK_LEVEL_PAYLOAD = "{\"id\": \"0000666666\",\"warehouses\": {\"505\": 1,\"506\": 2,\"507\": 3}}";

    private TestConstants() {

    }
}
