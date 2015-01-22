import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Aufgabe1Test {

    private static Constructor constructor;
    private static Method getCounter, getOverflow, reset, increment;

    @Rule
    public Timeout globalTimeout = new Timeout(100);

    @BeforeClass
    public static void checkMethods() throws Exception {
        constructor = Aufgabe1.class.getDeclaredConstructor(int.class);
        getCounter = Aufgabe1.class.getDeclaredMethod("getCounter");
        getOverflow = Aufgabe1.class.getDeclaredMethod("getOverflowCounter");
        reset = Aufgabe1.class.getDeclaredMethod("reset");
        increment = Aufgabe1.class.getDeclaredMethod("increment");
    }

    @Test
    public void testConstruction() throws Exception {
        Aufgabe1 counter = (Aufgabe1) constructor.newInstance(10);
        assertThat("Initialization of counter failed", (Integer) getCounter.invoke(counter), is(0));
        assertThat("Initialization of overflow counter failed", (Integer) getOverflow.invoke(counter), is(0));
    }

    @Test
    public void testIncrement() throws Exception {
        int n = 10;
        Aufgabe1 counter = (Aufgabe1) constructor.newInstance(n);
        for (int i = 0; i < n / 2; i++)
            increment.invoke(counter);
        assertThat("Increment failed", (Integer) getCounter.invoke(counter), is(n / 2));
        for (int i = 0; i < 2 * n; i++)
            increment.invoke(counter);

        assertThat("Increment failed", (Integer) getCounter.invoke(counter), is(n / 2));
        assertThat("Wrong overflow value", (Integer) getOverflow.invoke(counter), is(2));
    }

    @Test
    public void testReset() throws Exception {
        int n = 10;
        Aufgabe1 counter = (Aufgabe1) constructor.newInstance(10);
        for (int i = 0; i < 2 * n; i++)
            increment.invoke(counter);
        reset.invoke(counter);
        assertThat("Reset failed: Wrong counter", (Integer) getCounter.invoke(counter), is(0));
        assertThat("Reset failed: Wrong overflow counter", (Integer) getOverflow.invoke(counter), is(0));
    }
}