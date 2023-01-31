package learn.android.demoactivity;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
public class StartActivity extends Activity {
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.start_activity_main);
//        LinearLayout llMain = new LinearLayout(context);
//        setContentView(llMain);
//        llMain.setOrientation(LinearLayout.VERTICAL);
//        TextView textView1 = new TextView(context);
//        textView1.setText("coucou 1");
//        TextView textView2 = new TextView(context);
//        textView2.setText("coucou 2");
//        llMain.addView(textView1);
//        llMain.addView(textView2);


    }
}
