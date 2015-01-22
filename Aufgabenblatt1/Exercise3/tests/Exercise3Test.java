

import org.junit.Rule;
import org.junit.Test;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class Exercise3Test {

    @Test
    public void testNumberOfDigits() throws Exception{
        Method method = Exercise3.class.getDeclaredMethod("numberOfDigits", int.class);
        method.setAccessible(true);
        assertEquals(1, method.invoke(null, 0));
        assertEquals(1, method.invoke(null, 5));
        assertEquals(2, method.invoke(null, 34));
        assertEquals(3, method.invoke(null, -123));
        assertEquals(4, method.invoke(null, +1234));
        assertEquals(10, method.invoke(null, Integer.MAX_VALUE));
    }
}