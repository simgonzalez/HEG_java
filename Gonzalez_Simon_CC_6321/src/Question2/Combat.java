package Question2;

public class Combat extends Competition {
    private Combattant champion;
    private Combattant challenger;

    public Combat(String lieu, String date, Combattant champion, Combattant challenger) {
        super(lieu, date);
        this.champion = champion;
        this.challenger = challenger;
    }

    public void combattre() {
        if (this.champion.getCategorie() != this.challenger.getCategorie()) {
            System.out.println("Un combat entre deux combattants de catégorie différentes ne peut pas avoir lieu !");
            return;
        }
        System.out.println(this.toString() + "\nLe combat a été remporté par :\n" + this.getWinner());
    }

    /**
     * définit le vainceur en fonction de son poids
     * s'il font le même poids prend celui avec le plus de victoire
     *
     * @return combattant vainceur du match
     */
    public Combattant getWinner() {
        return champion.getPoids() == challenger.getPoids() ? champion.getNbVictoires() > challenger.getNbVictoires() ? champion : challenger : champion.getPoids() > challenger.getPoids() ? champion : challenger;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Combat de ");
        sb.append(champion.getClass().getSimpleName()).append(" à ").append(getLieu()).append(" le ").append(getDate()).append(": \n");
        sb.append(champion).append("\nVS.\n");
        sb.append(challenger);
        return sb.toString();
    }
}
