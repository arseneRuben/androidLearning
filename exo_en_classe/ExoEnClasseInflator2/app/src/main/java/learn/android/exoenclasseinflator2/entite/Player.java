package learn.android.exoenclasseinflator2.entite;
import androidx.annotation.NonNull;
public class Player {
    private int number;
    private String firstName;
    private String lastName;
    private Position position;
    Player() {
    }
    public Player(int number, String firstName, String lastName, Position position) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
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
}
