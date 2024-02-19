public class Main {
    public static void main(String[] args) {
        Entreprise e1 = new Entreprise("Agrofi", "Chemin de l'usine 82b", Entreprise.EnterpriseType.PRIVEE, 3, "Alimentaire", 42, "Charles Agrofi");
        e1.showInformations();
        e1.setNoBuilding(5);
        e1.showInformations();
        e1.setType(Entreprise.EnterpriseType.PUBLIQUE);
        e1.showInformations();
        Employee empl1 = new Employee("Dupont", "Jean", "Chemin de la route 35", "Comptable", 7, 10700);
        empl1.showInformation();
    }
}