package learn.android.exoclasscerclebouge;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
public class Circle {
    PointF position;
    int idPointer;
    int color;
    int rayon;
    boolean isVisible;
    //construct
    public Circle() {
        position = new PointF();
        color = Color.BLUE;
        rayon = 50;
        idPointer = -1;
    }
    //methode
    void draw(Canvas canvas, Paint paint) {
        if (isVisible) {
            paint.setColor(color);
            canvas.drawCircle(position.x, position.y, rayon, paint);
        }
    }
    //get set
    public PointF getPosition() {
        return position;
    }
    public void setPosition(float x, float y) {
        this.position.set(x, y);
    }
    public int getColor() {
        return color;
    }
    public void setColor(int color) {
        this.color = color;
    }
    public int getRayon() {
        return rayon;
    }
    public void setRayon(int rayon) {
        this.rayon = rayon;
    }
    public boolean isVisible() {
        return isVisible;
    }
    public void setVisible(boolean visible) {
        isVisible = visible;

    }
    public int getIdPointer() {
        return idPointer;
    }
    public void setIdPointer(int idPointer) {
        this.idPointer = idPointer;
    }
}
