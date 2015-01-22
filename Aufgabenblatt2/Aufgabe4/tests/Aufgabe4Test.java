import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.rules.Timeout;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Aufgabe4Test {
    private static Method befuellen;
    private static Method generieren;

    @Rule
    public Timeout globalTimeout = new Timeout(1000);

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @BeforeClass
    public static void generiereMethode() throws Exception {
        befuellen = Aufgabe4.class.getDeclaredMethod("befuelleArray", int[].class, int.class);
        befuellen.setAccessible(true);
        generieren = Aufgabe4.class.getDeclaredMethod("generiereStatistik", int[].class, int.class);
        generieren.setAccessible(true);
    }

    @Test
    public void testBefuellen() throws Exception {
        int n = 5;
        int[] test = new int[10000];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        befuellen.invoke(null, test, n);
        for (int i : test) {
            min = (i < min) ? i : min;
            max = (i > max) ? i : max;
        }
        assertTrue("Fehler beim Befüllen des Arrays - Maximum ist nicht gleich N", max == n);
        assertTrue("Fehler beim Befüllen des Arrays - Minimum ist nicht gleich 0", min == 0);
    }

    @Test
    public void testStatistik() throws Exception {
        int n = 5;
        int[] test = new int[]{0, 0, 0, 1, 1, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5};
        String[] testWerte = new String[]{"3", "2", "1", "3", "3", "5"};
        String testString = new String();
        for (int i = 0; i < testWerte.length; i++) {
            testString += "Zahl " + i + " kommt " + testWerte[i] + "x vor" + System.lineSeparator();
        }
        generieren.invoke(null, test, n);
        assertEquals("Fehler beim Überprüfen mit Test-Array",testString, log.getLog());
    }
}
