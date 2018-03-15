package ch.services.stocklevel.services;

import ch.services.stocklevel.data.dto.StockUpdateDto;
import ch.services.stocklevel.data.entity.StockLevel;

import java.util.Set;

public interface StockLevelService {

    Set<StockLevel> getStockLevelsForProduct(final String product);

    Set<StockLevel> getStockLevelsForWarehouse(final String warehouse);

    StockLevel getStockLevelForProductAndWarehouse(final String product, final String warehouse);

    Set<StockLevel> createStockLevels(final Set<StockLevel> stockLevels);

    StockLevel createStockLevel(final StockLevel stockLevel);

    StockLevel updateStockLevel(final String product, final StockUpdateDto stockUpdate);

    void deleteStockLevelsByProduct(final String product);

    void deleteStockLevelByProductAndWarehouse (final String product, final String warehouse);

    void deleteStockLevelByWarehouse(final String warehouse);

    void deleteAllStockLevels();
}
