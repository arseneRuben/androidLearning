package learn.android.exo_intent_exo1.entitie;
import java.util.UUID;
public class Personne {

    private String id;
    private String nom;
    private String prenom;
    private String profession;
    private int age;
    private int idImage;
    public Personne() {
    }
    public Personne(String nom, String prenom, String profession, int age, int idImage) {
        id = UUID.randomUUID().toString();
        this.nom = nom;
        this.prenom = prenom;
        this.profession = profession;
        this.age = age;
        this.idImage = idImage;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getProfession() {
        return profession;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getIdImage() {
        return idImage;
    }
    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }
}
