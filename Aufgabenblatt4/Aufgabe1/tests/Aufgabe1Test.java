import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Aufgabe1Test {

    private static int n = 100;
    private static int factor = 1000;
    @Rule
    public Timeout globalTimeout = new Timeout(1000);

    @Test
    public void testRandomSequence() throws Exception {
        int[] array1 = new int[n];
        for (int i = 0; i < n; i++) {
            array1[i] = (int) (Math.random() * factor);
        }
        SortedIntArray1 s = new SortedIntArray1(array1);
        for (int i : array1) {
            assertThat("Sequence not sorted: Binary search failed", s.binarySearch(i), is(true));
        }
    }

    @Test
    public void testSortedSequence() throws Exception {
        int[] array1 = new int[n];
        for (int i = 0; i < n; i++) {
            array1[i] = n - i;
        }
        SortedIntArray1 s = new SortedIntArray1(array1);
        for (int i : array1) {
            assertThat("Sequence not sorted: Binary search failed", s.binarySearch(i), is(true));
        }
    }

    @Test
    public void testSpecialCase() throws Exception {
        int[] array1 = new int[]{5, 1, 1, 1, 3, 3, 3, 2, 4};
        SortedIntArray1 s = new SortedIntArray1(array1);
        for (int i : array1) {
            assertThat("Sequence not sorted: Binary search failed", s.binarySearch(i), is(true));
        }
    }

}