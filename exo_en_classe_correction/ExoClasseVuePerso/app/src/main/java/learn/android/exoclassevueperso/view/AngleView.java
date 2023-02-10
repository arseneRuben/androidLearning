package learn.android.exoclassevueperso.view;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
public class AngleView extends View {
    int angleValue;
    Paint paint;
    Rect arrowUpPosition, arrowDownPosition, angleValuePosition;
    int maxHeight;
    public AngleView(Context context) {
        super(context);
        init();
    }
    private void init(){
        paint = new Paint();
        arrowUpPosition= new Rect();
        arrowDownPosition = new Rect();
        angleValuePosition= new Rect();
        angleValue = 0;
        maxHeight = 250;
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(widthMeasureSpec, MeasureSpec.makeMeasureSpec(maxHeight,MeasureSpec.AT_MOST));
    }
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        arrowUpPosition.set((int) (2 * getWidth() / 18.0), (int) (1 * getHeight()/6.0), (int) (4*getWidth() / 18.0), (int) (2*getHeight() /6.0));
        arrowDownPosition.set((int) (2 * getWidth() / 18.0), (int) (4 * getHeight()/6.0), (int) (4*getWidth() / 18.0), (int) (5*getHeight() /6.0));
        angleValuePosition.set((int) (1 * getWidth() / 18.0), (int) (2 * getHeight()/6.0), (int) (5*getWidth() / 18.0), (int) (4*getHeight() /6.0));

    }
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.LTGRAY);
        paint.setColor(Color.WHITE);
        canvas.drawRect(arrowUpPosition,paint);
        canvas.drawRect(arrowDownPosition,paint);
        canvas.drawRect(angleValuePosition,paint);

    }
}
