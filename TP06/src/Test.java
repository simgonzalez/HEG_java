import java.text.DateFormatSymbols;
import java.util.*;

public class Test {
    // Variable "livres" permettant de stocker les livres
    private static ArrayList<Livre> livres = new ArrayList<>();
    //Vos autres variables ici...
    private static HashMap<String, HashSet> planning = new HashMap<>();
    private final static int PLANNING_SIZE_PER_DAY = 2;

    /**
     * Charger les données des livres à partir d'un fichier csv : NE PAS MODIFIER
     * @param path
     */
    public static void chargerData(String path){
        String[] textRecette = FileToStr.lireCsv(path);
        String[] ligne = textRecette[0].split(",");
        Livre l = new Livre(ligne[0],ligne[1], Integer.parseInt(ligne[2]));
        for(int i = 1; i < textRecette.length; i++){
            ligne = textRecette[i].split(",");
            l.ajoutRecette(new Recette(ligne[0],Integer.parseInt(ligne[1]),Integer.parseInt(ligne[2]),Integer.parseInt(ligne[3])));
        }
        livres.add(l);
    }

    public static void main(String[] args){
        String localDir = System.getProperty("user.dir");
        chargerData(localDir + "/src/Ressources/livre1.csv");
        chargerData(localDir + "/src/Ressources/livre2.csv");

        // Methodes à developper
        afficherLivres();
        genererPlanning();
        afficherPlanning();
        System.out.println("");
        rechercheRecette(new Recette("Jaret de porc",10,2,60));
        rechercheRecette(new Recette("Jaret de boeuf",10,2,60));
        rechercheRecettePlanning(new Recette("Jaret de porc",10,2,60));

    }

    private static void rechercheRecettePlanning(Recette recette) {
        System.out.println("Recherche de la recette dans le planning : " + recette.toString());
        for (Map.Entry<String, HashSet> entry : planning.entrySet()) {
            if (entry.getValue().contains(recette)) {
                System.out.println("Cette recette est prévue pour : " + entry.getKey());
                return;
            }
        }
        System.out.println("Le planning ne contient pas cette recette.");
    }

    private static void rechercheRecette(Recette recette) {
        System.out.println("Recherche de la recette : " + recette);
        for (Livre l : livres) {
            if (l.getRecettes().contains(recette)) {
                System.out.println("Le livre " + l.getTitre() + " contient cette recette");
                return;
            }
        }
        System.out.println("Aucun livre ne contient cette recette.");
    }

    private static void afficherPlanning() {
        for (Map.Entry<String, HashSet> entry : planning.entrySet()) {
            System.out.print(entry.getKey() + " : ");
            for (Object r : entry.getValue()) {
                System.out.println("    " + r.toString());
            }
        }
    }

    private static void genererPlanning() {
        String[] weekDays = new DateFormatSymbols().getWeekdays();
        for (int d = 1; d < weekDays.length; d++) {
            HashSet<Recette> recettesPlanning = new HashSet<>();
            while (recettesPlanning.size() < PLANNING_SIZE_PER_DAY) {
                recettesPlanning.add(livres.get(new Random().nextInt(livres.size())).getRecettes().get(new Random().nextInt(livres.get(0).getRecettes().size())));
            }
            planning.put(weekDays[d], recettesPlanning);
        }
    }

    private static void afficherLivres() {
        for (Livre l : livres) {
            System.out.println(l.toString() + '\n');
        }
    }
}
