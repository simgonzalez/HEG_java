public class Guerrier extends Personnage {
  private int resistance;

  public Guerrier(String nom, int niveau, int pv, int pm, int pa, int pd,
                  int resistance) {
    super(nom, niveau, pv, pm, pa, pd);
    this.resistance = resistance;
  }

  @Override
  public void reduirePv(int montant) {
    int degatApresReduction =
        montant - this.getPd() -
        this.resistance this.setPv(
            this.getPv() - (degatApresReduction < 0 ? 0 : degatApresReduction));
  }

  @Override
  public void defendre() {
    super.defendre();
    this.setPd(this.getPd());
  }

  @Override
  public void special() {
    this.resistance *= 2;
  }
}
