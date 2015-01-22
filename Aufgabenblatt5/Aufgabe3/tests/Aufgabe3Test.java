import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Aufgabe3Test {

    private final static int N = 10;
    @Rule
    public Timeout globalTimeout = new Timeout(100);


    @Test
    public void testSearch() throws Exception {
        IntList il = new IntList();
        for (int i = 0; i < N; i++) {
            il.add(i);
        }
        assertThat("Search failed", il.search(1), is(true));
        assertThat("Search returned true for non existent value", il.search(N * 2), is(false));
    }

    @Test
    public void testReverse() throws Exception {
        IntList il = new IntList();
        for (int i = 0; i < N; i++) {
            il.add(i);
        }
        il.reverse();
        assertThat("Reverse failed", il.first(), is(N - 1));
        assertThat("Search failed", il.search(N / 2), is(true));
        il.add(N * 2);
        il.reverse();
        assertThat("Reverse failed", il.first(), is(N * 2));
        assertThat("Search failed", il.search(N / 4), is(true));
    }

    @Test
    public void testReverseRecursive() throws Exception {
        IntList il = new IntList();
        for (int i = 0; i < N; i++) {
            il.add(i);
        }
        il.reverseRecursive();
        assertThat("Reverse failed", il.first(), is(N - 1));
        assertThat("Search failed", il.search(N / 2), is(true));
        il.add(N * 2);
        il.reverseRecursive();
        assertThat("Reverse failed", il.first(), is(N * 2));
        assertThat("Search failed", il.search(N / 4), is(true));
    }

}