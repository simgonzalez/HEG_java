public class Vehicule {
    //variables de la classe Vehicule
    private String marque;
    private String modele;
    private int annee;
    private String plaqueImmatriculation;
    private int anneeRevision;

    public Vehicule(String marque, String modele, int annee, String plaqueImmatriculation, int anneeRevision) {
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.plaqueImmatriculation = plaqueImmatriculation;
        this.anneeRevision = anneeRevision;
    }

    public int getAnnee() {
        return annee;
    }

    public int getAnneeRevision() {
        return anneeRevision;
    }

    public void setAnneeRevision(int anneeRevision) {
        this.anneeRevision = anneeRevision;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " : " + this.marque + " " + this.modele + " de " + this.annee + " - " + this.plaqueImmatriculation + " année de révision : " + this.anneeRevision;
    }
}
