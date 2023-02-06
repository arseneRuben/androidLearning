package learn.android.exoclasseresources;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
public class ActivityA extends AppCompatActivity {
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(context);
        setContentView(horizontalScrollView);

        LinearLayout llVerticaleImage = new LinearLayout(context);
        llVerticaleImage.setOrientation(LinearLayout.HORIZONTAL);
        horizontalScrollView.addView(llVerticaleImage);
        try {
            String[] listeFile = getAssets().list("img");
            Log.d("debug_app", "onCreate:" + listeFile.length);
            for (String imgFile :   listeFile) {
                ImageView imgToAdd = new ImageView(context);
                imgToAdd.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300,1));
                InputStream inputStream = getAssets().open("img/"+imgFile);

//                Drawable drawable = Drawable.createFromStream(inputStream, null);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
//                imgToAdd.setImageDrawable(drawable);
                imgToAdd.setImageBitmap(bitmap);
                llVerticaleImage.addView(imgToAdd);

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        //test pour lire un fichier texte depuis asset
//        try {
//            InputStream inFichierText = getAssets().open("img/test.txt");
//            byte[] buffer = new byte[256];
//            while (inFichierText.read(buffer) != -1){
//                for (byte b :buffer) {
//                    Log.d("debug_app",""+((char)b));
//                }
//
//            }
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}