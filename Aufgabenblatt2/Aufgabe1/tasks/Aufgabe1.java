public class Aufgabe1 {

    private static String zahlInHex(int n) {

            int rest = n % 16;
            String hexZiff = "" + rest;

            switch (rest) {
                case 10:
                    hexZiff = "A";
                    break;
                case 11:
                    hexZiff = "B";
                    break;
                case 12:
                    hexZiff = "C";
                    break;
                case 13:
                    hexZiff = "D";
                    break;
                case 14:
                    hexZiff = "E";
                    break;
                case 15:
                    hexZiff = "F";
                    break;
            }
            int zahl = n / 16;

            if(zahl == 0)
            {
                return hexZiff;
            }
            else
            {
                return  zahlInHex(zahl) + hexZiff;
            }



    }

    public static void main(String[] args) {
        System.out.println(zahlInHex(0));
    }
}

/*  1.  Mit der java.lang.Integer.toHexString() können Integerwerter direkt in eine String umgewandelt werden,
        welcher der hexadezimalen schreibweise entspricht.
    2.  Durch die API muss nicht auf die Reihenfolge der Ziffern geachtet werden, da sie richtig herum angeschrieben werden.
*/