import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

import static org.junit.Assert.assertEquals;

public class GroessterGemeinsamerTeilerTest {
    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Test
    public void testOutput() {
        GroessterGemeinsamerTeiler.main(new String[]{});
        assertEquals("79" + System.lineSeparator(), log.getLog());
    }
}

