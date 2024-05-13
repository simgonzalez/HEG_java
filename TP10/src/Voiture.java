public class Voiture extends Vehicule {
    private int nbPortes;

    public Voiture(String immatriculation, String marque, String modele, String etat, int nbPortes) {
        super(immatriculation, marque, modele, etat);
        this.nbPortes = nbPortes;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + nbPortes + " portes : " + super.toString();
    }
}
