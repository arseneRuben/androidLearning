package learn.android.exoenclassebd;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import learn.android.exoenclassebd.entite.Player;
import learn.android.exoenclassebd.entite.Position;
import learn.android.exoenclassebd.manager.PlayerManager;
import learn.android.exoenclassebd.service.ConnexionBd;
public class ModActivity extends AppCompatActivity {
    EditText edFirstName, edLastName, edNumero, edPosition;
    Button btnChange, btnCancel;
    Intent intent;
    boolean isUpdate;
    Player player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod);
        intent = getIntent();
        player = new Player();
        int idPlayer = intent.getIntExtra("idPlayer", -1);
        isUpdate = intent.getBooleanExtra("isUpdate", false);
        edFirstName = findViewById(R.id.ed_first_name_mod_activity);
        edLastName = findViewById(R.id.ed_last_name_mod_activity);
        edNumero = findViewById(R.id.ed_numero_mod_activity);
        edPosition = findViewById(R.id.ed_position_mod_activity);
        btnChange = findViewById(R.id.btn_change_mod_activity);
        btnCancel = findViewById(R.id.btn_cancel_mod_activity);
        //set view
        btnChange.setText(isUpdate ? "Update" : "Add");
        if(idPlayer != -1){
            player = PlayerManager.getById(this, idPlayer);
            edPosition.setText(player.getPosition().toString());
            edNumero.setText(String.valueOf(player.getNumber()));
            edFirstName.setText(player.getFirstName());
            edLastName.setText(player.getLastName());
        }
        //set listener
        btnCancel.setOnClickListener(v -> {
            setResult(RESULT_CANCELED);
            finish();
        });
        btnChange.setOnClickListener(v -> {
            player.setFirstName(edFirstName.getText().toString());
            player.setLastName(edLastName.getText().toString());
            player.setNumber(Integer.parseInt(edNumero.getText().toString()));
            player.setPosition(Position.valueOf(edPosition.getText().toString()));
            if (isUpdate) {
                player.setId(intent.getIntExtra("idPlayer", -1));
                PlayerManager.update(ModActivity.this, player);
            } else {
                PlayerManager.add(ModActivity.this, player);
            }
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}