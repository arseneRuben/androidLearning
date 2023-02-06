package learn.android.exoclasseinflator.manager;
import android.opengl.ETC1Util;

import java.util.ArrayList;

import learn.android.exoclasseinflator.entite.Student;
public class StudentManager {
    private static ArrayList<Student> students;
    private static int id;
    private static void init() {
        id = 0;
        students = new ArrayList<>();
        students.add(new Student(1, "samy", "nom de famille"));
        students.add(new Student(2, "montassar", "nom de famille"));
        students.add(new Student(3, "jean", "nom de famille"));
        students.add(new Student(4, "arsene", "nom de famille"));
        students.add(new Student(5, "lucien", "nom de famille"));
    }
    public static Student getNext() {
        Student retour = null;
        if (students == null)
            init();
        if (id < students.size()) {
            retour = students.get(id);
            id++;
        }
        return retour;
    }
}
