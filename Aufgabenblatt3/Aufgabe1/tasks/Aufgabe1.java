
public class Aufgabe1 {

    int counter = 0;
    int overflowCounter = 0;
    int max;

    //Konstruktor welcher den Maximalwert initialisiert.
    public Aufgabe1(int max)
    {
        this.max = max;
    }

    //Geta-Methoden
    public int getCounter()
    {
        return counter;
    }
    public int getOverflowCounter()
    {
        return overflowCounter;
    }

    //Setzt beide Variabeln wieder auf 0 zurück
    public void reset()
    {
        counter = 0;
        overflowCounter = 0;
    }

    public void increment()
    {
       counter++;

        //Falls aktuelle Zahl höher als das Maximum, setze die aktuelle auf 0 und erhöhe den Overflow um 1.
        if(counter >= max)
        {
            counter = 0;
            overflowCounter++;
        }
    }

    public static void main(String[] args) {

    }
}

//Klassen dienen zur Abbildung von realen Objekten. Dies setzen sich aus Attribute und Methoden zusammen.

//Die Objekte von Klassen unterscheiden sich mit deren Attributen von einander.

//Konstruktoren werden dazu benötigt, um Objekte in einen Anfangszustand zu bringen. Das wird mit der Übergabe von Parametern erreicht.

/*Bei beiden handelt es sich um Zugriffsmodifikatoren. Während public öffentlich sichtbar ist 
//alle Mitglieder anderer Klassen darauf zugreifen können, ist dies bei private nicht der Fall. 
private ist privat sichtbar und kann nur von Mitgliedern der selben Klassen verwendet werden.*/

//this: Ist eine Referenz auf ein Objekt, welches sich in der selben Klasse befindet.
//this(): Dient als Aufruf eines zusätzlichen Kontruktors in der selben Klasse.
