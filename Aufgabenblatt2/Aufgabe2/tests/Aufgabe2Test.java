import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class Aufgabe2Test {
    @Rule
    public Timeout globalTimeout = new Timeout(1000);

    @Test
    public void testIterLeo() throws Exception{
        Method method = Aufgabe2.class.getDeclaredMethod("iterativLeo", int.class);
        method.setAccessible(true);
        assertThat("Parameterwert 0 sollte 1 als Rückgabewert liefern",(Integer)method.invoke(null, 0), is(1));
        assertThat("Parameterwert 1 sollte 1 als Rückgabewert liefern",(Integer)method.invoke(null, 1), is(1));
        assertThat("Parameterwert 10 sollte 177 als Rückgabewert liefern",(Integer)method.invoke(null, 10), is(177));
    }

    @Test
    public void testRekLeo() throws Exception{
        Method method = Aufgabe2.class.getDeclaredMethod("rekursivLeo", int.class);
        method.setAccessible(true);
        assertThat("Parameterwert 0 sollte 1 als Rückgabewert liefern",(Integer)method.invoke(null, 0), is(1));
        assertThat("Parameterwert 1 sollte 1 als Rückgabewert liefern",(Integer)method.invoke(null, 1), is(1));
        assertThat("Parameterwert 10 sollte 177 als Rückgabewert liefern",(Integer)method.invoke(null, 10), is(177));
    }
}

