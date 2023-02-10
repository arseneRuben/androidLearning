package com.example.labviewperso.entities;
public class Planete {
    public enum PlaneteType {
        Tellurique, Jeovienne
    }
    private int id;
    private String nom;
    private String description;
    private String nomImage;
    private PlaneteType type;
    public Planete() {
    }
    public Planete(int id, String nom, String description, String nomImage, PlaneteType type) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.nomImage = nomImage;
        this.type = type;
    }
    public PlaneteType getType() {
        return type;
    }
    public void setType(PlaneteType type) {
        this.type = type;
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getNomImage() {
        return nomImage;
    }
    public void setNomImage(String nomImage) {
        this.nomImage = nomImage;
    }
}
