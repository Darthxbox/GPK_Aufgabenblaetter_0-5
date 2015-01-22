import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Aufgabe4Test {

    private static Method choose;

    @Rule
    public Timeout globalTimeout = new Timeout(100);

    @BeforeClass
    public static void checkMethods() throws Exception {
        choose = Aufgabe4.class.getDeclaredMethod("assign", int.class, int.class);
        choose.setAccessible(true);
    }

    private static int assign2(int n){
        return 2*(n-(int)Math.pow(2,(int)Math.floor(Math.log(n)/Math.log(2))))+1;
    }

    @Test
    public void testTwo() throws Exception {
        for(int i = 2; i < 20; i ++)
            assertThat("When n = " + i + " and m = 2", (Integer) choose.invoke(null, i, 2), is(assign2(i)));
    }

    @Test
    public void testOther() throws Exception {
        int[] nwerte = new int[]{5, 8, 10, 15, 30};
        int[] mwerte = new int[]{3, 4, 5, 6, 7};
        int[] lwerte = new int[]{4, 6, 3, 7, 23};
        for(int i = 0; i < nwerte.length; i++) {
            assertThat("When n = " + nwerte[i] + " and m = " + mwerte[i], (Integer) choose.invoke(null, nwerte[i], mwerte[i]), is(lwerte[i]));
        }
    }
}
