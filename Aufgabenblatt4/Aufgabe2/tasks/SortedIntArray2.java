public class SortedIntArray2 {
    private int[] array;

    public SortedIntArray2(int[] array) {
        this.array = new int[array.length];
        System.arraycopy(array, 0, this.array, 0, array.length);
        this.sort();
    }

    private void sort() {
      quicksort(0, array.length-1);
    }

    private void quicksort(int untereGrenze, int obereGrenze) {

        int links = untereGrenze;
        int rechts = obereGrenze;
        int pivot = array[untereGrenze + (obereGrenze-untereGrenze)/2]; //Bestimmt das Pivot-Element in der Mitte des Arrays

        //Array in zwei Teile Teilen
        while (links <= rechts) {
            //Falls aktuelles Element auf der linken Seite kleiner ist als das Pivot, gehe zu nächsten Element
            while (array[links] < pivot) {
                links++;
            }
            //Falls aktuelles Element auf der rechten Seite kleiner ist als das Pivot, gehe zu nächsten Element
            while (array[rechts] > pivot) {
                rechts--;
            }
            //Wenn wir ein Element gefunden haben, dass größer als das Pivot und in auf der linken Seite ist -
            // und ein Element, dass kleiner als das Pivot und auf der rechten Seite ist, dann vertauschen wir.
            //Danach werden die Grenzen für die Seiten erhöht bzw. verringert.
            if (links <= rechts) {
                vertauschen(links, rechts);
                links++;
                rechts--;
            }
        }
        //Falls Untergrenze kleiner der dem rechten Element -> Rekursion
        if (untereGrenze < rechts)
            quicksort(untereGrenze, rechts);
        //Falls linkes Element kleiner Obergrenze -> Rekursion
        if (links < obereGrenze)
            quicksort(links, obereGrenze);
    }

    private void vertauschen(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public boolean binarySearch(int elem) {
        int first = 0;
        int last = this.array.length - 1;
        while (first <= last) {
            int current = (first + last) / 2;
            if (this.array[current] > elem) {
                last = current - 1;
            } else if (this.array[current] == elem) {
                return true;
            } else {
                first = current + 1;
            }
        }
        return false;
    }

    public int findSpecialElement(int n) {
       sort();
        int element = 0;

        for(int i = 0; i <= n; i++)
        {
            element = array[i];
        }
        return element;
    }
}

//Java biete für Collections als auch Arrays vorgefertigte Sortiermethoden wie java.util.arrays.sort(), java.util.Collection.sort()
//statisch: Verwendung ohne Objekterzeugung
//Arrays.sort() basiert auf Dual-Pivot Quicksort.