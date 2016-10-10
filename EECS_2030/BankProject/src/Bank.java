/**
 * Created by aamir on 2016-08-06.
 */
public class Bank
{
    private Bank(){}

    public static Bank bankInstance = null;

    public synchronized static Bank getInstance()
    {
        if(bankInstance == null)
        {
            return new Bank();
        }
        return bankInstance;
    }

    public PersonalBankingClient createPersonalBankingClient(String name)
    {
        return new PersonalBankingClient(name);
    }

    public BusinessBankingClient createBusinessBankingClient(String name)
    {
        return new BusinessBankingClient(name);
    }
}
