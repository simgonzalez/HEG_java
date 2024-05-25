import java.util.ArrayList;

public class GestionPersonnages {
    private static ArrayList<Personnage> personnages = new ArrayList<Personnage>();

    public static void main(String[] args) {
        //charger les personnages
        System.out.println("\n\n------Chargement des personnages------");
        chargerPersonnages(FileToStr.lireCsv("personnages.csv"));


        //afficher les personnages
        System.out.println("\n\n------Affichage des personnages------");
        afficherPersonnages();

        //Creer un combat aléatoire
        System.out.println("\n\n------Lancement d'un combat aléatoire------");
        creerCombatAleatoire();
    }

    private static void creerCombatAleatoire() {
        int index1 = (int) (Math.random() * personnages.size());
        int index2 = (int) (Math.random() * personnages.size());
        while (index1 == index2) {
            index2 = (int) (Math.random() * personnages.size());
        }
        CombatPersonnage combatPersonnage = new CombatPersonnage(personnages.get(index1), personnages.get(index2));
        combatPersonnage.combat();
        System.out.println(combatPersonnage);
    }

    private static void afficherPersonnages() {
        for (Personnage personnage : personnages) {
            System.out.println(personnage);
        }
    }

    private static void chargerPersonnages(String[] strings) {
        for (String string : strings) {
            String[] data = string.split(";");
            try {
                personnages.add(PersonnageFactory.createPersonnage(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]), Integer.parseInt(data[7])));
            } catch (UnexpectedCharacterTypeException e) {
                System.out.println("Le persoonage" + data[1] + " n'est pas reconnu");
            }
        }
    }
}
