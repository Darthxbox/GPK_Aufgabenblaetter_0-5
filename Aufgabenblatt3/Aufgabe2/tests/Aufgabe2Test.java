import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class Aufgabe2Test {

    private static Constructor constructor;
    private static Method add, read, getCity, getValue;

    @Rule
    public Timeout globalTimeout = new Timeout(100);

    @BeforeClass
    public static void checkMethods() throws Exception {
        constructor = Data.class.getDeclaredConstructor(String.class, int.class);
        getCity = Data.class.getDeclaredMethod("getCity");
        getValue = Data.class.getDeclaredMethod("getValue");
        add = Aufgabe2.class.getDeclaredMethod("addData", String.class, int.class);
        read = Aufgabe2.class.getDeclaredMethod("getData", String.class);
    }

    @Test
    public void testData() throws Exception{
        Data data = (Data) constructor.newInstance("Wien", 600);
        assertThat("Initialization of Data object failed", (String) getCity.invoke(data), is("Wien"));
        assertThat("Initialization of Data object failed", (Integer) getValue.invoke(data), is(600));
    }

    @Test
    public void testMemory() throws Exception{
        int n = 10;
        Data data = null;
        Aufgabe2 test = new Aufgabe2();
        for(int i = 0; i < n; i++){
            add.invoke(test, "City" + i, i);
        }
        for(int i = 0; i < n; i++){
            data = (Data) read.invoke(test, "City"+i);
            assertThat("Testing data storage", (String) getCity.invoke(data), is("City"+i));
            assertThat("Testing data storage", (Integer) getValue.invoke(data), is(i));
        }
        assertTrue("Testing data storage", read.invoke(test, "City"+(n+1)) == null);
    }
}
