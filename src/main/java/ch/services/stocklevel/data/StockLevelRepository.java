package ch.services.stocklevel.data;

import ch.services.stocklevel.data.entity.StockLevel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockLevelRepository extends CrudRepository<StockLevel, String> {
}
