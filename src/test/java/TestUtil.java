import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestUtil {
  Util c;

  @Before
  public void setUp() {
    c = new Util();
  }

  @Test
  public void example() {
    assertTrue(true);
  }

  @Test
  public void test_is_length_one() {
    int[] test = { 1 }; // length is 1
    assertFalse(c.compute(test));
  }

  @Test
  public void test_is_length_even() {
    int[] test = { 1, 2, 3, 4 }; // length is 4
    assertFalse(c.compute(test));
  }

  @Test(expected = RuntimeException.class)
  public void test_if_array_contains_zero_as_element() {
    int[] test = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
    c.compute(test);
  }

  @Test
  public void test_if_sum_divisible_by_any_element() {
    int[] test = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    assertTrue(c.compute(test));
  }

  @Test
  public void test_if_sum_not_divisible_by_any_element() {
    int[] test = { -2, -2, 5 };
    assertFalse(c.compute(test));
  }

}