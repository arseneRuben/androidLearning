package learn.android.exo_intent_exo3;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
public class ChooseDogActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_dog);
    }

    public void handleClickImage(View view){
        int id = view.getId();
        ImageView imageView = (ImageView) view;
        Intent intent = new Intent();
        intent.putExtra("id_chien",id); //1

        setResult(RESULT_OK, intent); //2
        finish(); //3
    }
}