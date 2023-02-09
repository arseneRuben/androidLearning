package learn.android.demobuttonperso;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomButton customButton = new CustomButton(this);
        customButton.setText("clique moi");
        setContentView(customButton);
    }
}
class CustomButton extends Button implements View.OnClickListener {
    Paint paint;
    Rect rect ;
    int color;
    public CustomButton(Context context) {
        super(context);
        paint = new Paint();
        color = colorRandom();
        paint.setColor(color);
        rect = new Rect();
        setOnClickListener(this);
    }
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        rect.set(0,0,150,getHeight());
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(rect,paint);
    }
    private int colorRandom(){
        return Color.rgb((int) (Math.random()*255), (int) (Math.random()*255), (int) (Math.random()*255)) ;
    }
    @Override
    public void onClick(View v) {
        int colorT = colorRandom();
        paint.setColor(colorT);
//        invalidate();
    }
}