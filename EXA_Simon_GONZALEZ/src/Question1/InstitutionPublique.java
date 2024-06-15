package Question1;

public class InstitutionPublique implements Alarmable {
    private String nomInstitution;
    private String adresseInstitution;
    private Personne administrateur;

    public InstitutionPublique(String nomInstitution, String adresseInstitution, Personne administrateur) {
        this.nomInstitution = nomInstitution;
        this.adresseInstitution = adresseInstitution;
        this.administrateur = administrateur;
    }

    @Override
    public String infosContact() {
        return this.nomInstitution + " est contactable à l'adresse mail suivante : " + this.administrateur.getEmail();
    }

    @Override
    public void lancerAlarme() throws NoContactException {
        String contactInfo = administrateur.getEmail();
        if (contactInfo == null || contactInfo.isEmpty()) {
            throw new NoContactException("Erreur : L'alarme pour " + this.nomInstitution + " n'a pas pu être lancée, " + administrateur + " n'est pas joignable");
        }
    }
}
