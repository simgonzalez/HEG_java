package Question2;

public class JoueurBasket extends Sportif {
    private int tailleCm;
    private int nbPointsMatch;

    public JoueurBasket(String nom, String prenom, int anneeExperience, String nationalite, int tailleCm, int nbPointsMatch) {
        super(nom, prenom, anneeExperience, nationalite);
        this.tailleCm = tailleCm;
        this.nbPointsMatch = nbPointsMatch;
    }

    public int getNbPointsMatch() {
        return nbPointsMatch;
    }

    @Override
    public String toString() {
        return getNom() + " " + getPrenom();
    }
}
