package Question2;

public class Employe {
    private String nom;
    private String prenom;
    private String poste;

    public Employe(String nom, String prenom, String poste) {
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
    }

    @Override
    public String toString() {
        return prenom + " " + nom + ", " + poste + ".";
    }
}
