package Question1;

import java.util.ArrayList;

/**
 * Classe principale de l'application
 */
public class GestionAlarme {
    // Index static pour personnes
    private static final int PERS_IDX_ID = 0;
    private static final int PERS_IDX_NOM = 1;
    private static final int PERS_IDX_TEL_PRIVE = 2;
    private static final int PERS_IDX_TEL_PRO = 3;
    private static final int PERS_IDX_EMAIL = 4;

    // index static pour alarmables
    private static final int ALARM_IDX_TYPE = 0;
    private static final int ALARM_IDX_PERSONNE_ID = 1;

    // Chemin des fichiers
    private static final String FILE_PERSONNE = "src/Question1/personnes.csv";
    private static final String FILE_ALARMABLE = "src/Question1/donneesAlarmables.csv";

    //Attributs
    private static ArrayList<Personne> personnes = chargerPersonnes();
    private static ArrayList<Alarmable> alarmables = chargerAlarmables();

    public static void main(String[] args) {
        System.out.println("Liste des lieux possédant une alarme :");
        afficherInfoContact();

        System.out.println("\nTest des alarmes :");
        testerAlarme();
    }


    /**
     * Charge les personnes à partir du fichier csv fourni dans le projet
     * @return Liste de personnes
     */
    public static ArrayList<Personne> chargerPersonnes() {
        ArrayList<Personne> personnesList = new ArrayList<>();
        String[] personnes = FileToStr.lireCsv(FILE_PERSONNE);
        for (String personne : personnes) {
            String[] infos = personne.split(";");
            // Teste les valeurs du fichiers csv ajoute null à la personne si la valeur n'est pas présente ou vide
            personnesList.add(new Personne(
                    Integer.parseInt(infos[PERS_IDX_ID]),
                    infos[PERS_IDX_NOM],
                    infos.length < PERS_IDX_TEL_PRIVE + 1 ? null : infos[PERS_IDX_TEL_PRIVE].isEmpty() ? null : infos[PERS_IDX_TEL_PRIVE],
                    infos.length < PERS_IDX_TEL_PRO + 1 ? null : infos[PERS_IDX_TEL_PRO].isEmpty() ? null : infos[PERS_IDX_TEL_PRO],
                    infos.length < PERS_IDX_EMAIL + 1 ? null : infos[PERS_IDX_EMAIL]
            ));
        }
        return personnesList;
    }

    /**
     * Charge les alarmables à partir du fichier csv fourni dans le projet
     * @return Liste d'alarmables
     */
    public static ArrayList<Alarmable> chargerAlarmables() {
        ArrayList<Alarmable> alarmablesList = new ArrayList<>();
        String[] alarmables = FileToStr.lireCsv(FILE_ALARMABLE);
        for (String alarmable : alarmables) {
            String[] infos = alarmable.split(";");
            switch (infos[ALARM_IDX_TYPE]) {
                case "D":
                    alarmablesList.add(new DomicilePrive(infos[2], findPersonneFromID(Integer.parseInt(infos[ALARM_IDX_PERSONNE_ID]))));
                    break;
                case "E":
                    alarmablesList.add(new Entreprise(infos[2], infos[3], Integer.parseInt(infos[4]), findPersonneFromID(Integer.parseInt(infos[ALARM_IDX_PERSONNE_ID]))));
                    break;
                case "I":
                    alarmablesList.add(new InstitutionPublique(infos[2], infos[3], findPersonneFromID(Integer.parseInt(infos[ALARM_IDX_PERSONNE_ID]))));
                    break;
                default:
                    System.out.println("Type d'alarmable inconnu");
                    break;
            }
        }
        return alarmablesList;
    }

    /**
     * Affiche les informations de contact de chaque alarmable
     */
    private static void afficherInfoContact() {
        for (Alarmable alarmable : alarmables) {
            System.out.println(alarmable.infosContact());
        }
    }

    /**
     * Test les alarmes pour chaque entité alarmable
     */
    private static void testerAlarme() {
        for (Alarmable alarmable : alarmables) {
            try {
                alarmable.lancerAlarme();
            } catch (NoContactException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Retourne une personne à partir de son ID
     *
     * @param i ID de la personne
     * @return Personne
     */
    private static Personne findPersonneFromID(int i) {
        for (Personne personne : personnes) {
            if (personne.equals(new Personne(i))) {
                return personne;
            }
        }
        return null;
    }

}
