/**
 * Created by aamir on 2016-08-06.
 */
public class SuperSaver extends Account implements Interestable
{
    private static final String TYPE = "SUPERSAVER";
    private static double supersaverInterest = 1.0 / 100;


    public SuperSaver(double amount)
    {
        super(amount);
        this.setType(TYPE);
        this.setInterest(supersaverInterest);
    }

    @Override
    public double interestPerYear()
    {
        return this.getBalance() * supersaverInterest;
    }
}
