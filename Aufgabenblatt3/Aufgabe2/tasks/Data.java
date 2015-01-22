public class Data {

    String name;
    int niederschlag;

    public Data(String name, int value)
    {
        this.name = name;
        if(value >= 0) {
            this.niederschlag = value;
        }else{
            System.out.println("Niederschlag muss größer gleich 0 sein!");
        }
    }

    public String getCity()
    {
        return name;
    }

    public int getValue()
    {
        return niederschlag;
    }

    @Override
    public String toString()
    {
        return "{"+name+","+niederschlag+"}";
    }
}
