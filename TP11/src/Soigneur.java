public class Soigneur extends Personnage {
    private int recupPV;

    public Soigneur(String nom, int niveau, int pv, int pm, int pa, int pd, int recupPV) {
        super(nom, niveau, pv, pm, pa, pd);
        this.recupPV = recupPV;
    }

    @Override
    public void special() {
        if (this.getPm() < 10) {
            return;
        }
        this.setPv(this.getPv() + 10);
        this.setPm(this.getPm() - 10);
    }
}
