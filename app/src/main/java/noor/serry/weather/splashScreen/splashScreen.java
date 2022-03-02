package noor.serry.weather.splashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import noor.serry.weather.Activity.MainActivity;
import noor.serry.weather.R;


public class splashScreen extends AppCompatActivity {
        int timeSleep=5000;
        Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_splash_screen);
        intent = new Intent ( getBaseContext (), MainActivity.class);
        new Handler().postDelayed (new runnable (),timeSleep );
    }

    public void goToMainActivity(){
        startActivity (intent);
        finish ();
    }

    private  class runnable implements Runnable{
        @Override
        public void run() {
            goToMainActivity ();
        }

    }

}