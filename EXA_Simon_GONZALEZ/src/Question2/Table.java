package Question2;

import java.util.ArrayList;
import java.util.HashSet;

public class Table {
    private static final String ERR_CMD = "cmd";
    private static final String ERR_END = "end";

    private String nom;
    private HashSet<Record> records;

    public Table(String nom) {
        this.nom = nom;
        this.records = new HashSet<>();
    }

    /**
     * Insère un enregistrement dans la table
     * @param requete requête d'insertion a executer
     * @throws SyntaxException si la syntaxe de la requête est incorrecte
     * @throws TableInexistanteException si la table n'existe pas
     * @throws DoublonException si le record existe déjà dans la base de données
     */
    public void insertRecord(String requete) throws SyntaxException, TableInexistanteException, DoublonException {
        if (!requete.startsWith("INSERT ")) {
            exceptionDeSyntaxe(ERR_CMD);
        }
        verifierRequete(requete, requete.split(" ")[2].trim());

        // Traitement de la requete
        String values = requete.substring(requete.indexOf("VALUES (") + 8, requete.lastIndexOf(")"));
        String[] record = values.split(",");
        Record r = new Record(record[0].trim(), record[1].trim(), record[2].trim());
        // vérification des doublons
        if (records.contains(r)) {
            throw new DoublonException("Le record existe déjà dans la base de données!");
        }
        // ajout au record
        records.add(r);
    }


    /**
     * Met à jour les enregistrements en fonction de la requête
     * @param requete requête de mise à jour a executer
     * @throws SyntaxException si la syntaxe de la requête est incorrecte
     * @throws TableInexistanteException si la table ne correspond pas a la table actuelle
     */
    public void updateRecord(String requete) throws SyntaxException, TableInexistanteException {
        if (!requete.startsWith("UPDATE ")) {
            exceptionDeSyntaxe(ERR_CMD);
        }
        verifierRequete(requete, requete.split(" ")[1].trim());

        // Traitement de la requete
        String set = requete.substring(requete.indexOf("SET"), requete.lastIndexOf("WHERE"));
        String[] record = set.split(",");

        String where = requete.substring(requete.indexOf("WHERE") + 6, requete.lastIndexOf(";"));
        ArrayList<Record> recordsToUpdate = findRecords(where.split("LIKE")[0].trim(), where.split("LIKE")[1].trim());

        for (String r : record) {
            String[] champ = r.split("=");
            for (Record recToUpdate : recordsToUpdate) {
                recToUpdate.setChamp(champ[0].trim(), champ[1].trim());
            }
        }
    }

    /**
     * Sélectionne les enregistrements en fonction de la requête
     * @param requete requête de sélection a executer
     * @throws SyntaxException si la syntaxe de la requête est incorrecte
     * @throws TableInexistanteException si la table n'existe pas
     */
    public void selectRecord(String requete) throws SyntaxException, TableInexistanteException {
        if (!requete.startsWith("SELECT ")) {
            exceptionDeSyntaxe(ERR_CMD);
        }
        verifierRequete(requete, requete.split(" ")[3].trim());

        // Traitement de la requete
        String where = requete.substring(requete.indexOf("WHERE") + 6, requete.lastIndexOf(";"));
        ArrayList<Record> records = findRecords(where.split("LIKE")[0].trim(), where.split("LIKE")[1].trim());
        for (Record r : records) {
            System.out.println(r.toEmploye());
        }
    }

    /**
     * Vérifie si la requête est valide se terminant par ;
     * TODO améliorer la généralisation de la vérification /!\ Si on ajoute juste un ET pour tous les mots clefs un UPDATE pourrait être mis dans un select ce qui n'est pas bon
      * @param requete
     */
    private void verifierRequete(String requete, String tableRequete) throws SyntaxException, TableInexistanteException {
        if (!requete.trim().endsWith(";")) {
            exceptionDeSyntaxe(ERR_END);
        }
        if (!tableRequete.equals(this.nom)) {
            throw new TableInexistanteException("La table <" + tableRequete + "> n'existe pas!");
        }
    }

    /**
     * Génère une exception de syntaxe en fonction du type
     * @param type type d'exception de syntaxe
     * @throws SyntaxException
     */
    private void exceptionDeSyntaxe(String type) throws SyntaxException {
        if (type.equals(ERR_CMD)) {
            throw new SyntaxException("La commande ne correspond pas au type de requête!");
        } else if (type.equals(ERR_END)) {
            throw new SyntaxException("La requête doit se terminer par un point-virgule!");
        } else {
            throw new SyntaxException("Erreur de syntaxe!");
        }
    }

    private ArrayList<Record> findRecords(String key, String value) {
        ArrayList<Record> records = new ArrayList<>();
        for (Record r : this.records) {
            if (r.getChamp(key).equals(value)) {
                records.add(r);
            }
        }
        return records;
    }
}
