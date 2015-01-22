public class SortedIntArray1 {
    private int[] array;

    public SortedIntArray1(int[] array) {
        this.array = new int[array.length];
        System.arraycopy(array, 0, this.array, 0, array.length);
        this.sort();
    }

    private void sort() {
        int aktuell, vorgaenger;
        int i = 1;


       while(i<array.length)
        {
            //zuweisung von variablen
                aktuell = array[i];
                vorgaenger = array[i-1];

                if(vorgaenger > aktuell)
                {
                    array[i] = vorgaenger;
                    array[i-1] = aktuell;
                    if(i > 1)
                        i--;
                    else
                        i++;
                }
                if(vorgaenger <= aktuell)
                {
                    i++;
                }
        }
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
}

//
//Es wird lediglich eine Schleife benötigt.
//Dieser Algo. ist sehr dem Bubblesort-Algo ähnlich, da bei jedem Schritt die Nachbarn verglichen werden.