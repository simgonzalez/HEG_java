package Question1;

/**
 * Classe Personne : NE PAS MODIFIER !!!
 */
public class Personne {
    private int id;
    private String nom;
    private String telephonePrive;
    private String telephoneProfessionnel;
    private String email;

    public Personne(int id, String nom, String telephonePrive, String telephoneProfessionnel, String email) {
        this.id = id;
        this.nom = nom;
        this.telephonePrive = telephonePrive;
        this.telephoneProfessionnel = telephoneProfessionnel;
        this.email = email;
    }

    public Personne(int id) {
        this.id = id;
    }

    public String getTelephonePrive() {
        return telephonePrive;
    }

    public String getTelephoneProfessionnel() {
        return telephoneProfessionnel;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        Personne personne = (Personne) o;
        return id == personne.id;
    }

    @Override
    public String toString() {
        return "La personne (" + nom + ")";
    }


}
