import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class Aufgabe3Test {
    private static Method checker, checker2, push, pop;

    @Rule
    public Timeout globalTimeout = new Timeout(100);

    @BeforeClass
    public static void checkMethodsAndClasses() throws Exception {
        push = CharStack.class.getDeclaredMethod("push", char.class);
        pop = CharStack.class.getDeclaredMethod("pop");
        Field[] fields = CharStack.class.getDeclaredFields();
        boolean check = false;
        for (Field f : fields) {
            if (f.getType().equals(CharListNode.class))
                check = true;
        }
        assertTrue("Class CharListNode not used", check);
        checker = Aufgabe3.class.getDeclaredMethod("check", String.class);
        checker.setAccessible(true);
    }

    @Test
    public void testEmpty() throws Exception {
        assertThat("Testing with empty input string", (Boolean) checker.invoke(null, ""), is(true));
    }

    @Test
    public void testBrackets() throws Exception {
        assertThat("Testing with ()", (Boolean) checker.invoke(null, "()"), is(true));
        assertThat("Testing with (())", (Boolean) checker.invoke(null, "(())"), is(true));
        assertThat("Testing with ()()", (Boolean) checker.invoke(null, "()()"), is(true));
        assertThat("Testing with (())()", (Boolean) checker.invoke(null, "(())()"), is(true));
    }

    @Test
    public void testBracketsAndSpaces() throws Exception {
        assertThat("Testing with ( )", (Boolean) checker.invoke(null, "( )"), is(true));
        assertThat("Testing with ( (  ))", (Boolean) checker.invoke(null, "( (  ))"), is(true));
        assertThat("Testing with ( )   ()", (Boolean) checker.invoke(null, "( )   ()"), is(true));
        assertThat("Testing with ( ())() ", (Boolean) checker.invoke(null, "( ())() "), is(true));
    }

    @Test
    public void testWrongInput() throws Exception {
        assertThat("Testing with wrong input (", (Boolean) checker.invoke(null, "("), is(false));
        assertThat("Testing with wrong input )", (Boolean) checker.invoke(null, ")"), is(false));
        assertThat("Testing with wrong input (()", (Boolean) checker.invoke(null, "(()"), is(false));
        assertThat("Testing with wrong input ())", (Boolean) checker.invoke(null, "())"), is(false));
        assertThat("Testing with wrong input )(", (Boolean) checker.invoke(null, ")("), is(false));
        assertThat("Testing with wrong input ))((", (Boolean) checker.invoke(null, "))(("), is(false));
    }
}