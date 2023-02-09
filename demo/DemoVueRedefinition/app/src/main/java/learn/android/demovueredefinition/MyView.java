package learn.android.demovueredefinition;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
public class MyView extends View implements View.OnClickListener {
    private static final String TAG = "debug_app";
    Paint paint;
    public MyView(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.rgb(randomNb(), randomNb(), randomNb()));
        setOnClickListener(this);
    }
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.rgb(randomNb(), randomNb(), randomNb()));
        setOnClickListener(this);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int tailleDispoParentWidth = MeasureSpec.getSize(widthMeasureSpec);
        int tailleDispoParentHeight = MeasureSpec.getSize(heightMeasureSpec);
        int wMeasure = MeasureSpec.makeMeasureSpec((int) (tailleDispoParentWidth), MeasureSpec.EXACTLY);
        int hMeasure = MeasureSpec.makeMeasureSpec((int) (tailleDispoParentHeight / 2.0), MeasureSpec.EXACTLY);
        setMeasuredDimension(wMeasure, hMeasure);
        Log.d(TAG, "onMeasure: ");
    }
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.d(TAG, "onLayout: ");
    }
    @Override
    protected void onDraw(Canvas canvas) {
        Log.d(TAG, "onDraw: ");
        canvas.drawColor(Color.rgb(randomNb(), randomNb(), randomNb()));
        canvas.drawCircle((float) (getWidth() / 2.0), (float) (getHeight() / 2.0), (float) (Math.min(getWidth(), getHeight()) / 2.0), paint);
    }
    private int randomNb() {
        return (int) (Math.random() * 255);
    }
    @Override
    public void onClick(View v) {
        paint.setColor(Color.rgb(randomNb(), randomNb(), randomNb()));
        invalidate();
    }
}
