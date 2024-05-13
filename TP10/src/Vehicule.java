import java.util.Objects;

public class Vehicule {
    private String immatriculation;
    private String marque;
    private String modele;
    private String etat;

    public Vehicule(String immatriculation, String marque, String modele, String etat) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.modele = modele;
        this.etat = etat;
    }

    @Override
    public String toString() {
        return marque + " " + modele + " immatriculée : " + immatriculation;
    }
}
