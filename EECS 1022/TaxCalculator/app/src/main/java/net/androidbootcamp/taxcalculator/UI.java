package net.androidbootcamp.taxcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class UI extends AppCompatActivity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.taxBtn).setOnClickListener(this);
        findViewById(R.id.tableBtn).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v)
    {
        String input = ((EditText) findViewById(R.id.from)).getText().toString();
        double income = Double.parseDouble(input);

        if (v.getId() == R.id.tableBtn)
        {
            String upto = ((EditText) findViewById(R.id.upto)).getText().toString();
            double inc = Double.parseDouble(upto);
            String rows = ((EditText) findViewById(R.id.rows)).getText().toString();
            int count = Integer.parseInt(rows);

            LinearLayout myLL =  (LinearLayout) findViewById(R.id.LL);
            for (int i = 0; i < count; i++)
            {
                Tax tax = new Tax(income);
                tax.computeTax();
                double taxAmount = tax.getTax();
                double avg = tax.getAvg();
                double mgn = tax.getMgn();
                String out = String.format("%,14.2f --- %,12.2f --- %.1f%% --- %.1f%%", income, tax.getTax(), 100 * tax.getAvg(), 100 * tax.getMgn());
                TextView tv = new TextView(this);
                tv.setText((out));
                tv.setTextSize(20);
                myLL.addView(tv);
                income += inc;
            }
        }
        else
        {
            Tax tax = new Tax(income);
            tax.computeTax();
            String out = String.format("%,.2f, %.1f%%, %.1f%%", tax.getTax(), 100*tax.getAvg(), 100*tax.getMgn());
            ((TextView) findViewById(R.id.tax)).setText(out);
        }
    }
}
