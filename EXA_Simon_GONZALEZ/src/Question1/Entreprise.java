package Question1;

public class Entreprise implements Alarmable{
    private String nomEntreprise;
    private String adresseEntreprise;
    private int nbEmploye;
    private Personne responsableSecurite;

    public Entreprise(String nomEntreprise, String adresseEntreprise, int nbEmploye, Personne responsableSecurite) {
        this.nomEntreprise = nomEntreprise;
        this.adresseEntreprise = adresseEntreprise;
        this.nbEmploye = nbEmploye;
        this.responsableSecurite = responsableSecurite;
    }

    @Override
    public String infosContact() {
        return "L'entreprise " + nomEntreprise + " est contactable par le responsable securité au : " + responsableSecurite.getTelephoneProfessionnel();
    }

    @Override
    public void lancerAlarme() throws NoContactException {
        String contactInfo = responsableSecurite.getTelephoneProfessionnel();
        if (contactInfo == null || contactInfo.isEmpty()) {
            throw new NoContactException("Erreur : L'alarme pour " + this.nomEntreprise + "n'a pas pu être lancée, " + responsableSecurite + "n'est pas joignable");
        }
    }
}
