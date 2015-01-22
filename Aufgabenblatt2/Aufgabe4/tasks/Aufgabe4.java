import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

public class Aufgabe4 {

    private static void befuelleArray(int[] zahlen, int N) {
        for(int i  = 0; i<zahlen.length; i++)
        {
            zahlen[i] =  (int)(Math.random() * (N + 1));
            System.out.print(zahlen[i]);

        }
        System.out.println("\n");
    }

    private static void generiereStatistik(int[] zahlen, int N) {
        int[] zahlenArray = new int[N+1];
        int j = 0;
        while(j <= N) {

            for (int i = 0; i < zahlen.length; i++) {
                if(zahlen[i] == j)
                {
                    zahlenArray[j]++;
                }
            }
            System.out.println("Zahl "+j+" kommt "+zahlenArray[j]+"x vor");
            j++;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[] arr = new int[10];
        befuelleArray(arr, n);
        generiereStatistik(arr, n);
    }

}

/*
    1.  In einem int-Array dürfen nur ganzzahlige Werte gespeichert werden.
    2.  Durch den Index der Arrays kann man die einzelnen Werte bequem vergleichen und verarbeiten.
    3.  Falls keine Arrays verwendet werden dürfen, würde ich mich eines Strings bedienen und diesen mit charAt(index)
        Zeichen für Zeichen vergleichen.
 */