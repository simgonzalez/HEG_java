package Question2;

public abstract class Combattant extends Sportif {
    private int poids;
    private int nbVictoires;
    private int nbDefaite;
    private String categorie;

    public Combattant(String nom, String prenom, int anneeExperience, String nationalite, int poids, int nbVictoires, int nbDefaite) {
        super(nom, prenom, anneeExperience, nationalite);
        this.poids = poids;
        this.nbVictoires = nbVictoires;
        this.nbDefaite = nbDefaite;
    }

    public int getNbVictoires() {
        return nbVictoires;
    }

    public String getCategorie() {
        return categorie;
    }

    public int getPoids() {
        return poids;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return getNom() + " " + getPrenom() + " (" + getCategorie() + ")";
    }
}
