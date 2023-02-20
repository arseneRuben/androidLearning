package learn.android.demospinneradapter.adapter;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import learn.android.demospinneradapter.R;
import learn.android.demospinneradapter.entite.Student;
public class StudentAdapter extends ArrayAdapter<Student> {
    int idLayout;
    public StudentAdapter(@NonNull Context context, int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);
        idLayout = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Student student = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(idLayout, parent, false);
        }else{
            convertView.setBackgroundColor(Color.RED);

        }
        TextView tvNumero = convertView.findViewById(R.id.tv_number_student_layout);
        TextView tvFirstName = convertView.findViewById(R.id.tv_firstname_student_layout);
        TextView tvLastName = convertView.findViewById(R.id.tv_lastname_student_layout);
        tvNumero.setText(String.valueOf(student.getNumber()));
        tvFirstName.setText(student.getFirstName());
        tvLastName.setText(student.getLastName());
        return convertView;
    }
}
