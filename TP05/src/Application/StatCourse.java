package Application;

import Domaine.Resultat;
import Donnees.Bdd;

import javax.sound.midi.Soundbank;
import javax.xml.transform.Result;
import java.util.ArrayList;

public class StatCourse {

    //La liste des résultats
    private static ArrayList<Resultat> resultats = new ArrayList<>();

    /**
     * Méthode principale qui lancera les autres afin d'afficher les statistiques de la course
     */
    public static void afficherStat(){
        resultats = chargerResultats();
        afficherResultats(resultats);
        plusRapide(resultats);

        //Example avec le dossard 116
        nbFois(116);
    }

    /**
     * Méthode qui affiche le nombre de fois où le dossard dossard est apparu
     * @param dossard
     */
    private static void nbFois(int dossard) {
        int nbFois = 0;
        for (Resultat r : resultats) {
            if (r.getNoDossard() == dossard) {
                nbFois++;
            }
        }
        System.out.println("\nLe skieur au dossard " + dossard + " a fait  " + nbFois + " fois la course");
    }

    private static void plusRapide(ArrayList<Resultat> resultats) {
        Resultat r = fastest(resultats);
        System.out.println("Le plus rapide est : Dossard " + r.getNoDossard() + " : " + r.getTemps());
    }

    private static Resultat fastest(ArrayList<Resultat> resultats) {
        // find the minimum time in the list
        Resultat fastetResultat = resultats.getFirst();
        for (Resultat r : resultats) {
            if (r.getTemps() < fastetResultat.getTemps()) {
                fastetResultat = r;
            }
        }
        return fastetResultat;
    }

    private static void afficherResultats(ArrayList<Resultat> resultats) {
        StringBuilder sb = new StringBuilder(resultats.size() + " résultats :\n");
        for (Resultat r: resultats) {
            sb.append(r + "\n");
        }
        System.out.println(sb);
    }


    private static ArrayList<Resultat> chargerResultats() {
        int[] dossards = Bdd.recupererLesDossards();
        double[] temps = Bdd.recupererLesTemps();
        if (dossards.length == temps.length) {
            for (int i = 0; i < dossards.length; i++) {
                resultats.add(new Resultat(dossards[i], temps[i]));
            }
        }
        return resultats;
    }


}
