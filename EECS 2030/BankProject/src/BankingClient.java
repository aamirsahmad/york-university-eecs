/**
 * Created by aamir on 2016-08-06.
 */
public class BankingClient
{
    private String name;
    private Checking checkingAccount;
    private Savings savingsAccount;
    private SuperSaver superSaverAccount;

    public BankingClient(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public Checking createChecking(double amount)
    {
        return this.checkingAccount = new Checking(amount);
    }

    public Savings createSavings(double amount)
    {
        return this.savingsAccount = new Savings(amount);
    }

    public SuperSaver createSuperSaver(double amount)
    {
        return this.superSaverAccount = new SuperSaver(amount);
    }
}
