package ro.pub.cs.systems.eim.Colocviu2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Colocviu1_2MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_2_main);

        Button add = (Button)findViewById(R.id.add);
        add.setOnClickListener(this);
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
                    x = x.concat(" + ");
                    x = x.concat(((EditText)findViewById(R.id.next_term)).getText().toString());
                    ((TextView)findViewById(R.id.allTerms)).setText(x);
                    ((EditText)findViewById(R.id.next_term)).setText("");
                }
        }
    }
}