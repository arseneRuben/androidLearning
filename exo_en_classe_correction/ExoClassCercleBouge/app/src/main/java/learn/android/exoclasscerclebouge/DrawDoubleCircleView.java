package learn.android.exoclasscerclebouge;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
public class DrawDoubleCircleView extends View {
    int bgColor;
    Circle cercle1,cercle2;
    Paint paint;
    public DrawDoubleCircleView(Context context) {
        super(context);
        init();
    }
    public DrawDoubleCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
        TypedArray attributPerso = getContext().obtainStyledAttributes(attrs, R.styleable.DrawDoubleCircleView);
        bgColor = attributPerso.getColor(R.styleable.DrawDoubleCircleView_bg_color, Color.LTGRAY);
        attributPerso.recycle();
    }
    private void init() {
        paint = new Paint();
        bgColor = Color.LTGRAY;
        cercle1 = new Circle();
        cercle2 = new Circle();
        cercle2.setColor(Color.RED);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // get pointer index from the event object
        int pointerIndex = event.getActionIndex();
        // get pointer ID from pointerIndex
        int pointerId = event.getPointerId(pointerIndex);
        // get action
        int maskedAction = event.getActionMasked();
        switch (maskedAction) {
            case MotionEvent.ACTION_DOWN:
                cercle1.setVisible(true);
                cercle1.setIdPointer(pointerId);
                cercle1.setPosition(event.getX(pointerId), event.getY(pointerId));
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                cercle2.setVisible(true);
                cercle2.setIdPointer(pointerId);
                cercle2.setPosition(event.getX(pointerId), event.getY(pointerId));
                break;
            case MotionEvent.ACTION_MOVE:
                if(cercle1.getIdPointer() != -1)
                cercle1.setPosition(event.getX(cercle1.getIdPointer()), event.getY(cercle1.getIdPointer()));
                if(cercle2.getIdPointer() != -1)
                    cercle2.setPosition(event.getX(cercle2.getIdPointer()), event.getY(cercle2.getIdPointer()));
                break;
            case MotionEvent.ACTION_POINTER_UP:
                cercle2.setVisible(false);
                cercle2.setIdPointer(-1);
                break;
            case MotionEvent.ACTION_UP:
                cercle1.setVisible(false);
                cercle1.setIdPointer(-1);
                break;
        }
        invalidate();
        return true;
    }
    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }
    //    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        int hauteurVoulu = (int) (MeasureSpec.getSize(heightMeasureSpec) / 2.0);
//        setMeasuredDimension(widthMeasureSpec, MeasureSpec.makeMeasureSpec(hauteurVoulu, MeasureSpec.EXACTLY));
//    }
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(bgColor);
        cercle1.draw(canvas, paint);
        cercle2.draw(canvas, paint);
    }
}

