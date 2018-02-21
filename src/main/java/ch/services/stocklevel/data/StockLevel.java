package ch.services.stocklevel.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Map;

@RedisHash("StockLevel")
@AllArgsConstructor
@NoArgsConstructor
public class StockLevel implements Serializable {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private Map<String, Integer> warehouses;

}