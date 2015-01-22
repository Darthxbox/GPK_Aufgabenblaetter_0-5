
import java.util.Scanner;

public class Exercise3 {

    public static int numberOfDigits(int zahl) {
        if(zahl == 0)
        {
            return 1;
        }
        else
        {
            int p_zahl = Math.abs(zahl);
            double laenge = Math.log10(p_zahl) + 1;
            return (int) laenge;
        }
    }


    public static void main(String[] args) {
     /*   System.out.println("Bitte ganzzahlige Zahl eingeben:");
        Scanner s = new Scanner(System.in);
        int zahl = s.nextInt();
        System.out.println("Die Laenge beträgt " + numberOfDigits(zahl));
*/
    }
}

