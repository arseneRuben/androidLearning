package learn.android.exoclasselistview;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import learn.android.exoclasselistview.adatapter.VoitureAdapter;
import learn.android.exoclasselistview.entitie.Voiture;
import learn.android.exoclasselistview.manager.VoitureManager;
import learn.android.exoclasselistview.service.ConnexionBD;
public class MainActivity extends AppCompatActivity {
    ListView listView;
    VoitureAdapter voitureAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConnexionBD.cpyDataBaseFromAsset(this);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lv_main);
        ArrayList<Voiture> voitures = VoitureManager.getAll(this);
        voitureAdapter = new VoitureAdapter(this, R.layout.voiture_layout, voitures);
        listView.setAdapter(voitureAdapter);
    }
}