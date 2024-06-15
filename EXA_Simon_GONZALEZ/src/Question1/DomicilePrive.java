package Question1;

public class DomicilePrive implements Alarmable {
    private String adresse;
    private Personne proprietaire;

    public DomicilePrive(String adresse, Personne proprietaire) {
        this.adresse = adresse;
        this.proprietaire = proprietaire;
    }

    @Override
    public String infosContact() {
        return "Le propriétaire de ce domicile à l'adresse " + this.adresse + " est contactable au numéro suivant : " +  proprietaire.getTelephonePrive();
    }

    @Override
    public void lancerAlarme() throws NoContactException {
        String contactInfo = proprietaire.getTelephonePrive();
        if (contactInfo == null || contactInfo.isEmpty()) {
            throw new NoContactException("Erreur : L'alarme pour Domicile privé n'a pas pu être lancée, " + proprietaire + " n'est pas joignable");
        }
    }
}
