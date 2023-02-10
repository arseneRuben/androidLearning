package learn.android.exoclassevueperso.view;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import learn.android.exoclassevueperso.R;
public class Field extends LinearLayout {
    TextView label;
    EditText text;
    Button btnYes, btnNo;
    FieldType type;
    public enum FieldType {
        Text, Button
    }
    public Field(Context context) {
        super(context);
        init();
    }
    public Field(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init() {
        type = FieldType.Text;
        setLayout();
    }
    private void setLayout() {
        removeAllViews();
        int layoutId = 0;
        View view = null;
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        switch (type) {
            case Text:
                layoutId = R.layout.fieldview_layout_text;
                view = layoutInflater.inflate(layoutId, this);
                text = view.findViewById(R.id.ed_fieldview);
                break;
            case Button:
                layoutId = R.layout.fieldview_layout_btn;
                view = layoutInflater.inflate(layoutId, this);
                btnYes = view.findViewById(R.id.btn_yes_fieldview);
                btnNo = view.findViewById(R.id.btn_no_fieldview);
                break;
            default:
        }
        label = view.findViewById(R.id.tv_fieldview);
    }
    public void setLabel(String labelValue) {
        label.setText(labelValue);
    }
    public void setType(FieldType type) {
        this.type = type;
        setLayout();
    }
}
