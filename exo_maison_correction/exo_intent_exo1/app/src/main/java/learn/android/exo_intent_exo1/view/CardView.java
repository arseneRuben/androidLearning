package learn.android.exo_intent_exo1.view;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import learn.android.exo_intent_exo1.PersonneDetailActivity;
import learn.android.exo_intent_exo1.R;
import learn.android.exo_intent_exo1.entitie.Personne;
public class CardView extends RelativeLayout implements View.OnClickListener {
    ImageView imgCard;
    TextView textCard;
    String idPersonne;
    public CardView(Context context) {
        super(context);
        init();
    }
    public CardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.card_layout, this);
        setOnClickListener(this);
        imgCard = view.findViewById(R.id.img_cardview);
        textCard = view.findViewById(R.id.tv_cardview);
    }
    public void setImgCard(int idImgRessource) {
        imgCard.setImageResource(idImgRessource);
    }
    public void setTextCard(String textValue) {
        this.textCard.setText(textValue);
    }
    public void setPersonne(Personne personne) {
        idPersonne = personne.getId();
        setTextCard(personne.getPrenom());
        setImgCard(personne.getIdImage());
    }
    @Override
    public void onClick(View v) {
        Toast.makeText(getContext(), idPersonne, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getContext(), PersonneDetailActivity.class);
        intent.putExtra("id",idPersonne);
        getContext().startActivity(intent);
    }
}
