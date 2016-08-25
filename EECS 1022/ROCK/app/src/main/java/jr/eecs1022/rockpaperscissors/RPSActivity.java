package jr.eecs1022.rockpaperscissors;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class RPSActivity extends AppCompatActivity {
    private static final String MODULE = "RSPActivity";

    private int curDrawable;
    private Random random = new Random();
    private enum States {SPLASH, THREE, TWO, ONE, ANSWER};
    private States curState = States.SPLASH;
    private int[] states = {R.drawable.scissors, R.drawable.rock, R.drawable.paper};

    public void buttonPressed(View view) {
        Button button = (Button) findViewById(R.id.button);
        int randomInt = random.nextInt(3);
        switch (curState) {
            case SPLASH:
                curDrawable = R.drawable.splash;
                curState = States.THREE;
                button.setText(getResources().getString(R.string.button_launch));
                break;
            case THREE:
                curDrawable = R.drawable.image3;
                curState = States.TWO;
                button.setText(getResources().getString(R.string.button_text));
                break;
            case TWO:
                curDrawable = R.drawable.image2;
                curState = States.ONE;
                break;
            case ONE:
                curDrawable = R.drawable.image1;
                curState = States.ANSWER;
                break;

            case ANSWER:
                curDrawable = states[randomInt];
                curState = States.SPLASH;
                button.setText(getResources().getString(R.string.button_re));
                break;
        }

        System.out.println("buttonPressed called");
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        imageView.setImageResource(curDrawable);
        System.out.println("buttonPressed done");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rps);
    }

    // Saving the activity state
    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        System.out.println("onSaveInstanceState called");
        super.onSaveInstanceState(outState);
        outState.putInt("image", curDrawable);
        outState.putSerializable("state", curState);


        Button btn = (Button) findViewById(R.id.button);
        outState.putString("str", btn.getText().toString());
    }

    // Restoring the activity state
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        System.out.println("onRestoreInstanceState called");
        super.onRestoreInstanceState(savedInstanceState);
        curDrawable = savedInstanceState.getInt("image");
        curState = (States) savedInstanceState.getSerializable("state");

        Button btn = (Button) findViewById(R.id.button);
        btn.setText(savedInstanceState.getString("str"));

        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(curDrawable);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_r, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
