package learn.android.exo_intent_exo3;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
public class MainActivity extends AppCompatActivity {
    ActivityResultLauncher<Intent> resultLauncher;
    LinearLayout llImageArea;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llImageArea = findViewById(R.id.ll_image_area);
        resultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            //do instruction when result
                            Intent intent = result.getData();
                            int id = intent.getIntExtra("id_chien", R.id.toutou1);

                            llImageArea.removeAllViews();;
                            ImageView imageView = new ImageView(MainActivity.this);
                            switch (id){
                                case R.id.toutou1:
                                    imageView.setImageResource(R.drawable.chien1);
                                    break;
                                case R.id.toutou2:
                                    imageView.setImageResource(R.drawable.chien2);
                                    break;
                                case R.id.toutou3:
                                    imageView.setImageResource(R.drawable.chien3);
                                    break;
                            }
                            llImageArea.addView(imageView);
                        }
                    }
                }
        );
    }
    public void handleBtnChoose(View view) {
        resultLauncher.launch(new Intent(this, ChooseDogActivity.class));
    }
}