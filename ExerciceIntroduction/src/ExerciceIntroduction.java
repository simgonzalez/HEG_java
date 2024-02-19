public class ExerciceIntroduction {

    /**
     * Exercice 1: variables et conversions
     * - Déclarer une variable entière, une variable double, et une variable caractère (String).
     * - Afficher les valeurs de ces variables.
     * - Réaliser et afficher la conversion d'une variable entière en double.
     * - Réaliser et afficher la conversion d'une variable double en entière.
     * - Additionner les trois variables et afficher le résultat.
     */
    public static void testerVariablesEtConversions() {
        int myNo = 5;
        double myDouble = 10.2;
        String myStr = "test";

        System.out.println(String.valueOf(myNo) + ' ' + myDouble + ' ' + myStr);
        System.out.println((double) myNo);
        System.out.println((int) myDouble);
        System.out.println(myNo + myDouble + myStr);
    }

    /**
     * Exercice 2: Conditions
     * - Utilisez la fonction suivante qui prend un entier en paramètre.
     * - Utiliser une structure conditionnelle pour tester si l'entier est positif, négatif ou zéro.
     * - retourner "positif", "négatif", ou "zéro" selon le cas.
     */
    public static String testerLesConditions(int nombre) {
        String result;
        if (nombre < 0) {
            result = "négatif";
        } else if (nombre > 0) {
            result = "positif";
        } else {
            result = "zéro";
        }
        return result;
    }

    /**
     * Exercice 3: Boucles
     * - Utiliser une boucle for pour afficher les nombres de 1 à 5.
     * - Utiliser une boucle while pour réaliser un décompte à partir de 5 jusqu'à 1.
     */
    public static void testerLesBoucles() {
        System.out.println("----Compte----");
        for (int i = 1; i < 6; i++) {
            System.out.println(i);
        }

        System.out.println("----Décompte----");
        int countdown = 5;
        while (countdown > 0) {
            System.out.println(countdown);
            countdown--;
        }
    }

    /**
     * Exercice 4: Manipuler les tableaux
     * - Déclarer et initialiser un tableau d'entiers avec des valeurs.
     * - Utiliser une boucle pour afficher tous les éléments du tableau.
     * - Calculer et afficher la somme des éléments du tableau.
     */
    public static void testerLesTableaux() {
        int[] intArray = {6, 20, 5, 12, 9};
        int sum = 0;

        System.out.println("---éléments du tableau---");
        for (int elem : intArray) {
            System.out.println(elem);
            sum += elem;
        }
        System.out.println("---Somme---\n" + sum);
    }
}
