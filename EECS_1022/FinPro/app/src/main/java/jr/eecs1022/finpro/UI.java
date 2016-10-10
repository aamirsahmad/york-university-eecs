package jr.eecs1022.finpro;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

public class UI extends AppCompatActivity
{
    private TableLayout table;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        this.table = (TableLayout) findViewById(R.id.myTableLayout);
        this.insertHeader();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_ui, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id == R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onAnalyze(View v)
    {
        String portfolioName = ((TextView) findViewById(R.id.portfolioName)).getText().toString();
        Resources res = getResources();
        String[] data = res.getStringArray(res.getIdentifier(portfolioName, "array", this.getPackageName()));
        PortfolioAnalyzer portfolio = new PortfolioAnalyzer(portfolioName, data);
        List<Equity> list = portfolio.getPortfolio();
        this.table.removeAllViews();
        this.insertHeader();
        for (Equity equity : list)
        {
            this.appendRow(equity);
        }
        ((TextView) findViewById(R.id.summary)).setText(portfolio.toString());
    }


    private void appendRow(Equity equity)
    {
        TableRow row = (TableRow) LayoutInflater.from(this).inflate(R.layout.my_row, null);
        ((TextView) row.findViewById(R.id.symbol)).setText(equity.getSymbol());
        ((TextView) row.findViewById(R.id.qty)).setText(String.format("%d", equity.getQty()));
        ((TextView) row.findViewById(R.id.bookValue)).setText(String.format("%.2f", equity.getBookValue()));
        ((TextView) row.findViewById(R.id.date)).setText(String.format("%td/%<tm/%<tY", equity.getAcquired()));
        ((TextView) row.findViewById(R.id.marketValue)).setText(String.format("%.2f", equity.getMarketValue()));
        ((TextView) row.findViewById(R.id.yield)).setText(String.format("%.1f%%", 100 * equity.getYield()));
        this.table.addView(row);
        this.table.requestLayout();
    }

    private void insertHeader()
    {
        TableRow row = (TableRow) LayoutInflater.from(this).inflate(R.layout.my_row, null);
        ((TextView) row.findViewById(R.id.symbol)).setText("Symbol");
        ((TextView) row.findViewById(R.id.qty)).setText("Quantity");
        ((TextView) row.findViewById(R.id.bookValue)).setText("BookValue");
        ((TextView) row.findViewById(R.id.date)).setText("Acquired");
        ((TextView) row.findViewById(R.id.marketValue)).setText("MarketValue");
        ((TextView) row.findViewById(R.id.yield)).setText("Yield");
        this.table.addView(row);
        this.table.requestLayout();
    }
}