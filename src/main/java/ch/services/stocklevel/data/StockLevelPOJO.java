package ch.services.stocklevel.data;

import java.util.Map;

public class StockLevelPOJO {

    private String id;
    private Map<String, Integer> warehouses;

    public StockLevelPOJO(final String id, final Map<String, Integer> warehouses) {
        this.id = id;
        this.warehouses = warehouses;
    }

    public StockLevelPOJO () {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public Map<String, Integer> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(final Map<String, Integer> warehouses) {
        this.warehouses = warehouses;
    }
}