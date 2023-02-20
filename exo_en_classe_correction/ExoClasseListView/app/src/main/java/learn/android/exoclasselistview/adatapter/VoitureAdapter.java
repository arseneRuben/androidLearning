package learn.android.exoclasselistview.adatapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.IOException;
import java.util.List;

import learn.android.exoclasselistview.R;
import learn.android.exoclasselistview.entitie.Voiture;
public class VoitureAdapter extends ArrayAdapter<Voiture> {
    int idLayout;
    public VoitureAdapter(@NonNull Context context, int resource, @NonNull List<Voiture> objects) {
        super(context, resource, objects);
        idLayout = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Voiture voiture = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(idLayout, parent, false);
        }
        ImageView imageView = convertView.findViewById(R.id.img_voiture_layout);
        TextView textView = convertView.findViewById(R.id.tv_voiture_layout);

        textView.setText(voiture.getNom());
        try {
            Bitmap bitmap = BitmapFactory.decodeStream(getContext().getAssets().open(voiture.getImage()));
            imageView.setImageBitmap(bitmap);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return convertView;
    }
}
