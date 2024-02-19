import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Exercice: Gestion des Notes d'Étudiants
 * Objectif: Créer une fonction qui prend en entrée un tableau de notes d'étudiants (valeurs entières entre 0 et 20),
 * calcule et affiche la moyenne, le nombre de notes supérieures à la moyenne, et classe les étudiants en
 * deux catégories basées sur cette moyenne: ceux qui ont besoin de soutien et ceux qui sont au-dessus de la moyenne.
 * <p>
 * Énoncé:
 * - Déclarer et initialiser un tableau d'entiers avec des valeurs représentant des notes d'étudiants.
 * - Calculer la moyenne des notes.
 * - Convertir la moyenne en un entier pour simplifier la comparaison (facultatif).
 * - Parcourir le tableau pour compter combien d'étudiants ont une note supérieure à la moyenne.
 * - Afficher la moyenne, le nombre d'étudiants ayant des notes supérieures à la moyenne.
 * - Utiliser des conditions pour classer les étudiants et afficher un message pour chaque catégorie.
 */
public class ExerciceAvance {


    public static String getStudentClassif(double average, double noteEleve) {
        if (noteEleve > average + 2) {
            return "tres bien";
        } else if (noteEleve >= average) {
            return "bien";
        } else {
            return "pas bien";
        }
    }

    public static void gererNotesEtudiants(int[] notesEleves) {
        int sum = Arrays.stream(notesEleves).parallel().reduce(0, Integer::sum);
        int avg = sum / notesEleves.length;
        int countInferiorAvg = 0;
        HashMap<String, Integer> noStudentByCat = new HashMap<String, Integer>();
        String currentCat;

        for (int val : notesEleves) {
            currentCat = getStudentClassif(avg, val);
            if (noStudentByCat.get(currentCat) == null) {
                noStudentByCat.put(currentCat, 1);
            } else {
                noStudentByCat.put(currentCat, noStudentByCat.get(currentCat) + 1);
            }

            if (val < avg) {
                countInferiorAvg++;
            }
        }
        System.out.println("eleves supérieurs à la moyernne : " + (notesEleves.length - countInferiorAvg));
        System.out.println("eleves inférieur à la moyernne : " + countInferiorAvg);
        System.out.println("Moyenne : " + avg);

        noStudentByCat.forEach((key, value) -> {
            System.out.println("--- cat " + key + " ---");
            System.out.println("no eleves : " + value);
        });
    }


    //Pour tester votre fonction, vous pouvez utiliser le code suivant dans la méthode main:
    public static void main(String[] args) {
        int[] studentsNotes = new int[]{10, 15, 14, 20};
        gererNotesEtudiants(studentsNotes);
    }
}
