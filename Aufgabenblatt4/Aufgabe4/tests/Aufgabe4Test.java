import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Aufgabe4Test {

    private static int number = (int) (Math.random() * 1000) + 10;
    private static int[] fill = new int[]{12, 18, 8, 15, 9, 22, 4};

    @Rule
    public Timeout globalTimeout = new Timeout(100);

    @Test
    public void testCount() throws Exception {
        IntTree test = new IntTree();
        for (int i = 0; i < number; i++) {
            test.add((int) (Math.random() * number));
        }
        assertThat("Node count failed", test.countNodes(), is(number));
    }

    @Test
    public void testHeight() throws Exception {
        IntTree test = new IntTree();
        for (int i : fill) {
            test.add(i);
        }
        assertThat("Calculation of tree height failed", test.height(), is(3));
    }

    @Test
    public void testSpecialCase() throws Exception {
        IntTree test = new IntTree();
        for (int i = 0; i < number; i++) {
            test.add(i);
        }
        assertThat("Calculation of tree height failed", test.height(), is(number));
        assertThat("Node count failed", test.countNodes(), is(number));
    }

}

