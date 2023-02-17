package learn.android.exoenclassebd.view;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import learn.android.exoenclassebd.MainActivity;
import learn.android.exoenclassebd.ModActivity;
import learn.android.exoenclassebd.R;
import learn.android.exoenclassebd.entite.Player;
import learn.android.exoenclassebd.manager.PlayerManager;
public class PlayerView extends LinearLayout {
    TextView tvPLayerNom, tvNumero;
    Button btnUpdate, btnDelete;
    Player player;
    public PlayerView(Context context) {
        super(context);
        View viewPlayer = LayoutInflater.from(context).inflate(R.layout.player_layout, this);
        tvPLayerNom = viewPlayer.findViewById(R.id.tv_nom_prenom_layout_player);
        tvNumero = viewPlayer.findViewById(R.id.tv_numero_layout_player);
        btnDelete = viewPlayer.findViewById(R.id.btn_delete_layout_player);
        btnUpdate = viewPlayer.findViewById(R.id.btn_update_layout_player);
        btnUpdate.setOnClickListener(v -> handleUpdatePlayer());
        btnDelete.setOnClickListener(v -> handleDeletePlayer());
    }
    public void setPlayer(Player player) {
        this.player = player;
        tvPLayerNom.setText(player.toString());
        tvNumero.setText(String.valueOf(player.getNumber()));
    }
    public void handleDeletePlayer() {
        PlayerManager.delete(getContext(), player.getId());
        LinearLayout linearLayout = (LinearLayout) getParent();
        linearLayout.removeView(this);
    }
    public void handleUpdatePlayer() {
        Intent intent = new Intent(getContext(), ModActivity.class);
        intent.putExtra("isUpdate", true);
        intent.putExtra("idPlayer", player.getId());
        MainActivity mainActivity = (MainActivity) getContext();
        mainActivity.getResultActivity().launch(intent);
    }
}
