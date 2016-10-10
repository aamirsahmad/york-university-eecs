/**
 * Created by aamir on 2016-08-06.
 */
public class Savings extends Account implements Interestable
{
    private static final String TYPE = "SAVINGS";
    private static double savingsInterest = 2.0 / 100;


    public Savings(double amount)
    {
        super(amount);
        this.setType(TYPE);
        this.setInterest(savingsInterest);
    }

    @Override
    public double interestPerYear()
    {
        return this.getBalance() * savingsInterest;
    }
}
