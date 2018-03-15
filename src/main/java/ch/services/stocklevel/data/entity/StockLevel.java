package ch.services.stocklevel.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@RedisHash("StockLevel")
@NoArgsConstructor
@AllArgsConstructor
public class StockLevel implements Serializable {

    @Getter
    @Setter
    @Id
    @NonNull
    private String id;

    @Getter
    @Setter
    @Indexed
    @NonNull
    private String product;

    @Getter
    @Setter
    @Indexed
    @NonNull
    private String warehouse;

    @Getter
    @Setter
    private int stock;
}