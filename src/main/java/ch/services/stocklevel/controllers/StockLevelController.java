package ch.services.stocklevel.controllers;

import ch.services.stocklevel.data.dto.StockLevelDto;
import ch.services.stocklevel.data.dto.StockUpdateDto;
import ch.services.stocklevel.data.entity.StockLevel;
import ch.services.stocklevel.exceptions.ResourceNotFoundException;
import ch.services.stocklevel.services.StockLevelServiceImpl;
import com.google.common.base.Preconditions;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/stocklevel")
public class StockLevelController {

    @Resource
    private StockLevelServiceImpl stockLevelService;

    @RequestMapping(value = "/{product}", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public StockLevel getStockLevelByProduct(@PathVariable("product") final String product) {
        Preconditions.checkNotNull(product);

        final StockLevel stockLevel = stockLevelService.getStockLevelByProduct(product);

        if (stockLevel == null)
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND.getReasonPhrase());

        return stockLevel;
    }

    @RequestMapping(value = "/test/{product}", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public StockLevelDto getTestStockLevelByProduct(@PathVariable("product") final String product) {
        Preconditions.checkNotNull(product);

        final Map<String, Integer> map = new HashMap<>();
        map.put("501", 4);
        map.put("502", 1);
        map.put("503", 6);
        map.put("504", 3);
        map.put("505", 6);

        StockLevelDto testStockLevel = new StockLevelDto("0000666666", map);
        return testStockLevel;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public StockLevel createStockLevel(@RequestBody final StockLevel stockLevel) {
        Preconditions.checkNotNull(stockLevel);

        return stockLevelService.createStockLevel(stockLevel);
    }

    @RequestMapping(value = "/{product}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public StockLevel updateStockLevel(@RequestBody final StockUpdateDto stockLevelUpdate,
                                       @PathVariable("product") final String product) {
        Preconditions.checkNotNull(stockLevelUpdate);

        return stockLevelService.updateStockLevel(product, stockLevelUpdate.getWarehouse(), stockLevelUpdate.getStock());
    }
}