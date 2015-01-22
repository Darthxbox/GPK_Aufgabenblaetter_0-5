import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Aufgabe2Test {

    @Rule
    public Timeout globalTimeout = new Timeout(1000);

    @Test
    public void testSort() throws Exception {
        int n = 100000;
        int[] array1 = new int[n];
        for (int i = 0; i < n; i++) {
            array1[i] = (int) (Math.random() * (n - i));
        }
        SortedIntArray2 s = new SortedIntArray2(array1);
        for (int i : array1) {
            assertThat("Sequence not sorted: Binary search failed", s.binarySearch(i), is(true));
        }
    }

    @Test
    public void testSpecialElement() throws Exception {
        int[] array1 = new int[]{3, 5, 3, 4, 2, 1, 2, 1, 0};
        SortedIntArray2 s = new SortedIntArray2(array1);
        assertThat("Special element not valid", s.findSpecialElement(3), is(2));
        assertThat("Special element not valid", s.findSpecialElement(5), is(3));
        assertThat("Special element not valid", s.findSpecialElement(8), is(5));
    }

}
