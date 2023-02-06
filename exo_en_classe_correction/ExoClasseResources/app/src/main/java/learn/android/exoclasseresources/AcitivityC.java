package learn.android.exoclasseresources;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
public class AcitivityC extends AppCompatActivity {
    TextView tv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_c);
        tv = findViewById(R.id.tv_nom_welcome);
        tv.setText(getResources().getString(R.string.msg_welcome, getIntent().getStringExtra("nom")));
    }
}