package learn.android.exo_intent_exo1;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import learn.android.exo_intent_exo1.entitie.Personne;
import learn.android.exo_intent_exo1.manager.PersonneManager;
public class PersonneDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout llMain = new LinearLayout(this);
        llMain.setOrientation(LinearLayout.VERTICAL);
        setContentView(llMain);
        Intent retour = getIntent();
        Personne p = PersonneManager.getById(retour.getStringExtra("id"));
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(p.getIdImage());;
        TextView tv = new TextView(this);
        tv.setText( p.getPrenom());
        llMain.addView(imageView);
        llMain.addView(tv);
    }
}