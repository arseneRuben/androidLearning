package learn.android.exoclasseviewcombinaison.view;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import learn.android.exoclasseviewcombinaison.R;
public class VignetteView extends RelativeLayout {
    TextView label;
    ImageView image;
    //constructeurr java
    public VignetteView(Context context) {
        super(context);
        init();
    }
    private void init() {
        //creer vur programmatique
        label = new TextView(getContext());
        image = new ImageView(getContext());
        addView(image);
        addView(label);
        //creer ma vue depuis le XML
//        View view = LayoutInflater.from(getContext()).inflate(R.layout.vignette_view_layout, this);
//        label = view.findViewById(R.id.tv_vignette_layout);
//        image = view.findViewById(R.id.img_vignette_layout);
    }
    public VignetteView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        TypedArray customAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.VignetteView);
        String labelValue = customAttributes.getString(R.styleable.VignetteView_label);
        int idImg = customAttributes.getResourceId(R.styleable.VignetteView_id_ressource_img, R.drawable.personne4);
        if (labelValue == null)
            labelValue = "No set";
        setLabel(labelValue);
        setImage(idImg);
        customAttributes.recycle();
    }
    //methode public
    public void setLabel(String label) {
        this.label.setText(label);
    }
    public void setImage(int idResource) {
        image.setImageResource(idResource);
    }
}
