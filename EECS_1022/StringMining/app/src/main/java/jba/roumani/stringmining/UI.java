package jba.roumani.stringmining;

import android.graphics.Typeface;
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
    private StringAnalyzer analyzer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        ((Button) findViewById(R.id.compute)).setOnClickListener(this);
        this.analyzer = new StringAnalyzer();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ui, menu);
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
        String data = ((EditText) findViewById(R.id.data)).getText().toString();
        String character = ((EditText) findViewById(R.id.character)).getText().toString();
        String substring = ((EditText) findViewById(R.id.substring)).getText().toString();
        this.analyzer.setData(data);
        String out1 = "Frequency of " + character + " = ";
        out1 += String.format("%.1f%%", 100.0 * analyzer.charCount(character) / data.length());
        ((TextView) findViewById(R.id.output0)).setText(out1);
        ((TextView) findViewById(R.id.output1)).setText("Substring count = " + analyzer.substringCount(substring));
        ((TextView) findViewById(R.id.output2)).setText("Cdn Pstal Code: " + analyzer.extractPostal());
        ((TextView) findViewById(R.id.output3)).setText("Longest Word: " + analyzer.longestWord());
    }
}
