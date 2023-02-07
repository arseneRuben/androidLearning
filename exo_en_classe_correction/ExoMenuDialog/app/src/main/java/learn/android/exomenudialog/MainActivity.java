package learn.android.exomenudialog;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    Context context;
    TextView textName, tvColorSelect;
    LinearLayout llMain;
    Button btnChooseColor, btnChooseImage;
    RelativeLayout rlImage;
    AlertDialog dialog = null;
    int idEdnom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);
        llMain = findViewById(R.id.ll_main_activity);
        btnChooseColor = findViewById(R.id.btn_choose_color);
        btnChooseImage = findViewById(R.id.btn_choose_image);
        tvColorSelect = findViewById(R.id.tv_color_selected);
        rlImage = findViewById(R.id.rl_image);
        btnChooseColor.setOnClickListener(view -> openAdChooseColor(view));
        btnChooseImage.setOnClickListener(view -> openAdChooseImage());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_chose_name) {
            openAdChooseName();
        }
        return true;
    }
    private void openAdChooseName() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Votre nom");
        EditText edNom = new EditText(context);
        idEdnom = View.generateViewId();
        edNom.setId(idEdnom);
        builder.setView(edNom);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                AlertDialog alertDialog = (AlertDialog) dialogInterface;
                EditText edNom = alertDialog.findViewById(idEdnom);
                String nom = edNom.getText().toString();
                if (textName == null) {
                    textName = new TextView(context);
                    textName.setGravity(Gravity.CENTER);
                    textName.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    llMain.addView(textName, 0);
                }
                textName.setText(nom);
            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.show();
    }
    private void openAdChooseColor(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("choisir une couleur");
        builder.setSingleChoiceItems(R.array.list_color, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String colorSelect = getResources().getStringArray(R.array.list_color)[i];
                Toast.makeText(context, "id : " + i + " color : " + colorSelect, Toast.LENGTH_SHORT).show();
                tvColorSelect.setText(colorSelect);
                Button btn = (Button) view;
                btn.setBackgroundColor(Color.parseColor(colorSelect));
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }
    private void openAdChooseImage() {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View viewListeImage = getLayoutInflater().inflate(R.layout.ad_choose_image_layout, null);
        LinearLayout llisteImage = viewListeImage.findViewById(R.id.ll_list_image);
        for (int i = 0; i < llisteImage.getChildCount(); i++) {
            View img = llisteImage.getChildAt(i);
            img.setOnClickListener(view -> {
                ImageView imgClicked = (ImageView) view;
                rlImage.removeAllViews();
                ImageView imageView = new ImageView(context);
                imageView.setImageDrawable(imgClicked.getDrawable());
                rlImage.addView(imageView);
                dialog.dismiss();
            });
        }
        builder.setView(viewListeImage);
        dialog = builder.show();
    }
}