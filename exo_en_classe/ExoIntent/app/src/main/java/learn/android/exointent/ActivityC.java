package learn.android.exointent;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
public class ActivityC extends AppCompatActivity {
    EditText editNom;
    Button btnRetour;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        editNom = findViewById(R.id.ed_nom_activity_c);
        btnRetour = findViewById(R.id.btn_retour);
        radioGroup = findViewById(R.id.rg_activity_c);
        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRetour = new Intent();
                intentRetour.putExtra(Constante.nom, editNom.getText().toString());
                intentRetour.putExtra(Constante.idRadioGroupe, radioGroup.getCheckedRadioButtonId());
                setResult(RESULT_OK, intentRetour);
                finish();
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_en:
                        btnRetour.setText("return");
                        break;
                    case R.id.rb_fr:
                        btnRetour.setText("retour");
                        break;
                }
            }
        });
    }
}