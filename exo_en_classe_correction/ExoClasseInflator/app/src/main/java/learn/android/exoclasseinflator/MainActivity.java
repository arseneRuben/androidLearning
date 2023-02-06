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
            //deserialisé la vue de l etudiant
            LinearLayout llStudent = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.student_layout, null);
            //aller chercher les differents elements de la vue a modifier
            TextView tvNumero = llStudent.findViewById(R.id.tv_number_student_layout);
            TextView tvFirstName = llStudent.findViewById(R.id.tv_firstname_student_layout);
            TextView tvLastName = llStudent.findViewById(R.id.tv_lastname_student_layout);
            //recuperer le prochain etudiant a afficher
            Student studentToAdd = StudentManager.getNext();
            if (studentToAdd != null) {
                //affecter les valeurs de l etudiant dans la vue
                tvNumero.setText("" + studentToAdd.getNumber());
                tvFirstName.setText(studentToAdd.getFirstName());
                tvLastName.setText(studentToAdd.getLastName());
                //ajoute la vue au liniear layout qui contient la liste de etudiant.
                llListStudent.addView(llStudent);
            }
        });
    }
}