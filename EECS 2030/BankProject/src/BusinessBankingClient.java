/**
 * Created by aamir on 2016-08-06.
 */
public class BusinessBankingClient extends BankingClient
{
    private static int transactionsLimit = 0;
    private int numberOfTransactions;
    public BusinessBankingClient(String name)
    {
        super(name);
        this.numberOfTransactions = 0;
    }
}
