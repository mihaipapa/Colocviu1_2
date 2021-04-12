package ro.pub.cs.systems.eim.Colocviu2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Colocviu1_2MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_2_main);

        Button add = (Button)findViewById(R.id.add);
        add.setOnClickListener(this);

        Button compute = (Button)findViewById(R.id.compute);
        compute.setOnClickListener(this);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        switch (requestCode) {
            case 33:
                if (resultCode == 33) {
                    Bundle data = intent.getExtras();
                    Toast.makeText(getApplication(), data.get("ret").toString(), Toast.LENGTH_LONG).show();
                }
                break;

            // process other request codes
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.add:
                String x = ((TextView)findViewById(R.id.allTerms)).getText().toString();
                if (x == "") {
                    x = x.concat(((EditText)findViewById(R.id.next_term)).getText().toString());
                    ((TextView)findViewById(R.id.allTerms)).setText(x);
                    ((EditText)findViewById(R.id.next_term)).setText("");
                } else {
                    x = x.concat("+");
                    x = x.concat(((EditText)findViewById(R.id.next_term)).getText().toString());
                    ((TextView)findViewById(R.id.allTerms)).setText(x);
                    ((EditText)findViewById(R.id.next_term)).setText("");
                }
                break;
            case R.id.compute:
                Intent intent = new Intent(getApplicationContext(), Colocviu1_2SecondaryActivity.class);
                intent.putExtra("key", ((TextView)findViewById(R.id.allTerms)).getText().toString());
                startActivityForResult(intent, 33);
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("all", ((TextView)findViewById(R.id.allTerms)).getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("all")) {
            ((TextView)findViewById(R.id.allTerms)).setText(savedInstanceState.getString( "all"));
        }
    }
}