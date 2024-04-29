package Question2;

import java.util.ArrayList;
import java.util.HashMap;

public class Equipe {
    private String nomClub;
    private HashMap<Integer, JoueurBasket> joueurs;

    public Equipe(String nomClub, HashMap<Integer, JoueurBasket> joueurs) {
        this.nomClub = nomClub;
        this.joueurs = joueurs;
    }

    public String getNomClub() {
        return nomClub;
    }

    public int getScoreEquipe() {
        int score = 0;
        for (JoueurBasket joueur : joueurs.values()) {
            score += joueur.getNbPointsMatch();
        }
        return score;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Équipe ");
        sb.append(getNomClub()).append(" :\n");
        for (Integer numeroJoueur : joueurs.keySet()) {
            sb.append("Numéro ").append(numeroJoueur).append(" : ").append(joueurs.get(numeroJoueur)).append("\n");
        }
        return sb.toString();
    }
}
