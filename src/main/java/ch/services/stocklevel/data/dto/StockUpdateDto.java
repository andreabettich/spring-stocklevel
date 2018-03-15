package ch.services.stocklevel.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class StockUpdateDto {

    @Getter
    @Setter
    @NonNull
    private String warehouse;

    @Getter
    @Setter
    private int stock;
}
