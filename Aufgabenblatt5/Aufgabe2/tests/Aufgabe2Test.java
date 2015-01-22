import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Aufgabe2Test {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Rule
    public Timeout globalTimeout = new Timeout(100);


    @Test
    public void testFractions() throws Exception {
        Fraction f1 = new Fraction(1, 4);
        Fraction f2 = new Fraction(3, 7);
        assertThat("Construction of fraction object failed", f1.getNumerator(), is(1));
        assertThat("Construction of fraction object failed", f2.getDenominator(), is(7));
        Fraction f3 = f1.add(f2);
        assertThat("Add failed", f3.getNumerator(), is(19));
        assertThat("Add failed", f3.getDenominator(), is(28));
    }

    @Test
    public void testFailure1() throws InvalidDenominatorException {
        expectedException.expect(InvalidDenominatorException.class);
        Fraction f1 = new Fraction(1, 0);
    }

    @Test
    public void testFailure2() throws InvalidDenominatorException, NullObjectException {
        expectedException.expect(NullObjectException.class);
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = f1.add(null);
    }

}

