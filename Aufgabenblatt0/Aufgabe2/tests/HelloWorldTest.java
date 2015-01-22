import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

import static org.junit.Assert.assertEquals;

public class HelloWorldTest {
    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Test
    public void testOutput() {
        HelloWorld.main(new String[]{});
        assertEquals("Hello World!" + System.lineSeparator(), log.getLog());
    }
}
