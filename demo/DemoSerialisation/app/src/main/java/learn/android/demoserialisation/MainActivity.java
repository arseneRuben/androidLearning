package learn.android.demoserialisation;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    Button btnCliqueMoi;
    ImageView imageBenzema;
    Context context;
    int number = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        imageBenzema = findViewById(R.id.img_to_change);
        btnCliqueMoi = findViewById(R.id.btn_clique_moi);
        imageBenzema.setImageResource(R.drawable.benzema);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Button btn = (Button) view;
//                btn.setText("je change");
                LinearLayout llParent = (LinearLayout) view.getParent();
//                llParent.removeViewAt(0);
                View viewGenere = LayoutInflater.from(context).inflate(R.layout.add_demo_layout, null);
                TextView numero = viewGenere.findViewById(R.id.numero);
                numero.setText(""+ number);
                number++;
                llParent.addView(viewGenere);
            }
        };
        btnCliqueMoi.setOnClickListener(listener);
    }
}