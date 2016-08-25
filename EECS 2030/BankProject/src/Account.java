/**
 * Created by aamir on 2016-08-06.
 */
public class Account
{
    private double balance;
    private String type;
    private double interest;

    public Account(double amount)
    {
        this.balance = amount;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setInterest(double interest)
    {
        this.interest = interest;
    }

    public void deposit(double amount) throws NegativeAmountException
    {
        if(amount < 0)
        {
            throw new NegativeAmountException("Amount can not be negative");
        }
        else
        {
            this.balance += amount;
        }
    }

    public void withdraw(double amount) throws AmountExceedsBalanceException
    {
        if(amount > this.balance)
        {
            throw new AmountExceedsBalanceException("Amount is more than balance in bank account");
        }
        else
        {
            this.balance -= amount;
        }
    }
}
