package learn.android.exoclassevueperso.view;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.widget.Button;

import learn.android.exoclassevueperso.R;
public class ToogleOnOff extends Button implements View.OnClickListener {
    Paint paint;
    int colorOn, colorOff;
    Rect leftRect, rightRect;
    boolean isSelect;
    String textOn, textOff;
    int sizeRect;
    public ToogleOnOff(Context context) {
        super(context);
        init();
    }
    private void init() {
        paint = new Paint();
        colorOff = getResources().getColor(R.color.color_off);
        colorOn = getResources().getColor(R.color.color_on);
        leftRect = new Rect();
        rightRect = new Rect();
        isSelect = true;
        textOn = "On";
        textOff = "Off";
        setText(isSelect ? textOn : textOff);
        setOnClickListener(this);
    }
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        sizeRect = (int) (getWidth() / 10.0);
        leftRect.set((int) (getWidth() / 6.0), getPaddingTop() + 5, (int) ((getWidth() / 6.0) + sizeRect), getHeight() - (getPaddingBottom() + 5));
        rightRect.set((int) (5.0 * getWidth() / 6.0), getPaddingTop() + 5, (int) (5.0 * getWidth() / 6.0 + sizeRect), getHeight() - (getPaddingBottom() + 5));
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isSelect)
            paint.setColor(colorOn);
        else
            paint.setColor(colorOff);
        canvas.drawRect(leftRect, paint);
        canvas.drawRect(rightRect, paint);
    }
    @Override
    public void onClick(View v) {
        isSelect = !isSelect;
        setText(isSelect ? textOn : textOff);
    }
}
