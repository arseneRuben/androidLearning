package learn.android.exoenclassebd;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import learn.android.exoenclassebd.entite.Player;
import learn.android.exoenclassebd.entite.Position;
import learn.android.exoenclassebd.manager.PlayerManager;
import learn.android.exoenclassebd.view.PlayerView;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout listeBtn, listePlayer;
    Button btnAdd;
    ArrayList<Player> listPlayersView;
    Context context;
    ActivityResultLauncher<Intent> resultActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);
        listeBtn = findViewById(R.id.ll_liste_btn);
        listePlayer = findViewById(R.id.ll_liste_player);
        btnAdd = findViewById(R.id.btn_add_mainactivity);
        btnAdd.setOnClickListener(v -> {
            Intent intent = new Intent(context, ModActivity.class);
            resultActivity.launch(intent);
        });
        for (int i = 0; i < listeBtn.getChildCount(); i++) {
            listeBtn.getChildAt(i).setOnClickListener(this);
        }
        listPlayersView = PlayerManager.getAll(this);
        refeshViewListPlayer();
        resultActivity = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            Intent intent = result.getData();
//                            if(intent.getBooleanExtra("isUpdate",false)) {
                            listPlayersView = PlayerManager.getAll(MainActivity.this);
//                            }
                            refeshViewListPlayer();
                        }
                    }
                }
        );
    }
    @Override
    public void onClick(View view) {
        String tagValue = view.getTag().toString();
        switch (tagValue) {
            case "all":
                listPlayersView = PlayerManager.getAll(this);
                break;
            case "striker":
                listPlayersView = PlayerManager.getByPosition(this, Position.striker);
                break;
            case "middle":
                listPlayersView = PlayerManager.getByPosition(this, Position.middle);
                break;
            case "defender":
                listPlayersView = PlayerManager.getByPosition(this, Position.defender);
                break;
        }
        refeshViewListPlayer();
    }
    private void refeshViewListPlayer() {
        //vider mon linear layout
        listePlayer.removeAllViews();
        for (Player player : listPlayersView) {
            PlayerView playerView = new PlayerView(this);
            playerView.setPlayer(player);
            listePlayer.addView(playerView);
        }
    }
    public ActivityResultLauncher<Intent> getResultActivity() {
        return resultActivity;
    }
}