package Question2;

public class Karateka extends Combattant {
    private String ceinture;

    public Karateka(String nom, String prenom, int anneeExperience, String nationalite, int poids, int nbVictoires, int nbDefaite, String ceinture) {
        super(nom, prenom, anneeExperience, nationalite, poids, nbVictoires, nbDefaite);
        this.ceinture = ceinture;

        this.defineCat();
    }

    /**
     * définie la catégorie d'un karateka en fonction de son exéprience
     */
    private void defineCat() {
        if (getAnneeExperience() > 15) {
            setCategorie("expert");
        } else if (getAnneeExperience() < 5) {
            setCategorie("novice");
        } else {
            setCategorie("pro");
        }
    }
}
