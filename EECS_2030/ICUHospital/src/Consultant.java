/**
 * Created by aamir on 2016-08-06.
 */
public class Consultant extends Doctor
{
    private int consultancy;

    public Consultant(String name)
    {
        super(name);
    }

    public int numOfConsultancies()
    {
        return this.consultancy;
    }
}
