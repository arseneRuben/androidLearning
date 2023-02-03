package learn.android.exointent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    Button btnStartActA, btnStartActB;
    EditText edNom, edAge;
    TextView textViewRetour;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        //recuperer reference vers obejet de la vuue
        btnStartActA = findViewById(R.id.btn_start_act_a_main_activity);
        btnStartActB = findViewById(R.id.btn_start_act_b_main_activity);
        edAge = findViewById(R.id.ed_age_main_activity);
        edNom = findViewById(R.id.ed_nom_main_activity);
        textViewRetour = findViewById(R.id.tv_retour_main_activity);
        //initialisation
        //redefinition des listener
        btnStartActA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ActivityA.class);
                startActivity(intent);
            }
        });
        btnStartActB.setOnClickListener((view) -> {
            Intent intent = new Intent(context, ActivityB.class);
            //ajoue les data dnas l intent
            String nom = edNom.getText().toString();
            String age = edAge.getText().toString();
            //validation chamvide
            if (nom.equalsIgnoreCase("") || age.equalsIgnoreCase("")) {
                Toast.makeText(context, "attention nom et age ne doivent pas etre vide",Toast.LENGTH_SHORT).show();
            } else {
                intent.putExtra(Constante.nom, nom);
                try {
                    intent.putExtra(Constante.age, Integer.parseInt(age));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                startActivity(intent);
            }
        });
    }
    public void handlebtnStartActC(View view) {
//        ActivityResultLauncher<Intent> resultActivity = registerForActivityResult(
//                new ActivityResultContracts.StartActivityForResult(),
//                new ActivityResultCallback<ActivityResult>() {
//                    @Override
//                    public void onActivityResult(ActivityResult result) {
//                        if (result.getResultCode() == RESULT_OK) {
//
//
//                        }
//                    }
//                }
//        );
        Intent intent = new Intent(this, ActivityC.class);
        startActivityForResult(intent, 42);
//        resultActivity.launch(intent);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 42 && resultCode == RESULT_OK) {
            String nom = data.getStringExtra(Constante.nom);
            String msgRetour = "";
            switch (data.getIntExtra(Constante.idRadioGroupe, R.id.rb_en)) {
                case R.id.rb_fr:
                    msgRetour = "Bonjour";
                    break;
                case R.id.rb_en:
                    msgRetour = "Hello";
                    break;
            }
            textViewRetour.setText(msgRetour + " " + nom);
        }
    }
}