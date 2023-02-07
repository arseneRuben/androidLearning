package learn.android.exoclasseviewcombinaison;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import learn.android.exoclasseviewcombinaison.view.VignetteView;
public class MainActivity extends AppCompatActivity {
    LinearLayout llMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llMain = findViewById(R.id.ll_main_act);
        VignetteView vignetteView1 = new VignetteView(this);
        vignetteView1.setLabel("Test 1");
        vignetteView1.setImage(R.drawable.personne1);
        VignetteView vignetteView2 = new VignetteView(this);
        vignetteView2.setLabel("Test 12");
        vignetteView2.setImage(R.drawable.personne2);
        llMain.addView(vignetteView1);
        llMain.addView(vignetteView2);
    }
}
