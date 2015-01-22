public class Aufgabe2 {

    private static int iterativLeo(int n) {

        if(n == 1)
        {
            return 1;
        }
        if(n == 0)
        {
            return 1;
        }
        else {
            int zahl1 = 0, zahl2 = 1;

            for (int i = 0; i < n; i++) {
                int buffer = zahl1;
                zahl1 = zahl2;
                if (zahl2 == 1) {
                    zahl2 += 1;
                }
                if (zahl2 == 0) {
                    zahl2 += 1;
                }
                zahl2 = buffer + zahl2 + 1;
            }

            return zahl1;
        }
    }

    private static int rekursivLeo(int n) {
        if(n == 0)
        {
            return 1;
        }
        else if (n==1)
        {
            return 1;
        }
        else
        {
            return rekursivLeo(n-1) + rekursivLeo(n-2) + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(iterativLeo(5));
    }

}

/*
    1. Bei kleinen Zahlen würde sich die iterative Variante besser eignen
    2. Bei sehr hohen Zahlen verlängert sich die Laufzeit und benötigt mehr System-Ressourcen
 */