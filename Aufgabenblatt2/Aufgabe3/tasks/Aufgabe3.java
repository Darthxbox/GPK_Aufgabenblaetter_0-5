import java.sql.SQLOutput;

public class Aufgabe3 {

private static int original = -1;
    private static void printSequenz(int n) {

        if(n < 1)
        {}
          else {
            if (original == -1) {
                original = n;
            }

            if (n > 1) printSequenz(n - 1);
            for (int i = 1; i <= n; i++)
                System.out.print(i);

            System.out.println("");


            if (n == original) {
                printLower(n);
            }
        }
    }

    private static void printLower(int n) {
        if(n>1) {
            for (int i = 1; i <= n-1; i++)
                System.out.print(i);

            System.out.println("");


            printLower(n - 1);
        }
        else
        {
            return;
        }

    }

        public static void main(String[] args) {
            printSequenz(5);
    }

}