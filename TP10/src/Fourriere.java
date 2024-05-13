import java.util.ArrayList;
import java.util.HashMap;

public class Fourriere {
    private static final int TYPE_VEHICULE_INDEX = 0;
    private static final int IMMATRICULATION_INDEX = 1;
    private static final int MARQUE_INDEX = 2;
    private static final int MODELE_INDEX = 3;
    private static final int ETAT_INDEX = 4;
    private static final int CYLINDREE_NBPORTES_INDEX = 5;

    private static ArrayList<Vehicule> vehicules = new ArrayList<>();
    private static HashMap<String, ArrayList<Vehicule>> vehiculesByState = new HashMap<>();

    private static void afficherParTypeVehicule() {
        System.out.println("______________ Affichage par type ______________");
        for (Class t : new Class[]{Voiture.class, Moto.class}) {
            for (Vehicule v : vehicules) {
                if (v.getClass().equals(t)) {
                    System.out.println(v);
                }
            }
            System.out.println("------------");
        }
    }

    private static void afficherParEtat() {
        System.out.println("______________ Affichage par état ______________");
        for (String type : vehiculesByState.keySet()) {
            System.out.println("--- " + type + " ---");
            for (Vehicule v : vehiculesByState.get(type)) {
                System.out.println(v);
            }
        }
    }

    private static void insertionHashMap(Vehicule v, String etat) {
        if (!vehiculesByState.containsKey(etat)) {
            vehiculesByState.put(etat, new ArrayList<>());
        }
        vehiculesByState.get(etat).add(v);
    }

    private static void liberationVehicule() {
        for (String s : new String[]{"Casse", "Abandon"}) {
            for (Vehicule vehicule : vehiculesByState.get(s)) {
                vehicules.remove(vehicule);
            }
            vehiculesByState.remove(s);
        }
    }

    private static void chargerDonnees(String path) {
        for (String s : FileToStr.lireCsv(path)) {
            String[] data = s.split(";");
            switch (data[TYPE_VEHICULE_INDEX]) {
                case "Voiture":
                    vehicules.add(new Voiture(data[IMMATRICULATION_INDEX], data[MARQUE_INDEX], data[MODELE_INDEX], data[ETAT_INDEX], Integer.parseInt(data[CYLINDREE_NBPORTES_INDEX])));
                    insertionHashMap(vehicules.getLast(), data[ETAT_INDEX]);
                    break;
                case "Moto":
                    vehicules.add(new Moto(data[IMMATRICULATION_INDEX], data[MARQUE_INDEX], data[MODELE_INDEX], data[ETAT_INDEX], Integer.parseInt(data[CYLINDREE_NBPORTES_INDEX])));
                    insertionHashMap(vehicules.getLast(), data[ETAT_INDEX]);
                    break;
                default:
                    System.out.println("Type de véhicule inconnu");
            }
        }
    }

    public static void main(String[] args) {
        String localDir = System.getProperty("user.dir");
        if (System.getProperty("os.name").contains("Windows")) {
            chargerDonnees(localDir + "\\vehicules.csv");
        } else {
            chargerDonnees(localDir + "/vehicules.csv");
        }
        afficherParTypeVehicule();
        afficherParEtat();
        liberationVehicule();
        System.out.println();
        afficherParTypeVehicule();
        afficherParEtat();
    }
}
