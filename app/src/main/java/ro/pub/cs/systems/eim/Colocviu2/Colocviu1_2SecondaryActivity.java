package ro.pub.cs.systems.eim.Colocviu2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class Colocviu1_2SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // intent from parent
        Intent intentFromParent = getIntent();
        Bundle data = intentFromParent.getExtras();
        String x = data.get("key").toString();
        String[] adunare = x.split("\\+");
        int sum = 0;
        for (int i = 0; i < adunare.length; i++) {
            sum += Integer.valueOf(adunare[i]);
        }
        // process information from data ...
        Log.d("eim", String.valueOf(sum));
        // intent to parent
        Intent intentToParent = new Intent();
        intentToParent.putExtra("ro.pub.cs.systems.eim.lab04.anotherKey", "33");
        intentToParent.putExtra("ret", String.valueOf(sum));
        setResult(33, intentToParent);
        finish();
    }
}