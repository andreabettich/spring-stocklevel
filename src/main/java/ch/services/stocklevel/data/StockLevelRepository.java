package ch.services.stocklevel.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockLevelRepository extends CrudRepository<StockLevel, String> {
}
