package produits;

import java.util.Objects;

public abstract class Boisson {
    private String nom;
    private double prix;
    private int taille;

    public Boisson(String nom, double prix, int taille) {
        this.nom = nom;
        this.prix = prix;
        this.taille = taille;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public int getTaille() {
        return taille;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public abstract String allergie();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Boisson boisson)) return false;
        return Double.compare(prix, boisson.prix) == 0 && taille == boisson.taille && Objects.equals(nom, boisson.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prix, taille);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + '(' + getPrix() + "CHF) - "+ getTaille();
    }
}
