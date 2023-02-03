package learn.android.exointent;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
public class ActivityB extends AppCompatActivity {
    TextView textNomAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        textNomAge = findViewById(R.id.tv_affichage_nom_age_activity_b);
        Intent intent = getIntent();
        StringBuffer buffer = new StringBuffer();
        buffer.append("Bonjour ");

        buffer.append(intent.getStringExtra(Constante.nom));
        buffer.append(" tu as ");
        buffer.append(intent.getIntExtra(Constante.age, -1));
        buffer.append(" ans");

        textNomAge.setText(buffer);
    }



    public void handleBtnRetour(View view){
        finish();
    }
}