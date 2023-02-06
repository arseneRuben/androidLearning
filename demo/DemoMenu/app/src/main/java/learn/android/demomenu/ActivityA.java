package learn.android.demomenu;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;
public class ActivityA extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setText("act A");
        setContentView(tv);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_affiche_msg:
                Toast.makeText(this, "Hello message", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_home:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
            case R.id.menu_start_a:
                startActivity(new Intent(this, ActivityA.class));
                finish();
                break;
        }


        return true;
    }
}