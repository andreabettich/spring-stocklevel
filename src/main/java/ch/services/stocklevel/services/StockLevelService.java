package ch.services.stocklevel.services;

import ch.services.stocklevel.data.StockLevel;

import java.util.Optional;

public interface StockLevelService {

    Optional<StockLevel> getStockLevelByProduct(final String product);

    StockLevel createStockLevel(final StockLevel stockLevel);
}
