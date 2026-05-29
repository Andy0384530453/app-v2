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
public class MultiplicationTest {

  @Autowired private MockMvc mockMvc;

  @MockBean private ArithService arithService;

  @Test
  public void testMultiplicationBetweenAAndB() throws Exception {

    when(arithService.arrith_multiplication(4L, 3L)).thenReturn(12L);

    mockMvc
            .perform(
                    get("/arith/multiplication")
                            .param("a", "4")
                            .param("b", "3")
                            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string("12"));
  }
}