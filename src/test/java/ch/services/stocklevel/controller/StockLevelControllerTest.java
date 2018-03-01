package ch.services.stocklevel.controller;

import ch.services.stocklevel.controllers.StockLevelController;
import ch.services.stocklevel.services.StockLevelServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static ch.services.stocklevel.TestConstants.CORRECT_STOCK_LEVEL_PAYLOAD;
import static ch.services.stocklevel.TestConstants.STOCK_LEVEL;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StockLevelController.class)
public class StockLevelControllerTest {


    @MockBean
    private StockLevelServiceImpl stockLevelService;
    @Autowired
    private MockMvc mvc;

    @Test
    public void createStockLevel_successful() throws Exception {
        // Arrange
        given(this.stockLevelService.createStockLevel(any()))
                .willReturn(STOCK_LEVEL);

        // Act and Assert
        this.mvc.perform(post("/stocklevel")
                .content(CORRECT_STOCK_LEVEL_PAYLOAD)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status()
                        .isCreated())
                .andExpect(content()
                        .json(CORRECT_STOCK_LEVEL_PAYLOAD));
    }
}
