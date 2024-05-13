public class Moto extends Vehicule {
    private int cylindree;

    public Moto(String immatriculation, String marque, String modele, String etat, int cylindree) {
        super(immatriculation, marque, modele, etat);
        this.cylindree = cylindree;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + cylindree + "cc : " + super.toString();
    }
}
