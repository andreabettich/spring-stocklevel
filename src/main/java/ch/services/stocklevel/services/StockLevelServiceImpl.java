package ch.services.stocklevel.services;

import ch.services.stocklevel.data.StockLevelRepository;
import ch.services.stocklevel.data.dto.StockUpdateDto;
import ch.services.stocklevel.data.entity.StockLevel;
import com.google.common.base.Preconditions;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class StockLevelServiceImpl implements StockLevelService {

    @Resource
    private StockLevelRepository stockLevelRepository;

    @Override
    public Set<StockLevel> getStockLevelsForProduct(final String product) {

        return stockLevelRepository.findAllByProduct(product);
    }

    @Override
    public Set<StockLevel> getStockLevelsForWarehouse(final String warehouse) {
        return stockLevelRepository.findAllByWarehouse(warehouse);
    }

    @Override
    public StockLevel getStockLevelForProductAndWarehouse(final String product, final String warehouse) {
        final Set<StockLevel> stockLevels = stockLevelRepository.findAllByProduct(product);

        return stockLevels.stream()
                          .filter(stockLevel -> stockLevel.getWarehouse()
                                                          .equals(warehouse))
                          .findFirst()
                          .orElse(null);
    }

    @Override
    public Set<StockLevel> createStockLevels(final Set<StockLevel> stockLevels) {
        Preconditions.checkNotNull(stockLevels);

        final Set<StockLevel> savedStockLevels = new HashSet<>();
        stockLevels.forEach(stockLevel ->
                addToSavedStockLevels(createStockLevel(stockLevel), savedStockLevels));

        return savedStockLevels;
    }

    @Override
    public StockLevel createStockLevel(final StockLevel stockLevel) {
        return stockLevelRepository.save(stockLevel);
    }

    @Override
    //Todo: improve update to delegate update process to redis, instead of geting, updating and pushing again the entry
    public StockLevel updateStockLevel(final String product, final StockUpdateDto stockUpdate) {
        Preconditions.checkNotNull(product);
        Preconditions.checkNotNull(stockUpdate);

        StockLevel stockLevel = getStockLevelForProductAndWarehouse(product, stockUpdate.getWarehouse());

        if (stockLevel == null) {
            return createStockLevel(new StockLevel(null, product, stockUpdate.getWarehouse(), stockUpdate.getStock()));
        }
        stockLevel.setStock(stockUpdate.getStock());

        return stockLevelRepository.save(stockLevel);
    }

    @Override
    public void deleteStockLevelsByProduct(final String product) {
        stockLevelRepository.deleteByProduct(product);
    }

    @Override
    public void deleteStockLevelByProductAndWarehouse(final String product, final String warehouse) {
        stockLevelRepository.deleteByProductAndWarehouse(product, warehouse);
    }

    @Override
    public void deleteStockLevelByWarehouse(final String warehouse) {
        stockLevelRepository.deleteByWarehouse(warehouse);
    }

    @Override
    public void deleteAllStockLevels() {
        stockLevelRepository.deleteAll();
    }

    private void addToSavedStockLevels(final StockLevel stockLevel, final Set<StockLevel> savedStockLevels) {
        savedStockLevels.add(stockLevel);
    }
}