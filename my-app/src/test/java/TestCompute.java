import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class TestCompute {
  Compute c;

  @Test
  public void example() {
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);
    assertTrue(true);
  }

  @Test
  public void test_is_mq_size_zero() {
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);

    when(mq.size()).thenReturn(0);
    assertEquals(-1, c.countNumberOfOccurrences("devin"));
    verify(mq).size();
  }

  @Test
  public void test_is_mq_contains_e() {
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);

    when(mq.size()).thenReturn(1);
    when(mq.contains("devin")).thenReturn(false);
    assertEquals(0, c.countNumberOfOccurrences("devin"));

    verify(mq).size();
    verify(mq).contains("devin");
  }

  @Test
  public void test_count_number_of_occurrences() {
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);

    when(mq.size()).thenReturn(3);
    when(mq.getAt(0)).thenReturn("devin");
    when(mq.getAt(1)).thenReturn("gpt");
    when(mq.getAt(2)).thenReturn("devin");
    when(mq.contains("devin")).thenReturn(true);
    assertEquals(2, c.countNumberOfOccurrences("devin"));

    verify(mq, times(3)).getAt(anyInt());
    // verify(mq).size();
    verify(mq).contains("devin");

  }

}