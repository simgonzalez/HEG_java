package Question2;

/**
 * Classe à modifier...
 */
public class Boxeur extends Combattant {
    private int nbKo;

    public Boxeur(String nom, String prenom, int anneeExperience, String nationalite, int poids, int nbVictoires, int nbDefaite, int nbKo) {
        super(nom, prenom, anneeExperience, nationalite, poids, nbVictoires, nbDefaite);
        this.nbKo = nbKo;

        defineCat();
    }

    /**
     * Définit la catégorie du boxeur en fonction de son poids
     */
    private void defineCat() {
        if (getPoids() >90) {
            setCategorie("lourd");
        } else if (getPoids() < 60) {
            setCategorie("léger");
        } else {
            setCategorie("moyen");
        }
    }
}
