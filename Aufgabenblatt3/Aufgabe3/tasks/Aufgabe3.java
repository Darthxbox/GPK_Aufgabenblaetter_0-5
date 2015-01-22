public class Aufgabe3 {

private static boolean check(String text)
{
    CharStack klammernAuf = new CharStack();

    //Wenn der String keine Character enthält, ist es gültig.
    if(text == null || text == "")
    {
        return true;
    }
    else {
        //Zerlegt den Sring in ein Array
        char cText[] = text.toCharArray();

        //Geht Symbol für Symbol durch.
        for (char c : cText) {
            //Wenn keine offenen Klammern auf dem Stack sind, das aktuelle Symbol aber eine geschlossene Klammer -> fehlerhafter String.
            if(klammernAuf.empty() && c == ')') return false;
            //Wenn das aktuelle Element eine offene Klammer ist, lege sie auf den Stack.
            if (c == '(') klammernAuf.push(c);
            //Wenn der Stack nicht leer ist und das aktuelle Element eine geschlossene Klammer ist, nimm eine offene Klammer vom Stack.
            if(!klammernAuf.empty() && c == ')') klammernAuf.pop();
        }

        //Falls der Stack leer ist, ist der String gültig. Sollten 1 oder mehrere offene Klammern auf dem Stack sein, ist der String ungültig.
        if (klammernAuf.empty()) return true;
        else return false;
    }
}
    public static void main(String[] args) {
    }
}

//LIFO: Elemente werden in der entgegengesetzen Reihenfolge entnommen, in der sie zuvor hinzugefügt wurden.
//FIFO: Die Elemente scheiden in der Reihenfolge aus, in der sie abgespeichert worden sind.

//Muss man nicht, Falls kein Konstruktor implementiert wird, wird bei der Kompilierung ein leere Konstruktor erzeugt.

//Einen Stack als Array zu implementieren würde grundsätzlich funktionieren. Dieser würde dann aber aus einer fixen Größe bestehen.