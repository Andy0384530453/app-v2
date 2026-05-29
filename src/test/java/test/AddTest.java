package test;

import com.example.demo.controller.Arith;
import com.example.demo.service.ArithService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Arith.class)

@ContextConfiguration(classes = {Arith.class, ArithService.class})
public class AddTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArithService arithService;

    @Test
    public void testSumBetweenAAndB() throws Exception {
        when(arithService.arith_add(5, 3)).thenReturn(8L);


        mockMvc.perform(get("/arith/add")
                        .param("a", "5")
                        .param("b", "3")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("8"));
    }
  @Test
  public void testSumBetweenAAndBWithMediumInt() throws Exception {
    when(arithService.arith_add(5000, 3000)).thenReturn(8000L);


    mockMvc.perform(get("/arith/add")
                    .param("a", "5")
                    .param("b", "3")
                    .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string("8000"));
  }

  @Test
  public void testSumBetweenAAndBWithBigInt() throws Exception {
    when(arithService.arith_add(500000000, 300000000)).thenReturn(800000000L);


    mockMvc.perform(get("/arith/add")
                    .param("a", "5")
                    .param("b", "3")
                    .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string("800000000"));
  }
}