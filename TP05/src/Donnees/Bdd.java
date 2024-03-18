package Donnees;


/**
 * Classe qui simule une base de données : NE PAS MODIFIER
 */
public class Bdd {

    private static int nbResultats = (int)(10L + Math.round(15.0 * Math.random()));

    private Bdd() {
    }

    public static int[] recupererLesDossards() {
        int[] dossards = new int[nbResultats];

        for(int i = 0; i < dossards.length; ++i) {
            dossards[i] = (int)(100L + Math.round(20.0 * Math.random()));
        }

        return dossards;
    }

    public static double[] recupererLesTemps() {
        double[] temps = new double[nbResultats];

        for(int i = 0; i < temps.length; ++i) {
            temps[i] = (double)Math.round(400.0 + 300.0 * Math.random()) / 10.0;
        }

        return temps;
    }
}
