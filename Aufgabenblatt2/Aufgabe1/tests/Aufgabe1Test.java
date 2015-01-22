import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class Aufgabe1Test {
    @Rule
    public Timeout globalTimeout = new Timeout(1000);

    @Test
    public void testZahlInHex() throws Exception{
        Method method = Aufgabe1.class.getDeclaredMethod("zahlInHex", int.class);
        method.setAccessible(true);
        assertThat("Parameterwert 10 sollte A als Rückgabewert liefern",(String)method.invoke(null, 10), is("A"));
        assertThat("Parameterwert 1234 sollte 4D2 als Rückgabewert liefern",(String)method.invoke(null, 1234), is("4D2"));
        assertThat("Parameterwert 255 sollte FF als Rückgabewert liefern",(String)method.invoke(null, 255), is("FF"));
        assertThat("Parameterwert 0 sollte 0 als Rückgabewert liefern",(String)method.invoke(null, 0), is("0"));
    }
}
