public class Personne {
    private String nom;
    private Ecole ecole;

    public Personne (String nom, Ecole ecole) {
        this.nom = nom;
        this.ecole = ecole;
    }

    public Ecole getEcole() {
        return ecole;
    }

    public void afficheEcole() {
        System.out.println(this.ecole.toString());
    }


    @Override
    public String toString() {
        String ecoleAffichage = "";
        if (ecole.getType().equals(Ecole.EcoleType.PUBLIC)) {
            if (ecole.getDegree().equals(Ecole.EcoleDegree.UNI)) {
                ecoleAffichage += "étudiant au niveau tertiaire" + System.lineSeparator();
            }
            ecoleAffichage += this.ecole.toString();
        } else {
            ecoleAffichage += String.format("Ecole privée %s", this.ecole.getName());
        }
        return "étudiant " + this.nom + System.lineSeparator() + ecoleAffichage;
    }
}
