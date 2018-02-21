package ch.services.stocklevel.services;

import ch.services.stocklevel.data.entity.StockLevel;

import java.util.Optional;

public interface StockLevelService {

    Optional<StockLevel> getStockLevelByProduct(final String product);

    StockLevel createStockLevel(final StockLevel stockLevel);

    StockLevel updateStockLevel(final String product, final String warehouse, final int stock);
}
