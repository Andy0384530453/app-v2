package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.controller.Arith;
import com.example.demo.service.ArithService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;

@WebMvcTest(Arith.class)
@ContextConfiguration(classes = {Arith.class, ArithService.class})
public class AddTest {

  ArithService service = new ArithService();
  Arith controller = new Arith(service);

  @Test
  public void testSumBetweenAAndB() throws Exception {
    assertEquals(10, controller.sum_between_a_and_b(5, 5));
  }

  @Test
  public void testMediumNumber() throws Exception {
    assertEquals(100000, controller.sum_between_a_and_b(75000, 25000));
  }

  @Test
  public void testBigNumber() throws Exception {
    assertEquals(100000000000L, controller.sum_between_a_and_b(50000000000L, 50000000000L));
  }
}
