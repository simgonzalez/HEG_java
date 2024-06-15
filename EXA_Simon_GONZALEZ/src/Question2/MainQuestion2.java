package Question2;

public class MainQuestion2 {
    public static void main(String[] args) {

        //Créer une table Employe
        Table employe = new Table("Employe");

        System.out.println("\nInsertion des employés : ");
        for (String insertRequete : DB.GetInsertEmployes()) {
            try {
                employe.insertRecord(insertRequete);
            } catch (DoublonException | SyntaxException | TableInexistanteException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\nMise à jour des employés : ");
        for (String updateRequete : DB.GetUpdateEmployes()) {
            try {
                employe.updateRecord(updateRequete);
            } catch (SyntaxException | TableInexistanteException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("\nListe des employés : ");
        for (String selectRequete : DB.GetSelectEmployes()) {
            try {
                employe.selectRecord(selectRequete);
            } catch (SyntaxException | TableInexistanteException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
