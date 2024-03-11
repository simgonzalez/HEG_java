import java.util.ArrayList;

public class Restaurant {
    private static ArrayList<Menu> menus = new ArrayList<>();

    public static void main(String[] args) {

        Plat p1 = new Plat("Cassoulet", "Plat");
        Plat p2 = new Plat("Pâtes au saumon", "Plat");
        Plat p3 = new Plat("Salade verte", "Entrée");
        Plat p4 = new Plat("Assiette Valaisanne", "Entrée/Plat");
        Plat p5 = new Plat("Coupe Danemark", "Dessert");
        Plat p6 = new Plat("Quiche Lorraine", "Plat");
        Plat p7 = new Plat("Pizza 4 saisons", "Plat");
        Plat p8 = new Plat("Tartare d'aubergines", "Entrée");
        Plat p9 = new Plat("Salade Niçoise", "Entrée/Plat");
        Plat p10 = new Plat("Profiteroles", "Dessert");
        Menu m1 = new Menu("du jour", 35);
        Menu m2 = new Menu("de saison", 40);
        Menu m3 = new Menu("duo", 60);
        Menu m4 = new Menu("enfant", 25);
        Menu m5 = new Menu("découverte", 45);

        m1.addPlat(p1);
        m1.addPlat(p2);
        m1.addPlat(p5);
        menus.add(m1);
        m2.addPlat(p1);
        m2.addPlat(p1);
        m2.addPlat(p1);
        m2.addPlat(p1);
        m2.addPlat(p1);
        m2.addPlat(p1);
        menus.add(m2);
        searchPlatInMenus(p6);
        searchPlatInMenus(p1);
        searchPlatInMenus(p10);
    }

    public static void searchPlatInMenus(Plat platToFind) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\nRecherche de plat %s", platToFind.toString()));
        boolean isPlatFound = false;

        for (Menu m : menus) {
            if (m.isPlatInMenu(platToFind)) {
                isPlatFound = true;
                sb.append(String.format("\nLe %s %s se trouve dans le menu %s à %.2f composé de :\n", platToFind.getTypePlat(), platToFind, m.getNom(), m.getPrix()));

                // Ajouter à l'affichage les plats qui compose le menu
                String plats = "     ";
                for (Plat p: m.getPlats()) {
                    plats += p.toString() + ' ';
                }
                sb.append(plats);
            }
        }

        if (!isPlatFound) {
            sb.append(String.format("\n    Le plat %s n'est dans aucun menu", platToFind));
        }
        System.out.println(sb);
    }
}
