/**
 * Created by aamir on 2016-08-06.
 */
public class Checking extends Account
{
    private static final String TYPE = "CHECKING";
    private static double checkingInterest = 0;


    public Checking(double amount)
    {
        super(amount);
        this.setType(TYPE);
        this.setInterest(checkingInterest);
    }
}
