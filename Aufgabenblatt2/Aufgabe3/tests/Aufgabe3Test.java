import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.rules.Timeout;

import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class Aufgabe3Test {
    private static Method methode;

    @Rule
    public Timeout globalTimeout = new Timeout(1000);
    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Before
    public void generiereMethode() throws Exception {
        methode = Aufgabe3.class.getDeclaredMethod("printSequenz", int.class);
        methode.setAccessible(true);
    }

    private static String generiereSequenz(int n) {
        StringBuilder sequenz = new StringBuilder();
        for (int i = 1; i < 2 * n; i++) {
            for (int j = 1; j <= (i > n ? 2 * n - i : i); j++) {
                sequenz.append(j);
            }
            sequenz.append(System.lineSeparator());
        }
        return sequenz.toString();
    }

    @Test
    public void testAusgabe1() throws Exception {
        methode.invoke(null, 3);
        assertEquals("Ausgabe für n gleich 3 nicht korrekt", generiereSequenz(3), log.getLog());;
        log.clear();
        methode.invoke(null, 5);
        assertEquals("Ausgabe für n gleich 5 nicht korrekt", generiereSequenz(5), log.getLog());
    }

    @Test
    public void testAusgabe2() throws Exception {
        for (int i = -1; i <= 10; i += 1) {
            methode.invoke(null, i);
            assertEquals("Ausgabe für n gleich " + i + " nicht korrekt", generiereSequenz(i), log.getLog());
            log.clear();
        }
    }
}