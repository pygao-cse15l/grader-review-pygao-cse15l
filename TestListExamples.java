import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

class PalindromeChecker implements StringChecker {
  public boolean checkString(String s) {
      for (int i = 0; i < s.length()/2; i++) {
          if (s.charAt(i) != s.charAt(s.length()-1-i)) {
              return false;
          }
      }
      return true;
  }
}

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test
    public void testFilter() {
        List<String> input1 = Arrays.asList("a", "b", "ab", "bcb");
        StringChecker input2 = new PalindromeChecker();

        assertArrayEquals(new String[]{"a", "b", "bcb"}, ListExamples.filter(input1, input2).toArray());
    }
    
    @Test
    public void testFilter2() {
        List<String> input1 = Arrays.asList("a", "ba", "aba", "ca", "a");
        StringChecker input2 = new PalindromeChecker();
        assertArrayEquals(new String[]{"a", "aba", "a"}, ListExamples.filter(input1, input2).toArray());
    }

    @Test
    public void testMerge() {
        List<String> input1 = Arrays.asList();
        List<String> input2 = Arrays.asList("b");

        assertArrayEquals(new String[]{"b"}, ListExamples.merge(input1, input2).toArray());
    }
}
