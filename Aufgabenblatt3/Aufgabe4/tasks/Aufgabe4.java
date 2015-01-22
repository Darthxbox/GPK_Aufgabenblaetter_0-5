import java.util.*;

public class Aufgabe4 {

    private static int assign(int n, int m)
    {
        //Diverse Konsistenzabfragen, falls die Parameter inkonsistent sind, ist die Abbruchbedingung erfüllt.
        if(m > n || n <= 1 || m < 1) return 0;

        Queue<Integer> studenten = new LinkedList<Integer>();
        int chosenOne = 0;

        //Queue mit Zahlen initialisieren
        for(int i = 1; i <= n; i++)
        {
            studenten.offer(i);
        }

        do
        {
            chosenOne++;
            if(chosenOne==m)
            {
                //Falls m-tes Student, entferne aus Queue
                studenten.poll();
                chosenOne=0;
            }
            else
            {
                //Andernfalls stelle aktuellen Studenten wieder an Schlange an
                studenten.offer(studenten.poll());
            }

            //Wenn nur mehr 1 Student übrig ist, 
            if(studenten.size()==1)
                return studenten.poll();
        }
        while (true);
    }


    public static void main(String[] args) {
    }
}

//Würde gehen, jedoch besteht die Queue dann aus einer fixen Größe und die Elemente müssten bei Entnahme reorganisiert werden.