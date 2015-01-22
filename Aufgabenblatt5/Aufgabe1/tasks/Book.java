import java.util.LinkedList;

public class Book {

    String title, authors;
    int pages;
    long price;

    public Book(String title, String authors, int pages, long price) throws InvalidBookException{
            if (title == null || authors == null || pages < 0 || price < 0) {
                InvalidBookException ex;
                ex = new InvalidBookException("Invalid Book Data");
                throw ex;
            }

            this.title = title;
            this.authors = authors;
            this.pages = pages;
            this.price = price;
    }

    public String getTitel() {
        return title;
    }

    public String getAuthors() {
        return authors;
    }

    public int getPages() {
        return pages;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long newPrice) throws InvalidPriceException{
        if (newPrice < 0) {
            InvalidPriceException ex;
            ex = new InvalidPriceException("Invalid Price");
            throw ex;
        }
        this.price = newPrice;
    }

    public static void main(String[] args) throws InvalidPriceException, InvalidBookException
    {
        Book b1 = new Book("Krieg und Frieden","Toistoi",400,4000);
        Book b2 = new Book("1982","Graham",387,4000);
        Book b3 = new Book("Woyzeck","Büchner",391,4000);
        Book b4 = new Book("Und dann sprach Zarathustra","Nietzsche",299,4000);
        Book b5 = new Book("Faust I","Goethe",311,4000);
    }

}

// 1. Sind universell anwendbar.
// 2. try-catch, dabei wird versucht den Programmcode zuerst im try-Block auszuführen und falls eine Exception auftritt,
//    welche im catch-Block deklariert wurde, wird der catch-Block ausgeführt.
// 3. Durch Abfragen und falls Ausnahmen auftreten, den Benutzer mittels JOptionPane.MessageBox informieren.
// 4. NullPointerException
