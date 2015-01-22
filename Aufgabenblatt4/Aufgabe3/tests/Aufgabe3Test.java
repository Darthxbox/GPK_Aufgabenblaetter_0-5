import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Aufgabe3Test {

    private static int n = 1000;
    private static int factor = 100;
    private static int[] test = new int[n];
    private static SortedIntArray3 sortedArray;

    @Rule
    public Timeout globalTimeout = new Timeout(100);

    @BeforeClass
    public static void init() {
        for (int i = 0; i < n; i++) {
            test[i] = (int) (Math.random() * factor);
        }
        sortedArray = new SortedIntArray3(test);
        Arrays.sort(test);
    }

    @Test
    public void testCases() throws Exception {
        for (int i = 0; i < factor + 10; i++) {
            if (Arrays.binarySearch(test, i) < 0) {
                assertThat("Nonexistent value found", sortedArray.binarySearch(i), is(false));
            } else {
                assertThat("Value not found", sortedArray.binarySearch(i), is(true));
            }
        }
    }

    @Test
    public void testSpecialCases() throws Exception {
        SortedIntArray3 s1 = new SortedIntArray3(new int[]{1});
        SortedIntArray3 s2 = new SortedIntArray3(new int[]{});
        assertThat("Value not found", s1.binarySearch(1), is(true));
        assertThat("Nonexistent value found", s1.binarySearch(0), is(false));
        assertThat("Nonexistent value found", s1.binarySearch(2), is(false));
        assertThat("Nonexistent value found", s2.binarySearch(1), is(false));
    }
}