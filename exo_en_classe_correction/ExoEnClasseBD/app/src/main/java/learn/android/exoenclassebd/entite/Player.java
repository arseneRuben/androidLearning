package learn.android.exoenclassebd.entite;
import android.database.Cursor;

import androidx.annotation.NonNull;
public class Player {
    private int id;
    private int number;
    private String firstName;
    private String lastName;
    private Position position;
    public Player() {
    }
    public Player(Cursor cursor) {
        this.id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
        this.number = cursor.getInt(cursor.getColumnIndexOrThrow("number"));
        this.firstName = cursor.getString(cursor.getColumnIndexOrThrow("first_name"));
        this.lastName = cursor.getString(cursor.getColumnIndexOrThrow("last_name"));
        int value = cursor.getInt(cursor.getColumnIndexOrThrow("position"));
        position = getPositionFormValue(value);
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    @NonNull
    @Override
    public String toString() {
        return firstName + ", " + lastName;
    }
    public static int getValueFormPosition(Position position) {
        int value = -1;
        switch (position) {
            case defender:
                value = 0;
                break;
            case striker:
                value = 1;
                break;
            case middle:
                value = 2;
                break;
            case goal_defender:
                value = 3;
                break;
        }
        return value;
    }
    public static Position getPositionFormValue(int value) {
        Position position = Position.middle;
        switch (value) {
            case 0:
                position = Position.defender;
                break;
            case 1:
                position = Position.striker;
                break;
            case 2:
                position = Position.middle;
                break;
            case 3:
                position = Position.goal_defender;
                break;
        }
        return position;
    }
}
