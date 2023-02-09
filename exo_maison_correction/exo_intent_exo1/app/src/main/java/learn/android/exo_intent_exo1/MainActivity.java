package learn.android.exo_intent_exo1;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

import learn.android.exo_intent_exo1.entitie.Personne;
import learn.android.exo_intent_exo1.manager.PersonneManager;
import learn.android.exo_intent_exo1.view.CardView;
public class MainActivity extends AppCompatActivity {
    LinearLayout llMain;
    ArrayList<Personne> listPersonne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llMain = findViewById(R.id.ll_main);
        listPersonne = PersonneManager.getAll();
        addPersonneToView();
    }
    private void addPersonneToView() {
        for (Personne personne : listPersonne) {
            CardView cardView = new CardView(this);
            cardView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1));
            cardView.setPersonne(personne);
            llMain.addView(cardView);
        }
    }
}