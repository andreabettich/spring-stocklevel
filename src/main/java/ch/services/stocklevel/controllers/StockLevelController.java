package ch.services.stocklevel.controllers;

import ch.services.stocklevel.data.StockLevel;
import ch.services.stocklevel.data.StockLevelPOJO;
import ch.services.stocklevel.exceptions.ResourceNotFoundException;
import ch.services.stocklevel.services.StockLevelService;
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
import java.util.Optional;

@Controller
@RequestMapping("/stocklevel")
public class StockLevelController {

    @Resource
    private StockLevelService stockLevelService;

    @RequestMapping(value = "/{product}", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public StockLevel getStockLevelByProduct(@PathVariable("product") final String product) {
        Preconditions.checkNotNull(product);

        final Optional<StockLevel> stockLevel = stockLevelService.getStockLevelByProduct(product);

        return stockLevel.orElseThrow(() -> new ResourceNotFoundException(HttpStatus.NOT_FOUND.getReasonPhrase()));
    }

    @RequestMapping(value = "/test/{product}", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public StockLevelPOJO getTestStockLevelByProduct(@PathVariable("product") final String product) {
        Preconditions.checkNotNull(product);

        final Map<String, Integer> map = new HashMap<>();
        map.put("501", 4);
        map.put("502", 1);
        map.put("503", 6);
        map.put("504", 3);
        map.put("505", 6);

        StockLevelPOJO testStockLevel = new StockLevelPOJO("0000666666", map);
        return testStockLevel;
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public StockLevel createStockLevel(@RequestBody final StockLevel stockLevel) {
        Preconditions.checkNotNull(stockLevel);

        return stockLevelService.createStockLevel(stockLevel);
    }

}