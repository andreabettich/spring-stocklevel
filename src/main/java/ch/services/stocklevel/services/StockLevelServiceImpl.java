package ch.services.stocklevel.services;

import ch.services.stocklevel.data.entity.StockLevel;
import ch.services.stocklevel.data.StockLevelRepository;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Optional;

@Configuration
public class StockLevelServiceImpl implements StockLevelService {

    @Resource
    private StockLevelRepository stockLevelRepository;

    @Override
    public Optional<StockLevel> getStockLevelByProduct(final String product) {

        final Optional<StockLevel> stockLevel = stockLevelRepository.findById(product);
        return stockLevel;
    }

    @Override
    public StockLevel createStockLevel(final StockLevel stockLevel) {

        return stockLevelRepository.save(stockLevel);
    }

    @Override
    public StockLevel updateStockLevel(final String product, final String warehouse, final int stock) {
        final StockLevel stockLevel = getStockLevelByProduct(product)
                .orElse(new StockLevel(product, Map.of(warehouse, stock)));

        final Map<String, Integer> warehouseStock = stockLevel.getWarehouses();
        warehouseStock.put(warehouse, stock);
        stockLevel.setWarehouses(warehouseStock);

        return stockLevelRepository.save(stockLevel);
    }
}