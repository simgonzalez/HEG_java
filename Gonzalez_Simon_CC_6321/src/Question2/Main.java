package Question2;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        //Creation des Sportifs de Boxe
        Combattant boxeur1 = new Boxeur("Ali", "Mohamed", 10, "USA", 80, 8, 10, 4);
        Combattant boxeur2 = new Boxeur("Tyson", "Mike", 15, "USA", 95, 5, 20, 5);
        Combattant boxeur3 = new Boxeur("Mayweather", "Floyd", 20, "USA", 70, 30, 0, 0);
        Combattant boxeur4 = new Boxeur("Pacquiao", "Manny", 25, "Philippines", 65, 40, 5, 10);

        //Creation des Sportifs de Karaté
        Combattant karateka1 = new Karateka("Lee", "Bruce", 20, "Chine", 70, 7, 30, "Noire");
        Combattant karateka2 = new Karateka("Norris", "Chuck", 5, "USA", 80, 8, 5, "Blanche");
        Combattant karateka3 = new Karateka("Van Damme", "Jean-Claude", 15, "Belgique", 75, 10, 10, "Marron");
        Combattant karateka4 = new Karateka("Li", "Jet", 10, "Chine", 85, 15, 15, "Noire");

        //Creation de 10 sportifs de joueur de Basket
        JoueurBasket joueurBasket1 = new JoueurBasket("Jordan", "Michael", 20, "USA", 90, 65);
        JoueurBasket joueurBasket2 = new JoueurBasket("Bryant", "Kobe", 15, "USA", 85, 80);
        JoueurBasket joueurBasket3 = new JoueurBasket("James", "Lebron", 10, "USA", 100, 75);
        JoueurBasket joueurBasket4 = new JoueurBasket("Curry", "Stephen", 5, "USA", 80, 70);
        JoueurBasket joueurBasket5 = new JoueurBasket("Durant", "Kevin", 10, "USA", 90, 85);
        JoueurBasket joueurBasket6 = new JoueurBasket("Nowitzki", "Dirk", 15, "Allemagne", 95, 90);
        JoueurBasket joueurBasket7 = new JoueurBasket("Gasol", "Pau", 20, "Espagne", 100, 95);
        JoueurBasket joueurBasket8 = new JoueurBasket("Parker", "Tony", 5, "France", 75, 60);
        JoueurBasket joueurBasket9 = new JoueurBasket("Ginobili", "Manu", 10, "Argentine", 80, 70);
        JoueurBasket joueurBasket10 = new JoueurBasket("Nash", "Steve", 15, "Canada", 85, 20);

        //Creation de 2 combats de Boxe, le premier ne peut pas avoir lieu, car les deux boxeurs n'ont pas la même catégorie, le deuxième peut avoir lieu
        Combat combatPasOk = new Combat("Las Vegas", "15/05/2020", boxeur1, boxeur2);
        Combat combatOk = new Combat("New York", "20/05/2020", boxeur3, boxeur4);

        System.out.println();
        combatPasOk.combattre();
        System.out.println();
        combatOk.combattre();
        System.out.println();

        //Creation de 2 equipes de Basket et d'un match entre les deux equipes
        HashMap<Integer, JoueurBasket> joueursBasketMap1 = new HashMap<>();
        joueursBasketMap1.put(12, joueurBasket1);
        joueursBasketMap1.put(4, joueurBasket2);
        joueursBasketMap1.put(66, joueurBasket3);
        joueursBasketMap1.put(49, joueurBasket4);
        joueursBasketMap1.put(18, joueurBasket5);

        Equipe equipe1 = new Equipe("Lakers", joueursBasketMap1);

        HashMap<Integer, JoueurBasket> joueursBasketMap2 = new HashMap<>();
        joueursBasketMap2.put(41, joueurBasket6);
        joueursBasketMap2.put(16, joueurBasket7);
        joueursBasketMap2.put(9, joueurBasket8);
        joueursBasketMap2.put(20, joueurBasket9);
        joueursBasketMap2.put(13, joueurBasket10);

        Equipe equipe2 = new Equipe("Spurs", joueursBasketMap2);

        Match match = new Match(equipe1, equipe2, "25/05/2020", "Los Angeles");
        match.jouer();

    }
}
