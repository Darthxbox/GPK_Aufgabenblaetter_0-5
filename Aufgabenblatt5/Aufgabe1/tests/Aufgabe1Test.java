import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Aufgabe1Test {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Rule
    public Timeout globalTimeout = new Timeout(100);

    @Test
    public void testBooks() throws Exception {
        Book b1 = new Book("Programmieren mit Java", "Schiedermeier", 480, 3995);
        Book b2 = new Book("Java-Programmierung - Das Handbuch zu Java 8", "Krüger, Hansen", 1104, 4990);
        assertThat("Initialization failed", b1.getTitel(), is("Programmieren mit Java"));
        assertThat("Initialization failed", b2.getAuthors(), is("Krüger, Hansen"));
        assertThat("Initialization failed", b1.getPages(), is(480));
        assertThat("Initialization failed", b2.getPrice(), is(4990L));
    }

    @Test
    public void testInvalidTitle() throws InvalidBookException {
        expectedException.expect(InvalidBookException.class);
        Book b2 = new Book(null, "Author1", 100, 3990);
    }

    @Test
    public void testInvalidAuthors() throws InvalidBookException {
        expectedException.expect(InvalidBookException.class);
        Book b1 = new Book("Book1", null, 100, 3990);
    }

    @Test
    public void testInvalidPages() throws InvalidBookException {
        expectedException.expect(InvalidBookException.class);
        Book b3 = new Book("Book3", "Author1", -1, 3990);
    }

    @Test
    public void testInvalidPrice() throws InvalidBookException {
        expectedException.expect(InvalidBookException.class);
        Book b4 = new Book("Book4", "Author1", 100, -1);
    }

    @Test
    public void testSetter() throws Exception {
        expectedException.expect(InvalidPriceException.class);
        Book b4 = new Book("Book4", "Author1", 100, 1000);
        b4.setPrice(-1);
    }

}