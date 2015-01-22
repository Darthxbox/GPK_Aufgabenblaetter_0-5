import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

import static org.junit.Assert.assertEquals;

public class Exercise1Test {
    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Test
    public void testOutput() {
        String[] testValues = new String[]{"3000", "0", "0"};
        StringBuilder testString = new StringBuilder();
        for(String i: testValues) {
            testString.append(i).append(System.lineSeparator());
        }
        Exercise1.main(new String[]{});
        assertEquals(testString.toString(), log.getLog());
    }
}
