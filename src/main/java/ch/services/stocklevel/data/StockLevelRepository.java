package ch.services.stocklevel.data;

import ch.services.stocklevel.data.entity.StockLevel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface StockLevelRepository extends CrudRepository<StockLevel, String> {

    Set<StockLevel> findAllByWarehouse(final String warehouse);

    Set<StockLevel> findAllByProduct(final String product);

    StockLevel findByProductAndWarehouse(final String product, final String warehouse);

    void deleteByProduct(final String product);

    void deleteByProductAndWarehouse(final String product, final String warehouse);

    void deleteByWarehouse(final String warehouse);
}
