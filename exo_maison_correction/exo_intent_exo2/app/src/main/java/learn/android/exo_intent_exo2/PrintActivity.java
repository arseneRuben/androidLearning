package learn.android.exo_intent_exo2;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
public class PrintActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String firstName = intent.getStringExtra("first_name");
        String lastName = intent.getStringExtra("last_name");
        String type = intent.getStringExtra("type");
        TextView tv = new TextView(this);
        tv.setText(firstName + ", " + lastName + ", " + type);
        setContentView(tv);
    }
}