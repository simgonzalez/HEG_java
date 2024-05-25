public class Mage extends Personnage {
  private int puissanceMagique;

  public Mage(String nom, int niveau, int pv, int pm, int pa, int pd,
              int puissanceMagique) {
    super(nom, niveau, pv, pm, pa, pd);
    this.puissanceMagique = puissanceMagique;
  }

  @Override
  public int getMontantAttaque() {
    return this.getPa() + this.puissanceMagique;
  }

  @Override
  public void attaquer(Personnage cible) {
    this.puissanceMagique += 1;
    cible.reduirePv(this.getMontantAttaque - cible.getPd());
  }

  @Override
  public void special() {
    this.setPa(this.getPa() * 2);
    this.setPm(this.getPm() - 10);
  }
}
