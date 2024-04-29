package Question2;

public abstract class Sportif {
    private String nom;
    private String prenom;
    private int anneeExperience;
    private String nationalite;

    public Sportif(String nom, String prenom, int anneeExperience, String nationalite) {
        this.nom = nom;
        this.prenom = prenom;
        this.anneeExperience = anneeExperience;
        this.nationalite = nationalite;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAnneeExperience() {
        return anneeExperience;
    }
}
