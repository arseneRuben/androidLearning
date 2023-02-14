package learn.android.demoeventtouch;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {
    EditText edEventWatcher;
    private String TAG = "debug_app";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edEventWatcher = findViewById(R.id.ed_event_watcher);
        edEventWatcher.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(TAG, "beforeTextChanged: " + s);
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "onTextChanged: " + s);
            }
            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "afterTextChanged: " + s.toString());
                int colorText = Color.RED;
                if (s.length() >= 5) {
                    colorText = Color.GREEN;
                }
                edEventWatcher.setTextColor(colorText);
            }
        });
    }
}