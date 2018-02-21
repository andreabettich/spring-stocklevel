package ch.services.stocklevel.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class StockLevelDto {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private Map<String, Integer> warehouses;
}