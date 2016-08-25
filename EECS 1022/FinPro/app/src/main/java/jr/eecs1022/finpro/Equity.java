package jr.eecs1022.finpro;

import java.util.Date;

/**
 * This class encapsulates an equity investment.
 * @author H. Roumani
 * @since Winter 2016.
 */
public class Equity
{
    private String symbol;
    private int qty;
    private double bookValue;
    private Date acquired;
    private double marketValue;
    private double yield;

    public Equity(String symbol, int qty, double bookValue, Date acquired, double marketValue, double yield)
    {
        this.symbol = symbol;
        this.qty = qty;
        this.bookValue = bookValue;
        this.acquired = acquired;
        this.marketValue = marketValue;
        this.yield = yield;
    }

    public String getSymbol()
    {
        return this.symbol;
    }

    public int getQty()
    {
        return this.qty;
    }

    public double getBookValue()
    {
        return bookValue;
    }

    public Date getAcquired()
    {
        return this.acquired;
    }

    public double getMarketValue()
    {
        return this.marketValue;
    }

    public double getYield()
    {
        return this.yield;
    }

    @Override
    public String toString()
    {
        return "Equity{" +
                "symbol='" + this.symbol + '\'' +
                ", qty=" + this.qty +
                ", bookValue=" + this.bookValue +
                ", acquired=" + this.acquired +
                '}';
    }
}