package learn.android.exoclasselistview.entitie;
import android.database.Cursor;
public class Voiture {
    private int id;
    private String nom;
    private String image;
    public Voiture() {
    }
    public Voiture(int id, String nom, String image) {
        this.id = id;
        this.nom = nom;
        this.image = image;
    }
    public Voiture(Cursor cursor) {
        this.id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
        this.nom = cursor.getString(cursor.getColumnIndexOrThrow("nom"));
        this.image = cursor.getString(cursor.getColumnIndexOrThrow("image"));
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}
