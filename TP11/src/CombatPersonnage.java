import java.util.ArrayList;

public class CombatPersonnage {
    private Personnage perso1;
    private Personnage perso2;
    private StringBuilder actions = new StringBuilder();

    public CombatPersonnage(Personnage perso1, Personnage perso2) {
        this.perso1 = perso1;
        this.perso2 = perso2;
        actions.append("Combat entre les deux personnaages suivants:\n");
        actions.append(perso1).append("\nVS\n").append(perso2).append("\n");
    }

    public void combat() {
        int noTour = 1;
        while ((this.perso1.getPv() > 0 && this.perso2.getPv() > 0) || noTour > 10) {
            this.combattre();
            noTour += 1;
        }
        actions.append("Fin du combat\n");
        this.defineGagnant();
    }

    private void combattre() {
        this.combatAction(perso1, perso2);
        this.combatAction(perso2, perso1);
    }

    private void combatAction(Personnage perso, Personnage adversaire) {
        int action = (int) (Math.random() * 3) + 1;
        switch (action) {
            case 1:
                this.actions.append(perso.getNom() + " attaque " + adversaire.getNom() + "\n");
                perso.attaquer(adversaire);
                break;
            case 2:
                this.actions.append(perso.getNom() + " utilise sa compétence spéciale\n");
                perso.special();
                break;
            case 3:
                this.actions.append(perso.getNom() + " se défend\n");
                perso.defendre();
                break;
        }
    }

    private void defineGagnant() {
        if (this.perso1.getPv() == 0) {
            actions.append(perso1.getNom() + " a gagné le combat\n");
        } else if (this.perso2.getPv() == 0) {
            actions.append(perso2.getNom() + " a gagné le combat\n");
        } else {
            actions.append("Match nul\n");
        }
    }

    @Override
    public String toString() {
        return actions.toString();
    }
}
