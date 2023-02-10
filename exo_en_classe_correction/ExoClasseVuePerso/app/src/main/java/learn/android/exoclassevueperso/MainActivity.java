package learn.android.exoclassevueperso;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import learn.android.exoclassevueperso.view.AngleView;
import learn.android.exoclassevueperso.view.Field;
import learn.android.exoclassevueperso.view.ToogleOnOff;
public class MainActivity extends AppCompatActivity {
    LinearLayout llMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llMain = findViewById(R.id.ll_main_act);
        AngleView angleView = new AngleView(this);
        llMain.addView(angleView);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_field_btn:
                Field field = new Field(this);
                field.setType(Field.FieldType.Button);
                field.setLabel("Test 1");
                llMain.addView(field);
                break;
            case R.id.menu_field_text:
                Field field2 = new Field(this);
                field2.setLabel("Test 1");
                llMain.addView(field2);
                break;
            case R.id.menu_redefinition:
                ToogleOnOff toogleOnOff = new ToogleOnOff(this);
                toogleOnOff.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                llMain.addView(toogleOnOff);
                break;
        }
        return true;
    }
}
