package ch.services.stocklevel.services;

import ch.services.stocklevel.data.StockLevel;
import ch.services.stocklevel.data.StockLevelRepository;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Optional;

@Configuration
public class StockLevelService {

    @Resource
    private StockLevelRepository stockLevelRepository;

    public Optional<StockLevel> getStockLevelByProduct(final String product) {

        final Optional<StockLevel> stockLevel = stockLevelRepository.findById(product);
        return stockLevel;
    }

    public StockLevel createStockLevel(final StockLevel stockLevel) {

        return stockLevelRepository.save(stockLevel);
    }

    public StockLevel updateStockLevel(final String product, final int stock) {

        return null;
    }
}