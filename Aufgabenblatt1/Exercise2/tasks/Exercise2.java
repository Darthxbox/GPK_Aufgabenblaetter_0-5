
public class Exercise2 {

    private static int min(int a, int b) {
        if(a < b)
        {
            return a;
        }
        else if (b < a)
        {
            return b;
        }
        else
        {
            return a;
        }
    }

    public static void main(String[] args) {
        System.out.println(min(3,4));
        System.out.println(min(4,4));
        System.out.println(min(5,4));
    }
}
