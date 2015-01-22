public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction(int num, int denom) throws InvalidDenominatorException{
        if(denom == 0)
        {
            InvalidDenominatorException ex = new InvalidDenominatorException();
            throw ex;
        }

        this.numerator = num;
        this.denominator = denom;
        reduce();
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public Fraction add(Fraction frac) throws InvalidDenominatorException, NullObjectException{
        int newNum, newDenom;
        InvalidDenominatorException exI = new InvalidDenominatorException();
        NullObjectException exN = new NullObjectException();

        if(frac == null)
        {
            throw exN;
        }

        if(frac.denominator == 0)
        {
            throw exI;
        }

        newDenom = (denominator * frac.denominator);
        newNum = ((frac.numerator * denominator) + (numerator * frac.denominator));

        Fraction f = new Fraction(newNum,newDenom);
        return f;
    }


    private int gcd(int a, int b) {
        int r = a % b;
        while (r != 0) {
            a = b;
            b = r;
            r = a % b;
        }
        return b;
    }


    private void reduce() {
        if (this.numerator == 0)
            return;
        int gcd = gcd((this.numerator < 0) ? (-this.numerator) : this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

}

// Sollte ein Bruch den Nenner oder den Zähler 0 haben, ist das Mathematisch nicht korrekt und zeigt auf einen Fehler hin.
// Würde hier eine Assertion eingefügt werden, erkennt man klar und deutlich, dass ein Fehler aufgetreten ist.

// Assertions eignen sich besser um Programmierfehler aufzudecken.
// Exception eignen sich besser um Benutzereingaben oder außer Kontrolle geratene Funktionen abzufagen.

