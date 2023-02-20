package learn.android.demospinneradapter;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import learn.android.demospinneradapter.adapter.StudentAdapter;
import learn.android.demospinneradapter.entite.Student;
import learn.android.demospinneradapter.manager.StudentManager;
public class MainActivity extends AppCompatActivity {
   Spinner listeFruitSpinner;
   ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listeFruitSpinner = findViewById(R.id.spinner_main);
        listView = findViewById(R.id.lv_main);
        List<String> dataFruits = new ArrayList<>();
        dataFruits.add("pomme");
        dataFruits.add("poire");
        dataFruits.add("peche");
        dataFruits.add("abricot");
        dataFruits.add("banane");
        dataFruits.add("tomate");
        ArrayAdapter<String> listFruitAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataFruits);

        listeFruitSpinner.setAdapter(listFruitAdapter);
        StudentAdapter studentAdapter = new StudentAdapter(this, R.layout.student_layout, StudentManager.getStudents());

        listView.setAdapter(studentAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student studentClick = (Student) parent.getItemAtPosition(position);
                view.setBackgroundColor(Color.YELLOW);
                Toast.makeText(MainActivity.this, studentClick.toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}