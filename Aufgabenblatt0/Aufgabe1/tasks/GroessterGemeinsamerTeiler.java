//Beispiel von Folie 11 (09.10.2014)
public class GroessterGemeinsamerTeiler {
    public static void main(String[] args) {
        int m = 1027;
        int n = 395;
        while (m != n) { /* solange m und n ungleich */
            if (m > n) { /* wenn m größer n */
                m = m - n; /* ziehe n von m ab */
            }
            else { /* sonst (n größer m) */
                n = n - m; /* ziehe m von n ab */
            }
        } /* m und n sind nun gleich */
        System.out.println(m);
    }
}
