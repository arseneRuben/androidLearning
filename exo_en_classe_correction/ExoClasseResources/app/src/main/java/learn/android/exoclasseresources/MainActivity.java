package learn.android.exoclasseresources;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.IOException;
public class MainActivity extends AppCompatActivity {
    LinearLayout llMain;
    Context context;
    EditText editTextNom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        llMain = new LinearLayout(context);
        llMain.setOrientation(LinearLayout.VERTICAL);
        setContentView(llMain);
        Button btnStartActA = new Button(context);
        btnStartActA.setText("Act A");
        llMain.addView(btnStartActA);
        Button btnStartActB = new Button(context);
        btnStartActB.setText("Act B");
        llMain.addView(btnStartActB);
        Button btnStartActC = new Button(context);
        btnStartActC.setText("Act C");
        llMain.addView(btnStartActC);
        editTextNom = new EditText(context);
        llMain.addView(editTextNom);
        //listerner
        btnStartActA.setOnClickListener(view -> {
            startActivity(new Intent(context, ActivityA.class));
        });
        btnStartActB.setOnClickListener(view -> {
            startActivity(new Intent(context, ActivityB.class));
        });
        btnStartActC.setOnClickListener(view -> {
            String nom = editTextNom.getText().toString();
            if(!nom.equalsIgnoreCase("")) {
                Intent intent = new Intent(context, AcitivityC.class);
                intent.putExtra("nom", nom);
                startActivity(intent);
            }else {
                Toast.makeText(context, getResources().getString(R.string.msg_toast_validation_nom), Toast.LENGTH_SHORT).show();
            }
        });
    }
}