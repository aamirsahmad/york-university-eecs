/**
 * Created by aamir on 2016-08-06.
 */
public class Main
{
    public static void main(String[] args)
    {
        Bank cibc = Bank.getInstance();

        PersonalBankingClient account1 = cibc.createPersonalBankingClient("Hamza");
        account1.createChecking(0.0);
        account1.createSavings(10.0);
        account1.createSuperSaver(250.0);

        BusinessBankingClient account2 = cibc.createBusinessBankingClient("LimeLight");
        account2.createChecking(0.0);
        account2.createSavings(1200);
        account2.createSuperSaver(500);

    }
}
