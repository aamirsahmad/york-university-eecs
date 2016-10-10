/**
 * Created by aamir on 2016-08-06.
 */
public class PersonalBankingClient extends BankingClient
{
    private static int transactionsLimit = 20;
    private int numberOfTransactions;

    public PersonalBankingClient(String name)
    {
        super(name);
        this.numberOfTransactions = 0;

    }
}
