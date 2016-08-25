/**
 * Created by aamir on 2016-08-06.
 */
public class Surgeon extends Doctor
{
    private int surgery;

    public Surgeon(String name)
    {
        super(name);
    }

    public int numOfSurgeries()
    {
        return this.surgery;
    }
}
