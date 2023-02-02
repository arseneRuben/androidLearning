package learn.android.exoenclasseinflator2;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.BreakIterator;
import java.util.ArrayList;

import learn.android.exoenclasseinflator2.entite.Player;
import learn.android.exoenclasseinflator2.entite.Position;
import learn.android.exoenclasseinflator2.manager.PlayerManager;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout listeBtn, listePlayer;
    ArrayList<Player> listPlayersView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listeBtn = findViewById(R.id.ll_liste_btn);
        listePlayer = findViewById(R.id.ll_liste_player);
        for (int i = 0; i < listeBtn.getChildCount(); i++) {
            listeBtn.getChildAt(i).setOnClickListener(this);
        }
        listPlayersView = PlayerManager.getAll();
        fillViewWithPlayer();
    }
    @Override
    public void onClick(View view) {
        String tagValue = view.getTag().toString();
        switch (tagValue){
            case "all":
                listPlayersView = PlayerManager.getAll();
                break;
            case "striker":
                listPlayersView = PlayerManager.getByPosition(Position.striker);
                break;
            case "middle":
                listPlayersView = PlayerManager.getByPosition(Position.middle);
                break;
            case "defender":
                listPlayersView = PlayerManager.getByPosition(Position.defender);
                break;
        }
        fillViewWithPlayer();
    }
    private void fillViewWithPlayer() {
        //vider mon linear layout
        listePlayer.removeAllViews();
        for (Player player : listPlayersView) {
            View viewPlayer = getLayoutInflater().inflate(R.layout.player_layout, null);
            TextView tvPLayerNom = viewPlayer.findViewById(R.id.tv_nom_prenom_layout_player);
            tvPLayerNom.setText(player.toString());
            TextView tvNumero  = viewPlayer.findViewById(R.id.tv_numero_layout_player);
            tvNumero.setText(String.valueOf(player.getNumber()));
            listePlayer.addView(viewPlayer);
        }
    }
    ;
}