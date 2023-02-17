package learn.android.exo_intent_exo2;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
public class MainActivity extends AppCompatActivity {
    EditText edFirstName, edLastName;
    RadioGroup rgType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edFirstName = findViewById(R.id.ed_first_name);
        edLastName = findViewById(R.id.ed_last_name);
        rgType = findViewById(R.id.rg_type);
    }
    public void handleBtnContinue(View view) {
        String firstName = edFirstName.getText().toString();
        String lastName = edLastName.getText().toString();
        String type = "";
        switch (rgType.getCheckedRadioButtonId()) {
            case R.id.rb_buisness:
                type = "buisness";
                break;
            case R.id.rb_social:
                type = "scocial";
                break;
        }
        Intent intent = new Intent(this, PrintActivity.class);
        intent.putExtra("first_name", firstName);
        intent.putExtra("last_name", lastName);
        intent.putExtra("type", type);
        startActivity(intent);
    }
}