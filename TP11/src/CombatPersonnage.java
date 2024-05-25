import java.util.ArrayList;

public class CombatPersonnage {
    private Personnage perso1;
    private Personnage perso2;
    private StringBuilder actions = new StringBuilder();

    public CombatPersonnage(Personnage perso1, Personnage perso2) {
        this.perso1 = perso1;
        this.perso2 = perso2;
        actions.append("Combat entre les deux personnages suivants:\n");
        actions.append(perso1).append("\nVS\n").append(perso2).append("\n\n");
    }

    public void combat() {
        int noTour = 1;
        while ((this.perso1.getPv() > 0 && this.perso2.getPv() > 0) && noTour < 10) {
            this.combattre();
            noTour += 1;
        }
        actions.append("\nFin du combat\n");
        this.defineGagnant();
    }

    private void combattre() {
        // Celui avec le plus petit niveau commence le tour
        if (this.perso1.getNiveau() < this.perso2.getNiveau()) {
            this.combatAction(perso1, perso2);
            this.combatAction(perso2, perso1);
        } else {
            this.combatAction(perso2, perso1);
            this.combatAction(perso1, perso2);
        }
    }

    private void combatAction(Personnage persoAction, Personnage adversaire) {
        int action = (int) (Math.random() * 3) + 1;
        switch (action) {
            case 1:
                this.actions.append(persoAction.getNom()).append(" attaque ").append(adversaire.getNom()).append("\n");
                persoAction.attaquer(adversaire);
                break;
            case 2:
                this.actions.append(persoAction.getNom()).append(" utilise sa compétence spéciale\n");
                persoAction.special();
                break;
            case 3:
                this.actions.append(persoAction.getNom()).append(" se défend\n");
                persoAction.defendre();
                break;
        }
    }

    private void defineGagnant() {
        if (this.perso1.getPv() >= 0) {
            actions.append(perso1.getNom()).append(" a gagné le combat\n");
        } else if (this.perso2.getPv() >= 0) {
            actions.append(perso2.getNom()).append(" a gagné le combat\n");
        } else {
            actions.append("Match nul\n");
        }
    }

    @Override
    public String toString() {
        return actions.toString();
    }
}
