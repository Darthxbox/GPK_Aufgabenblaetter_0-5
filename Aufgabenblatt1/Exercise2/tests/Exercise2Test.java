import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class Exercise2Test {

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Test
    public void testOutput() {
        String[] testValues = new String[]{"3", "4", "4"};
        StringBuilder testString = new StringBuilder();
        for(String i: testValues) {
            testString.append(i).append(System.lineSeparator());
        }
        Exercise2.main(new String[]{});
        assertEquals(testString.toString(), log.getLog());
    }

    @Test
    public void testMin() throws Exception{
        Method method = Exercise2.class.getDeclaredMethod("min", int.class, int.class);
        method.setAccessible(true);
        assertEquals(3, method.invoke(null, 3, 4));
        assertEquals(4, method.invoke(null, 4, 4));
        assertEquals(4, method.invoke(null, 5, 4));
    }
}
