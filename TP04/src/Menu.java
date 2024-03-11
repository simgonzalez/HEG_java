import java.util.ArrayList;

public class Menu {
    private String nom;
    private double prix;
    private ArrayList<Plat> plats = new ArrayList<>();

    public Menu(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public double getPrix() {
        return prix;
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<Plat> getPlats() {
        return plats;
    }

    public void addPlat(Plat plat) {
        if (plats.size() >= 5) {
            System.out.println("Erreur: Il ne peut pas y avoir plus de 5 plats dans un menu.");
            return;
        }
        plats.add(plat);
    }

    public boolean isPlatInMenu(Plat platToFind) {
        for (Plat p: plats) {
            if (p.equals(platToFind)){
                return true;
            }
        }
        return false;
    }
}
