package test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.controller.Arith;
import com.example.demo.service.ArithService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(Arith.class)
@ContextConfiguration(classes = {Arith.class, ArithService.class})
public class AddTest {

    @Autowired private MockMvc mockMvc;

    @MockBean private ArithService arithService;

    @Test
    public void testSumBetweenAAndB() throws Exception {

        when(arithService.arith_add(5L, 5L)).thenReturn(10L);

        mockMvc
                .perform(
                        get("/arith/add")
                                .param("a", "5")
                                .param("b", "5")
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("10"));
    }

    @Test
    public void testSumBetweenAAndBWithMediumInt() throws Exception {

        when(arithService.arith_add(75000L, 25000L)).thenReturn(100000L);

        mockMvc
                .perform(
                        get("/arith/add")
                                .param("a", "75000")
                                .param("b", "25000")
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("100000"));
    }

    @Test
    public void testSumBetweenAAndBWithBigInt() throws Exception {

        when(arithService.arith_add(50000000000L, 50000000000L)).thenReturn(100000000000L);

        mockMvc
                .perform(
                        get("/arith/add")
                                .param("a", "50000000000")
                                .param("b", "50000000000")
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("100000000000"));
    }
}