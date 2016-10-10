package jr.eecs1022.piglatin;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import java.util.Locale;
import android.widget.Toast;
import android.content.Intent;

public class PigLatinActivity extends AppCompatActivity implements TextToSpeech.OnInitListener
{
    private int MY_DATA_CHECK_CODE = 0;
    private TextToSpeech tts = null;
    private PigLatinTranslator engine = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pig_latin);
        this.engine = new PigLatinTranslator();
        Intent checkTTSIntent = new Intent();
        checkTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);
        this.tts = new TextToSpeech(this, this);
    }

    public void translate(View v)
    {
        EditText editText = (EditText) findViewById(R.id.inputText);
        String text = editText.getText().toString();
        engine.setEnglish(text);
        String result = engine.getPig();
        TextView convertedText = (TextView) findViewById(R.id.convertedText);
        convertedText.setText(result);
    }

    public void speak(View v)
    {
        if (tts != null)
        {
            TextView convertedText = (TextView) findViewById(R.id.convertedText);
            String utter = convertedText.getText().toString();
            Toast.makeText(getApplicationContext(), utter, Toast.LENGTH_SHORT).show();
            tts.speak(utter, TextToSpeech.QUEUE_FLUSH, null);

        }
    }

    public void clear(View v)
    {
        EditText editText = (EditText) findViewById(R.id.inputText);
        TextView convertedText = (TextView) findViewById(R.id.convertedText);
        editText.setText("");
        convertedText.setText("");
    }

    @Override
    public void onInit(int initStatus)
    {
        if (initStatus == TextToSpeech.SUCCESS)
        {
            if (tts.isLanguageAvailable(Locale.US) == TextToSpeech.LANG_AVAILABLE)
            {
                tts.setLanguage(Locale.US);
            }
        } else if (initStatus == TextToSpeech.ERROR)
        {
            Toast.makeText(this, "Text To Speech failed...", Toast.LENGTH_LONG).show();
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == MY_DATA_CHECK_CODE)
        {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS)
            {
                tts = new TextToSpeech(this, this);
            } else
            {
                Intent installTTSIntent = new Intent();
                installTTSIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(installTTSIntent);
            }
        }
    }


    @Override
    public void onDestroy()
    {
        // Don't forget to shut down tts!
        if (tts != null)
        {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lig_latin, menu);
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
}
