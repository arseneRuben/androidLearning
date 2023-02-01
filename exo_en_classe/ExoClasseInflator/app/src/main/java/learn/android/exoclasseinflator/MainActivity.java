package learn.android.exoclasseinflator;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import learn.android.exoclasseinflator.entite.Student;
import learn.android.exoclasseinflator.manager.StudentManager;
public class MainActivity extends AppCompatActivity {
    Button btnInflate;
    LinearLayout llListStudent;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        btnInflate = findViewById(R.id.btn_inflate);
        llListStudent = findViewById(R.id.ll_list_student);
        btnInflate.setOnClickListener((view) -> {
            LinearLayout llStudent = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.student_layout, null);
            TextView tvNumero = llStudent.findViewById(R.id.tv_number_student_layout);
            TextView tvFirstName = llStudent.findViewById(R.id.tv_firstname_student_layout);
            TextView tvLastName = llStudent.findViewById(R.id.tv_lastname_student_layout);
            Student studentToAdd = StudentManager.getNext();
            if (studentToAdd != null) {
                tvNumero.setText("" + studentToAdd.getNumber());
                tvFirstName.setText(studentToAdd.getFirstName());
                tvLastName.setText(studentToAdd.getLastName());
                llListStudent.addView(llStudent);
            }
        });
    }
}