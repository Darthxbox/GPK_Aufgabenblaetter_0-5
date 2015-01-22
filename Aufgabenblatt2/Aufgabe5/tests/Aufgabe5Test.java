import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.lang.reflect.Method;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class Aufgabe5Test {

    private static Method generate;
    private static Method transpose;
    private static Method print;

    @Rule
    public Timeout globalTimeout = new Timeout(1000);

    @BeforeClass
    public static void generiereMethode() throws Exception {
        generate = Aufgabe5.class.getDeclaredMethod("generiereMatrix", int.class);
        generate.setAccessible(true);
        transpose = Aufgabe5.class.getDeclaredMethod("transponiereMatrix", int[][].class);
        transpose.setAccessible(true);
        print = Aufgabe5.class.getDeclaredMethod("printMatrix", int[][].class);
        print.setAccessible(true);
    }

    @Test
    public void testGenerierung() throws Exception{
        int n = 5;
        int[][] test = (int[][]) (generate.invoke(null, n));
        assertTrue("Matrix hat nicht N Zeilen", test.length == n);
        for (int i = 0; i < test.length; i++) {
            assertTrue("Zeile " + i + " hat nicht N Spalten", test[i].length == n);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                assertTrue("Falsche Belegung an der Stelle [" + i + "][" + j + "] mit " + test[i][j], test[i][j] == (i*n + j));
            }
        }
    }

    @Test
    public void testTransponieren() throws Exception {
        int n = 5;
        int[][] test = (int[][]) (generate.invoke(null, n));
        assertTrue("Matrix hat nicht N Zeilen", test.length == n);
        for (int i = 0; i < test.length; i++) {
            assertTrue("Zeile " + i + " hat nicht N Spalten", test[i].length == n);
        }
        int[][] help = new int[n][n];
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test.length; j++) {
                if(i > 0 || j > 0) {
                    assertTrue("Ausgangsmatrix beim Transponieren fehlerhaft", test[i][j] != 0);
                }
                help[i][j] = test[i][j];
            }
        }
        transpose.invoke(null, (Object) test);
        for (int i = 1; i < test.length; i++) {
            for (int j = 0; j < i; j++) {
                assertTrue("Transponieren funktioniert nicht an der Stelle [" + i + "][" + j + "]", test[i][j] == help[j][i]);
            }
        }
    }
}