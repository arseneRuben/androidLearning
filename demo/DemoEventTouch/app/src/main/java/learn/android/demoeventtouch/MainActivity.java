package learn.android.demoeventtouch;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    private EditText edEventWatcher;
    private TextView tvPositionEtat;
    private String TAG = "debug_app";
    private LinearLayout llEventDirection;
    PointF pointDown, pointUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edEventWatcher = findViewById(R.id.ed_event_watcher);
        tvPositionEtat = findViewById(R.id.tv_event_on_touch);
        llEventDirection = findViewById(R.id.ll_event_direction);
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
        pointUp = new PointF();
        pointDown = new PointF();
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int actionMasked = event.getActionMasked();
        tvPositionEtat.setTextColor(Color.WHITE);
        float xPosition = event.getX();
        float yPosition = event.getY();
        StringBuffer msg = new StringBuffer();
        msg.append("position x :");
        if (actionMasked == MotionEvent.ACTION_DOWN) {
//            Log.d(TAG, "onTouchEvent: down");
            tvPositionEtat.setBackgroundColor(Color.YELLOW);
            msg.append(xPosition + " y: " + yPosition);
            pointDown.set(xPosition, yPosition);
        }
        if (actionMasked == MotionEvent.ACTION_MOVE) {
//            Log.d(TAG, "onTouchEvent: move");
            tvPositionEtat.setBackgroundColor(Color.BLUE);
            msg.append(xPosition + " y: " + yPosition);
        }
        if (actionMasked == MotionEvent.ACTION_UP) {
//            Log.d(TAG, "onTouchEvent: up");
            tvPositionEtat.setBackgroundColor(Color.RED);
            msg.append(xPosition + " y: " + yPosition);
            pointUp.set(xPosition, yPosition);
            float dx = pointDown.x - pointUp.x;
            float dy = pointDown.y - pointUp.y;
            if (Math.abs(dx) > Math.abs(dy)) {
                Log.d(TAG, "onTouchEvent: gauche droite");
                //si droite
                if(dx > 0){
                    llEventDirection.setBackgroundColor(Color.BLUE);
                }else {
                    //si gauche
                    llEventDirection.setBackgroundColor(Color.RED);
                }
            } else {
                Log.d(TAG, "onTouchEvent: haut bas");
                if(dy > 0){
                    llEventDirection.setBackgroundColor(Color.GREEN);
                }else{
                    llEventDirection.setBackgroundColor(Color.YELLOW);
                }
            }
        }
        tvPositionEtat.setText(msg.toString());
        return true;
    }
}