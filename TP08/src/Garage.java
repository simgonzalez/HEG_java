import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Garage {

    // les variables de Garage permettant de gérer les vehicules à l'intérieur de celui-ci
    private ArrayList<Vehicule> vehicules = new ArrayList<>();
    private HashMap<Integer, ArrayList<Vehicule>> vehiculesByDate = new HashMap<>();

    public void main() {
        Moto m1 = new Moto("kawasaki", "z900", 2017, "BE0202022", 2019, 948);
        Moto m2 = new Moto("Suzuki", "SV650", 2014, "VS0203045", 2017, 650);
        Voiture v1 = new Voiture("Renault", "Clio", 2010, "GE1234567", 2012, 98);
        Voiture v2 = new Voiture("Porsche", "911", 2016, "GE0987654", 2017, 368);
        entreeVehicule(m1);
        entreeVehicule(m2);
        entreeVehicule(v1);
        entreeVehicule(v2);
        System.out.println();
        System.out.println("Affichage liste des vehicules : ");
        afficherVehicules();
        System.out.println();

        System.out.println("Affichage carnet : ");
        afficherCarnetVehicule();
        System.out.println();

        System.out.println("Email : ");
        envoiPromotion();
        System.out.println();

        System.out.println("Revision de tous les vehicules puis affichage !");
        reviserToutesLesVehicules();
        afficherVehicules();
        System.out.println();

        System.out.println("Affichage carnet (après révision): ");
        afficherCarnetVehicule();
        System.out.println();

        System.out.println("Email : ");
        envoiPromotion();
        System.out.println();

        System.out.println("Sortie de la suzuki, puis affichage");
        sortieVehicule(m2);
        afficherVehicules();
        System.out.println();

        System.out.println("Affichage carnet final: ");
        afficherCarnetVehicule();


    }

    private void populerVehiculesByDate() {
        vehiculesByDate = new HashMap<>();
        for (Vehicule v : vehicules) {
            if (!vehiculesByDate.containsKey(v.getAnneeRevision())) {
                vehiculesByDate.put(v.getAnneeRevision(), new ArrayList<>());
            }
            ArrayList<Vehicule> a = vehiculesByDate.get(v.getAnneeRevision());
            a.add(v);
            vehiculesByDate.put(v.getAnneeRevision(), a);
        }
    }

    private void envoiPromotion() {
        populerVehiculesByDate();
        boolean isVehiculeFound = false;
        for (int i : vehiculesByDate.keySet()) {
            if (i < 2018) {
                System.out.println("------" + i + "------");
                for (Vehicule v : vehiculesByDate.get(i)) {
                    System.out.println("promotion " + v);
                }
                isVehiculeFound = true;
            }
        }
        if (!isVehiculeFound) {
            System.out.println("Pas de promotion");
        }
    }

    private void afficherCarnetVehicule() {
        populerVehiculesByDate();
        for (int i : vehiculesByDate.keySet()) {
            System.out.println("------" + i + "------");
            for (Vehicule v : vehiculesByDate.get(i)) {
                System.out.println(v);
            }
        }
    }

    private void afficherVehicules() {
        for (Vehicule v : vehicules) {
            System.out.println(v);
        }
    }

    private void reviserToutesLesVehicules() {
        for (Vehicule v : vehicules) {
            v.setAnneeRevision(LocalDateTime.now().getYear());
        }
    }

    private void sortieVehicule(Vehicule v) {
        vehicules.remove(v);
    }

    private void entreeVehicule(Vehicule v) {
        vehicules.add(v);
    }
}
