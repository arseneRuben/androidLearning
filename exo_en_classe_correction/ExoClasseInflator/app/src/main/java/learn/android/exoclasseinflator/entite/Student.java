package learn.android.exoclasseinflator.entite;
import android.speech.SpeechRecognizer;

import androidx.annotation.NonNull;
public class Student {
    private int number;
    private String firstName;
    private String lastName;
    public Student() {
    }
    public Student(int number, String firstName, String lastName) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @NonNull
    @Override
    public String toString() {
        return lastName + " " + firstName;
    }
}
