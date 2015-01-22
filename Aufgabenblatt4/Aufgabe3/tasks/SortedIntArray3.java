import java.util.Arrays;

public class SortedIntArray3 {
    private int[] array;

    public SortedIntArray3(int[] array) {
        this.array = new int[array.length];
        System.arraycopy(array, 0, this.array, 0, array.length);
        Arrays.sort(this.array);
    }

    public boolean binarySearch(int elem) {


        return rekursiv(elem, 0, array.length-1);
    }

    private boolean rekursiv(int elem, int start, int ende)
    {
        if (ende < start) //Prüfe ob Obergrenze kleiner als Untergrenze -> Abbruchbedingung
            return false;

        int mitte = (start + ende)/2;

        if (array[mitte] == elem) //Falls die aktuelle Mitte gleich dem gesuchten Element ist, war die Suche erfolgreich
        return true;

        else if (array[mitte] < elem) //Entscheide in welche Richtung gegangen wird
        {
            return rekursiv(elem, mitte+1, ende); //Falls die aktuelle Mitte kleiner dem gesuchten Element, erhöhe die Mitte
                                                  //in Richtung des gesuchten Elements.
        }

        else
        {
            return rekursiv(elem, start, mitte-1); //Falls die aktuelle Mitte größer dem gesuchten Element, verringere die Mitte
                                                   //in Richtung des gesuchten Elements.
        }

    }


}

//Bei einer Binären Suche muss gewährleistest sein, dass das mittlere Element größer als alle vorherigen ist.
//Die Binäre Suche basiert als auf Annahme.
//Dabei müssen die Vergleichsoperatoren vertauscht werden
//Dabei muss auf Vergleichswerte geachtet werden.
