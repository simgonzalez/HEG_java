import produits.Boisson;
import produits.Chocolat;
import produits.Espresso;
import produits.Macchiato;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;


public class GestionBoisson {
    private final static int IDX_QTY = 0;
    private final static int IDX_CLASS = 1;
    private final static int IDX_PRICE = 2;
    private final static int IDX_SIZE = 3;
    private final static int IDX_TYPE_OR_ORIGIN = 4;
    private final static int IDX_STRENGTH = 5;
    private final static int IDX_QTY_CREAM_OR_MILK = 6;
    private final static HashMap<Boisson, Integer> stock = new HashMap<>();

    public static void main(String[] args) {
        GestionBoisson gB = new GestionBoisson();
        String localDir = System.getProperty("user.dir");
        gB.chargerData(localDir + File.separator + "stock.csv");
        System.out.println("------ Affichage du Stock ------- \n");
        gB.afficherStock();
        System.out.println();
        System.out.println("------ Ventes de produits ------- \n");
        Boisson b = new Chocolat("produits.Chocolat", 1.5, 25, "au lait");
        gB.servirProduit(b);
        gB.servirProduit(b);
        gB.servirProduit(b);
        System.out.println();
        System.out.println("------ Affichage du Stock ------- \n");
        gB.afficherStock();

    }

    private void chargerData(String path) {
        for (String line : FileToStr.lireCsv(path)) {
            String[] element = line.split(";");
            switch (element[IDX_CLASS]) {
                case "Espresso":
                    stock.put(new Espresso(element[IDX_CLASS], Double.parseDouble(element[IDX_PRICE]), Integer.parseInt(element[IDX_SIZE]), element[IDX_TYPE_OR_ORIGIN], Integer.parseInt(element[IDX_STRENGTH]), Integer.parseInt(element[IDX_QTY_CREAM_OR_MILK])), Integer.parseInt(element[IDX_QTY]));
                    break;
                case "Macchiato":
                    stock.put(new Macchiato(element[IDX_CLASS], Double.parseDouble(element[IDX_PRICE]), Integer.parseInt(element[IDX_SIZE]), element[IDX_TYPE_OR_ORIGIN], Integer.parseInt(element[IDX_STRENGTH]), Integer.parseInt(element[IDX_QTY_CREAM_OR_MILK])), Integer.parseInt(element[IDX_QTY]));
                    break;
                case "produits.Chocolat":
                case "Chocolat":
                    stock.put(new Chocolat(element[IDX_CLASS], Double.parseDouble(element[IDX_PRICE]), Integer.parseInt(element[IDX_SIZE]), element[IDX_TYPE_OR_ORIGIN]), Integer.parseInt(element[IDX_QTY]));
                    break;
                default:
                    System.out.println("Type de produit non reconnu : " + element[IDX_CLASS] + "\nRaw line: " + line);
                    break;
            }
        }
    }

    public void afficherStock() {
        for (Boisson b : stock.keySet()) {
            String unties = stock.get(b) > 2 ? stock.get(b) + " Unités" : stock.get(b) + " Unités /!\\ à réapprovisionner !";
            System.out.println(b + " : " + unties + "\n    - "+ b.allergie() + "\n");
        }
    }

    public void servirProduit(Boisson b1) {
        for (Boisson b: stock.keySet()) {
            if (b.equals(b1)) {
                if (stock.get(b) > 0) {
                    stock.put(b, stock.get(b) - 1);
                    System.out.println(b + " servi. Santé !");
                } else {
                    System.out.println("Impossible de réaliser l'opération le produit n'est plus en stock !");
                }
                return;
            }
        }
    }
}
