package Question2;

public class Match extends Competition {
    private Equipe equipeExterne;
    private Equipe equipeDomicile;

    public Match(Equipe equipeExterne, Equipe equipeDomicile, String date, String lieu) {
        super(lieu, date);
        this.equipeExterne = equipeExterne;
        this.equipeDomicile = equipeDomicile;
    }

    public void jouer() {
        System.out.println(this.toString() + "L'équipe " + getWinner().getNomClub() + " a gagné");
    }

    public Equipe getWinner() {
        return equipeDomicile.getScoreEquipe() > equipeExterne.getScoreEquipe() ? equipeDomicile : equipeExterne;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Match de Basket entre ").append(equipeDomicile.getNomClub()).append(" et ").append(equipeExterne.getNomClub());
        sb.append(", le ").append(getDate()).append(" à ").append(getLieu()).append("\n");
        sb.append(equipeDomicile.toString()).append("\n").append(equipeExterne.toString()).append("\n");
        return sb.toString();
    }
}
