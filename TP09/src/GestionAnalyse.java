
import java.util.ArrayList;

public class GestionAnalyse {
    private static final int IDX_ID_ANALYSE = 0;
    private static final int IDX_TYPE_ANALYSE = 1;
    private static final int IDX_RESULTAT = 2;
    private static final int IDX_AGE = 3;
    private static final int IDX_ID_PATIENT = 4;

    private static ArrayList<Analyse> analyses = new ArrayList<Analyse>();

    /**
     * Id de l’analyse, Type, Résultat, Age, ID du patient
     * Une gestion d’erreur doit être faite si le type n’est pas compris entre « PLA, VHA et TOX ».
     * Un fichier comportant une erreur ne doit pas continuer d’être utilisé après. Pour mettre en
     * place la gestion d’erreur, vous pouvez créer de nouvelles classes et modifier la méthode
     * main fournie.
     *
     * @param fichier
     */
    public static void chargerAnalyses(ArrayList<String[]> fichier) {
        boolean isErrorDetected = false;
        for (String[] s : fichier) {
            try {
                switch (s[IDX_TYPE_ANALYSE]) {
                    case "PLA":
                        analyses.add(new AnalyseSanguine(Integer.parseInt(s[IDX_ID_ANALYSE]), Integer.parseInt(s[IDX_ID_PATIENT]), Integer.parseInt(s[IDX_AGE]), s[IDX_TYPE_ANALYSE], Integer.parseInt(s[IDX_RESULTAT])));
                        break;
                    case "VHA":
                    case "TOX":
                        analyses.add(new AnalyseVirale(Integer.parseInt(s[IDX_ID_ANALYSE]), Integer.parseInt(s[IDX_ID_PATIENT]), Integer.parseInt(s[IDX_AGE]), s[IDX_TYPE_ANALYSE], s[IDX_RESULTAT]));
                        break;
                    default:
                        throw new Exception("Erreur de type à la ligne " + s[IDX_ID_ANALYSE] + ". Le type " + s[IDX_TYPE_ANALYSE] + " est un type inconnu! La suite du fichier est ignorée.");
                }
            } catch (Exception e) {
                System.out.println("Erreur lors de la création de l'analyse : " + e.getMessage());
                isErrorDetected = true;
                break;
            }
        }
        if (!isErrorDetected) {
            System.out.println("Aucune erreur détectée");
        }
    }

    public static void afficherAnalyses() {
        for (Analyse a : analyses) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {

        System.out.println("----- Chargement du fichier : LstAnalyses.csv -----");
        chargerAnalyses(FileToStr.lireFichier("LstAnalyses.csv"));
        System.out.println("----- Chargement du fichier : LstAnalyses2.csv  -----");
        chargerAnalyses(FileToStr.lireFichier("LstAnalyses2.csv"));

        System.out.println("");
        afficherAnalyses();
    }
}

