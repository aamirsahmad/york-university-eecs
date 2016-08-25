package net.androidbootcamp.taxcalculator;

public class Tax
{
    private double income;
    private double tax, avg, mgn;

    public static final double BRACKET_1 = 43561;
    public static final double BRACKET_2 = 87123;
    public static final double BRACKET_3 = 135054;
    public static final double RATE_1 = 0.21;
    public static final double RATE_2 = 0.33;
    public static final double RATE_3 = 0.38;
    public static final double RATE_4 = 0.42;

    public Tax(double income)
    {
        this.income = income;
    }

    public double getTax()
    {
        return this.tax;
    }

    public double getAvg()
    {
        return this.avg;
    }

    public double getMgn()
    {
        return this.mgn;
    }


    public void computeTax()
    {
        double tmp = this.income;
        if (tmp <= BRACKET_1)
        {
            this.tax = RATE_1 * tmp;
            this.mgn = RATE_1;
        }
        else if (tmp <= BRACKET_2)
        {
            this.tax = RATE_1 * BRACKET_1;
            tmp = tmp - BRACKET_1;
            this.tax += RATE_2 * tmp;
            this.mgn = RATE_2;
        }
        else if (tmp <= BRACKET_3)
        {
            this.tax = RATE_1 * BRACKET_1;
            this.tax += RATE_2 * (BRACKET_2 - BRACKET_1);
            tmp = tmp - BRACKET_2;
            this.tax += RATE_3 * tmp;
            this.mgn = RATE_3;
        }
        else
        {
            this.tax = RATE_1 * BRACKET_1;
            this.tax += RATE_2 * (BRACKET_2 - BRACKET_1);
            this.tax += RATE_3 * (BRACKET_3 - BRACKET_2);
            tmp = tmp - BRACKET_3;
            this.tax += RATE_4 * tmp;
            this.mgn = RATE_4;
        }
        this.avg = this.tax / this.income;

    }

    public static void main(String[] args)
    {
        Tax tax = new Tax(100000);
        tax.computeTax();
        System.out.printf("%,.2f, %.1f%%, %.1f%%\n", tax.getTax(), 100*tax.getAvg(), 100*tax.getMgn());

        double income = 5000;
        double inc = 10000;
        int rows = 20;

        for (int count = 0; count < 20; count = count + 1)
        {
            tax = new Tax(income);
            tax.computeTax();
            System.out.printf("%,15.2f, %12.2f, %.1f%%, %.1f%%\n", income, tax.getTax(), 100 * tax.getAvg(), 100 * tax.getMgn());
            income += inc;
        }
    }
}
