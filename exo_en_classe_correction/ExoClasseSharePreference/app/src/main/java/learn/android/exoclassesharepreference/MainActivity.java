package learn.android.exoclassesharepreference;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv_main);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String name = sharedPreferences.getString("name", "inconnu");
        textView.setText("Bonjour " + name);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.btn_add_user) {
            openAdSlectName();
        }
        return true;
    }
    private void openAdSlectName() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Entrez Votre nom");
        builder.setView(R.layout.ad_layout);
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText ed = ((AlertDialog) dialog).findViewById(R.id.ed_ad);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String name = ed.getText().toString();
                if (!name.equalsIgnoreCase("")) {
                    //save dans preference
                    editor.putString("name", name);
                    editor.apply();
                    //modifie la vue
                    textView.setText("Bonjour " + name);
                }else {
                    Toast.makeText(MainActivity.this, "Editext ne doit pas etre vide", Toast.LENGTH_SHORT).show();
                }

            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.show();
    }
}